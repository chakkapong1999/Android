package com.tni.max.recipesrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {

    //public static String position;
    private final LinkedList<String> mRecipeHeader;
    private final LinkedList<String> mRecipeIntro;
    private Context context;
    private LayoutInflater mInflater;

    public RecipeListAdapter(Context context, LinkedList<String> recipeHeader, LinkedList<String> recipeIntro) {
        mInflater = LayoutInflater.from(context);
        mRecipeHeader = recipeHeader;
        mRecipeIntro = recipeIntro;
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView recipeItemHeader;
        public final TextView recipeItemIntro;
        final RecipeListAdapter mAdapter;

        public RecipeViewHolder (View itemView, RecipeListAdapter adapter){
            super(itemView);
            context = itemView.getContext();
            recipeItemHeader = itemView.findViewById(R.id.recipe_header);
            recipeItemIntro = itemView.findViewById(R.id.recipe_intro);
            mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            //Use that to access the affected them
            String element = mRecipeHeader.get(mPosition);
            //To the second activity

            Intent intent;
            intent =  new Intent(context, FullRecipe.class);
            // intent.putExtra(position, mPosition);
            intent.putExtra("recipe", element);
            intent.putExtra("position", mPosition);
            context.startActivity(intent);
            //notify the adapter
            mAdapter.notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.activity_recipe_list_adapter, parent, false);
        return new RecipeViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        String mHeader = mRecipeHeader.get(position);
        String mIntro = mRecipeIntro.get(position);
        holder.recipeItemHeader.setText(mHeader);
        holder.recipeItemIntro.setText(mIntro);
    }


    @Override
    public int getItemCount() {
        return mRecipeHeader.size();
    }
}
