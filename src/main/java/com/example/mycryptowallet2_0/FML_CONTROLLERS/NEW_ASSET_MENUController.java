package com.example.mycryptowallet2_0.FML_CONTROLLERS;

import com.example.mycryptowallet2_0.ASSETS.C_AssetController;
import com.example.mycryptowallet2_0.ASSETS.C_NewAsset;
import com.example.mycryptowallet2_0.C_Files;
import com.example.mycryptowallet2_0.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class NEW_ASSET_MENUController {

    @FXML
    private ComboBox<String> chooseExhangeComboBox;

    @FXML
    private TextField enteredPercentageTextField;

    @FXML
    private TextField enteredIDCodeLTextField;

    @FXML
    private TextField enteredPriceTextField;

    @FXML
    private TextField enteredQuantityTextField;

    @FXML
    void addAssetButton(MouseEvent event) throws IOException {
        try {
            //CREATING THE ASSET
            C_NewAsset c_newAsset = new C_NewAsset(enteredIDCodeLTextField.getText().toLowerCase(),Double.parseDouble(enteredQuantityTextField.getText()),Float.parseFloat(enteredPriceTextField.getText()),chooseExhangeComboBox.getSelectionModel().getSelectedItem(),Float.parseFloat(enteredPercentageTextField.getText()));
            new C_Files().writeAssets(c_newAsset);

            //UPDATING CONTROLLER WITH THE NEW ASSET
            C_AssetController c_assetController = new C_AssetController();
            c_assetController.setC_newAssetArrayList(new C_Files().readAssets());
            new C_Files().writeAssetController(c_assetController);

            Stage stage = new Stage();
            FXMLLoader fxmlInfo = new FXMLLoader(HelloApplication.class.getResource("INFORMATION_POPUP.fxml"));
            INFORMATION_POPUP_Controller information_popup_controller = new INFORMATION_POPUP_Controller();
            information_popup_controller.setCode(3);
            fxmlInfo.setController(information_popup_controller);
            Scene scene = new Scene(fxmlInfo.load());
            stage.setTitle("");
            stage.setScene(scene);
            stage.show();


        }catch (Exception e){
            Stage stage = new Stage();
            FXMLLoader fxmlError = new FXMLLoader(HelloApplication.class.getResource("ERROR_POPUP.fxml"));
            ERROR_POPUP_Controller error_popup_controller = new ERROR_POPUP_Controller();
            error_popup_controller.setCode(2);
            fxmlError.setController(error_popup_controller);
            Scene scene = new Scene(fxmlError.load());
            stage.setTitle("");
            stage.setScene(scene);
            stage.show();

        }








    }

    @FXML
    void informationNewAssetMenu(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlInfo = new FXMLLoader(HelloApplication.class.getResource("INFORMATION_POPUP.fxml"));
        INFORMATION_POPUP_Controller information_popup_controller = new INFORMATION_POPUP_Controller();
        information_popup_controller.setCode(2);
        fxmlInfo.setController(information_popup_controller);
        Scene scene = new Scene(fxmlInfo.load());
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        assert chooseExhangeComboBox != null : "fx:id=\"chooseExhangeComboBox\" was not injected: check your FXML file 'NEW_ASSET_MENU.fxml'.";
        assert enteredIDCodeLTextField != null : "fx:id=\"enteredIDCodeLTextField\" was not injected: check your FXML file 'NEW_ASSET_MENU.fxml'.";
        assert enteredPriceTextField != null : "fx:id=\"enteredPriceTextField\" was not injected: check your FXML file 'NEW_ASSET_MENU.fxml'.";
        assert enteredQuantityTextField != null : "fx:id=\"enteredQuantityTextField\" was not injected: check your FXML file 'NEW_ASSET_MENU.fxml'.";
        loadExchangeNames(); //LOAD EXCHANGE NAMES TO COMBOBOX








    }

    private void loadExchangeNames(){

        System.out.println("LOAD EXCHANGE NAMES TO COMBOBOX (LOAD EXCHANGE NAMES FUNCTION)");

        ArrayList<String> exchangeNames = new ArrayList<>();
        exchangeNames.add("BINANCE");
        exchangeNames.add("FTX");
        exchangeNames.add("BITGET");
        exchangeNames.add("METAMASK");
        exchangeNames.add("HONEYGAIN");
        exchangeNames.add("COINBASE");
        exchangeNames.add("OTHER");

        for (int i =0 ;i<exchangeNames.size();i++){
            chooseExhangeComboBox.getItems().add(exchangeNames.get(i));
        }

    }







}
