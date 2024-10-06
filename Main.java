package com.mycompany.recipemanagerapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import com.mycompany.recipemanagerapp.controller.RecipeController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        RecipeController controller = new RecipeController();
        StackPane root = controller.getView();

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Recipe Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
