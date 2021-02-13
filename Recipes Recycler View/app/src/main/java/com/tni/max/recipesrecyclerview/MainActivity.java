package com.tni.max.recipesrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.LinkedList;



public class MainActivity extends AppCompatActivity {
    private final LinkedList<String> mRecipeListHeader = new LinkedList<>();
    private final LinkedList<String> mRecipeListIntro = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private RecipeListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Put initial data.
        for (int i = 0; i < 12; i++){
            mRecipeListHeader.addLast(getResources().getStringArray(R.array.RecipeHeader)[i]);
            mRecipeListIntro.addLast(getResources().getStringArray(R.array.RecipeIntro)[i]);
        }

        //Get a handle to the RecyclerView
        mRecyclerView = findViewById(R.id.recipe_list);
        //Create an adapter and supply the data to be displayed.
        mAdapter = new RecipeListAdapter(this, mRecipeListHeader, mRecipeListIntro);
        //Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        //Give the recyclerview a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}