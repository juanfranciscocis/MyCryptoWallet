package com.example.mycryptowallet2_0;

import com.example.mycryptowallet2_0.ASSETS.C_AssetController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MAIN_MENU.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("MyCryptoWallet");
        stage.setScene(scene);
        stage.show();

        //WHEN INITIALIZING THE APP, WE CREATE THE ASSET CONTROLLER AND SAVE ALL ASSETS IN AN ARRAY, THEN THE CONTROLLER TO ITS OWN FILE
        C_AssetController c_assetController = new C_AssetController();
        c_assetController.setC_newAssetArrayList(new C_Files().readAssets());
        new C_Files().writeAssetController(c_assetController);



    }

    public static void main(String[] args) {
        launch();
    }
}