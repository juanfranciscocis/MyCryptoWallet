package com.example.mycryptowallet2_0.FML_CONTROLLERS;

import com.example.mycryptowallet2_0.C_CoinGeckoApi;
import com.example.mycryptowallet2_0.Main;
import com.example.mycryptowallet2_0.USER_HELPER.C_Exceptions;
//import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class COIN_PRICE_MEMUController {

    @FXML
    private TextField enteredIDCodeLTextField;

    @FXML
    private Label priceToShowLabel;

    @FXML
    void checkPriceButton(MouseEvent event) throws IOException, InterruptedException {
        //CONNECTION TO THE API
        C_CoinGeckoApi c_coinGeckoApi = new C_CoinGeckoApi();
        //ASKING COIN PRICE
        String priceFounded =c_coinGeckoApi.cryptoPrice(enteredIDCodeLTextField.getText().toLowerCase());

        if (priceFounded.equals("")){
            priceToShowLabel.setText(new C_Exceptions(1).getCode()); //CODE NOT FOUNDED
        }else {
            priceToShowLabel.setText("$"+String.valueOf(priceFounded)); //SHOWING THE PRICE TO THE USER
        }


    }

    @FXML
    void informationCheckCoinPriceMenu(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlInfo = new FXMLLoader(Main.class.getResource("INFORMATION_POPUP.fxml"));
        INFORMATION_POPUP_Controller information_popup_controller = new INFORMATION_POPUP_Controller();
        information_popup_controller.setCode(1);
        fxmlInfo.setController(information_popup_controller);
        Scene scene = new Scene(fxmlInfo.load());
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }



}
