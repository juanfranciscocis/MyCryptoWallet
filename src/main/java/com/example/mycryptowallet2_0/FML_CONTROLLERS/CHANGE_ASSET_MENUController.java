package com.example.mycryptowallet2_0.FML_CONTROLLERS;

import com.example.mycryptowallet2_0.ASSETS.C_AssetController;
import com.example.mycryptowallet2_0.ASSETS.C_NewAsset;
import com.example.mycryptowallet2_0.C_Files;
import com.example.mycryptowallet2_0.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class CHANGE_ASSET_MENUController {

    //DATA MEMBERS
    private ArrayList<C_NewAsset> c_newAssetArrayList = new C_Files().readAssets();

    @FXML
    private ComboBox<String> newExchangeComboBox;

    @FXML
    private TextField newPercentageTextField;

    @FXML
    private TextField newPriceTextField;

    @FXML
    private TextField newQuantityTextField;

    @FXML
    private ComboBox<String> pickAssetFromListComboBox;

    @FXML
    void assetComboBoxPressed(MouseEvent event) {
        pickAssetFromListComboBox.getItems().clear();
        loadAssets(); //LOAD ASSETS TO COMBOBOX
    }

    @FXML
    void deleteAssetButton(MouseEvent event) throws IOException {

        try {
            //DELETE THE ASSET FROM THE ARRAYLIST
            System.out.println("DELETING ASSET (DELETE ASSET BUTTON)");
            int getComboboxIndex = pickAssetFromListComboBox.getSelectionModel().getSelectedIndex();
            c_newAssetArrayList.remove(getComboboxIndex);

            C_Files c_files = new C_Files();


            //DELETING ALL DATA FROM EXISTING FILE
            try (BufferedWriter bf = Files.newBufferedWriter(Path.of("Assets.dat"),
                    StandardOpenOption.TRUNCATE_EXISTING)) {
            } catch (IOException e) {
                e.printStackTrace();
            }

            //RE WRITING THE DATA TO THE FILE
            for (int i = 0; i < c_newAssetArrayList.size(); i++) {
                c_files.writeAssets(c_newAssetArrayList.get(i));
            }

            //UPDATING CONTROLLER WITH THE NEW ASSET
            C_AssetController c_assetController = new C_AssetController();
            c_assetController.setC_newAssetArrayList(c_newAssetArrayList);
            c_files.writeAssetController(c_assetController);


            //SHOWING THE INFORMATION POPUP
            Stage stage = new Stage();
            FXMLLoader fxmlInfo = new FXMLLoader(Main.class.getResource("INFORMATION_POPUP.fxml"));
            INFORMATION_POPUP_Controller information_popup_controller = new INFORMATION_POPUP_Controller();
            information_popup_controller.setCode(4);
            fxmlInfo.setController(information_popup_controller);
            Scene scene = new Scene(fxmlInfo.load());
            stage.setTitle("");
            stage.setScene(scene);
            stage.show();

        }catch (Exception e){
            //SHOWING ERROR POPUP
            Stage stage = new Stage();
            FXMLLoader fxmlInfo = new FXMLLoader(Main.class.getResource("ERROR_POPUP.fxml"));
            ERROR_POPUP_Controller error_popup_controller = new ERROR_POPUP_Controller();
            error_popup_controller.setCode(3);
            fxmlInfo.setController(error_popup_controller);
            Scene scene = new Scene(fxmlInfo.load());
            stage.setTitle("");
            stage.setScene(scene);
            stage.show();


        }






    }

    @FXML
    void changeAssetButton(MouseEvent event) throws IOException {

            try {
                //GETTING THE INDEX OF THE ASSET TO BE CHANGED
                int getComboboxIndex = pickAssetFromListComboBox.getSelectionModel().getSelectedIndex();
                C_NewAsset changingAsset = c_newAssetArrayList.get(getComboboxIndex);

                //GETTING THE NEW DATA FROM THE TEXT FIELDS
                String newExchange = newExchangeComboBox.getSelectionModel().getSelectedItem();
                String newPercentage = newPercentageTextField.getText();
                String newPrice = newPriceTextField.getText();
                String newQuantity = newQuantityTextField.getText();

                //SETTING THE NEW DATA TO THE ASSET
                changingAsset.setExchange(newExchange);
                changingAsset.setPercentageToEarn(Float.parseFloat(newPercentage));
                changingAsset.setPrice(Float.parseFloat(newPrice));
                changingAsset.setQuantity(Float.parseFloat(newQuantity));

                //UPDATING THE CONTROLLER WITH THE NEW ASSET
                C_AssetController c_assetController = new C_AssetController();
                c_newAssetArrayList.remove(getComboboxIndex);
                c_newAssetArrayList.add(getComboboxIndex, changingAsset);
                c_assetController.setC_newAssetArrayList(c_newAssetArrayList);
                C_Files c_files = new C_Files();
                c_files.writeAssetController(c_assetController);

                //DELETING ALL DATA FROM EXISTING FILE
                try (BufferedWriter bf = Files.newBufferedWriter(Path.of("Assets.dat"),
                        StandardOpenOption.TRUNCATE_EXISTING)) {
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //RE WRITING THE DATA TO THE FILE
                for (int i = 0; i < c_newAssetArrayList.size(); i++) {
                    c_files.writeAssets(c_newAssetArrayList.get(i));
                }

                //SHOWING THE INFORMATION POPUP
                Stage stage = new Stage();
                FXMLLoader fxmlInfo = new FXMLLoader(Main.class.getResource("INFORMATION_POPUP.fxml"));
                INFORMATION_POPUP_Controller information_popup_controller = new INFORMATION_POPUP_Controller();
                information_popup_controller.setCode(5);
                fxmlInfo.setController(information_popup_controller);
                Scene scene = new Scene(fxmlInfo.load());
                stage.setTitle("");
                stage.setScene(scene);
                stage.show();




            }catch (Exception e){
                System.out.println("ERROR CHANGING ASSET");
                //SHOWING ERROR POPUP
                Stage stage = new Stage();
                FXMLLoader fxmlInfo = new FXMLLoader(Main.class.getResource("ERROR_POPUP.fxml"));
                ERROR_POPUP_Controller error_popup_controller = new ERROR_POPUP_Controller();
                error_popup_controller.setCode(2);
                fxmlInfo.setController(error_popup_controller);
                Scene scene = new Scene(fxmlInfo.load());
                stage.setTitle("");
                stage.setScene(scene);
                stage.show();

            }


    }

    @FXML
    void informationNewAssetMenu(MouseEvent event) {



    }

    @FXML
    void initialize() {
        assert newExchangeComboBox != null : "fx:id=\"newExchangeComboBox\" was not injected: check your FXML file 'CHANGE_ASSET_MENU.fxml'.";
        assert newPercentageTextField != null : "fx:id=\"newPercentageTextField\" was not injected: check your FXML file 'CHANGE_ASSET_MENU.fxml'.";
        assert newPriceTextField != null : "fx:id=\"newPriceTextField\" was not injected: check your FXML file 'CHANGE_ASSET_MENU.fxml'.";
        assert newQuantityTextField != null : "fx:id=\"newQuantityTextField\" was not injected: check your FXML file 'CHANGE_ASSET_MENU.fxml'.";
        assert pickAssetFromListComboBox != null : "fx:id=\"pickAssetFromListComboBox\" was not injected: check your FXML file 'CHANGE_ASSET_MENU.fxml'.";

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
            newExchangeComboBox.getItems().add(exchangeNames.get(i));
        }

    }


    private void loadAssets(){
        System.out.println("LOAD ASSETS TO COMBOBOX (LOAD ASSETS FUNCTION)");
        ArrayList<String> assetName = new ArrayList<String>();
        for (int i = 0 ; i<c_newAssetArrayList.size();i++){
            assetName.add(c_newAssetArrayList.get(i).getId().toUpperCase());
        }
        for (int i = 0 ; i<assetName.size();i++){
            pickAssetFromListComboBox.getItems().add(assetName.get(i));
        }
    }


}
