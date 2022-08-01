package com.example.mycryptowallet2_0.FML_CONTROLLERS;

import com.example.mycryptowallet2_0.USER_HELPER.C_Information;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class INFORMATION_POPUP_Controller {

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @FXML
    private Label infoToShow;

    @FXML
    void initialize() {
        assert infoToShow != null : "fx:id=\"infoToShow\" was not injected: check your FXML file 'INFORMATION_POPUP.fxml'.";
        infoToShow.setText(new C_Information(getCode()).getCode());
    }







}
