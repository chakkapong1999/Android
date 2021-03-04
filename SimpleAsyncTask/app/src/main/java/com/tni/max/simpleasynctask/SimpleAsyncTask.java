package com.tni.max.simpleasynctask;


import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask <Void,Integer,String> {

    private WeakReference<TextView> mTextView;
    private WeakReference<ProgressBar> mProgress;
    int j;

    SimpleAsyncTask(TextView tv, ProgressBar pb){
        mTextView = new WeakReference<>(tv);
        mProgress = new WeakReference<>(pb);
    }

    @Override
    protected String doInBackground(Void... x) {
        Random r = new Random();
        int n = r.nextInt(11);
        int s = n * 200;
        j = s / 100;


        for (int i = 0; i < j; i++) {
            try {
                Thread.sleep(100);
                publishProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Awake at last after sleeping for " + s + " milliseconds!";
    }

    protected void onProgressUpdate(Integer...i) {
        super.onProgressUpdate(i);
        mTextView.get().setText("Remaining..." + i[0]*100 + " milliseconds");
        mProgress.get().setProgress((int)(i[0] / (float)j*100));
    }

    protected void onPostExecute(String result){
        mTextView.get().setText(result);
        mProgress.get().setProgress(100);
    }
}
