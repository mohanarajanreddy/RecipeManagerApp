package com.mycompany.recipemanagerapp.view;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import com.mycompany.recipemanagerapp.model.Recipe;

public class RecipeView {
    private VBox view;

    public RecipeView(Recipe recipe) {
        view = new VBox();
        Text name = new Text("Recipe Name: " + recipe.getName());
        Text ingredients = new Text("Ingredients: " + recipe.getIngredients());
        Text instructions = new Text("Instructions: " + recipe.getInstructions());

        view.getChildren().addAll(name, ingredients, instructions);
    }

    public VBox getView() {
        return view;
    }
}
