package com.tni.max.recipesrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class FullRecipe extends AppCompatActivity {

    private String mRecipe;
    private int mPosition;
    //String[] mRecipeBody = getResources().getStringArray(R.array.RecipeBody);
    private final LinkedList<String> mRecipeListBody = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_recipe);

        for (int i = 0; i < 12; i++){
            mRecipeListBody.addLast(getResources().getStringArray(R.array.RecipeBody)[i]);
        }

        mRecipe = getIntent().getExtras().getString("recipe");
        mPosition = getIntent().getExtras().getInt("position");

        TextView recipeTitle = findViewById(R.id.recipeHead);
        TextView recipeBody = findViewById(R.id.recipeBody);
        ImageView recipePic = findViewById(R.id.recipePic);

        String recipeFull = mRecipeListBody.get(mPosition);

        recipePic.setImageResource(recipePics[mPosition]);
        recipeTitle.setText(mRecipe);
        recipeBody.setText(recipeFull);

    }

    private int[] recipePics = {
            R.drawable.chocolate_mint_bar,
            R.drawable.blueberry_cupcakes,
            R.drawable.fudge_brownies,
            R.drawable.lemon_cake,
            R.drawable.cobbler,
            R.drawable.sheet_cake,
            R.drawable.espresso_crinkles,
            R.drawable.chocolate_cherry_cookies,
            R.drawable.cheesecake,
            R.drawable.tiramisu,
            R.drawable.carrot_cake,
            R.drawable.blueberry_ice_cream,
    };


}