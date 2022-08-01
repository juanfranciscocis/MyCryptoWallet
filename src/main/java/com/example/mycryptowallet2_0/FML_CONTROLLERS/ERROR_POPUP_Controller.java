package com.example.mycryptowallet2_0.FML_CONTROLLERS;

import com.example.mycryptowallet2_0.USER_HELPER.C_Exceptions;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ERROR_POPUP_Controller {

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @FXML
    private Label errorToShow;

    @FXML
    void initialize() {
        assert errorToShow != null : "fx:id=\"infoToShow\" was not injected: check your FXML file 'INFORMATION_POPUP.fxml'.";
        errorToShow.setText(new C_Exceptions(getCode()).getCode());
    }







}
