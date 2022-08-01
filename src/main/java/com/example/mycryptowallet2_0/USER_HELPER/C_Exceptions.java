package com.example.mycryptowallet2_0.USER_HELPER;

public class C_Exceptions extends Exception{
    //DATA MEMBERS
    private int code;

    //FUNCTION MEMBERS
    //CONSTRUCTOR
    public C_Exceptions(int code) {
        this.code = code;
    }

    //GETTERS AND SETTERS
    public String getCode() {
        String errorMessage = "UNKNOWN ERROR";
        switch (code){
            case 1:
                errorMessage = "ID NOT FOUNDED"; //THE API RETURNS NONE PRICE DUE TO NOT FOUNDING THE ID ON THE DATA BASE
                break;
            case 2:
                errorMessage = "PLEASE ENTER ALL DATA CORRECTLY";
                break;
            case 3:
                errorMessage = "PICK AN ASSET FIRST, THEN DELETE IT";
                break;

        }
        return errorMessage;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
