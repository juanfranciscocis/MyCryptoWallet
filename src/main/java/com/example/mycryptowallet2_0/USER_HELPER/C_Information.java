package com.example.mycryptowallet2_0.USER_HELPER;

public class C_Information{

    //DATA MEMBERS
    private int code;



    //FUNCTION MEMBERS
    //CONSTRUCTOR
    public C_Information(int infoCode) {
        this.code = infoCode;

    }

    //GETTERS AND SETTERS


    public String getCode() {
        String message = "NO INFO TO SHOW";
        switch (code){
            case 1:
               message= "THE ID OF THE COINS CAN BE FOUNDED ON https://www.coingecko.com";
                break;

            case 2:
                message = "THE ID OF THE COINS CAN BE FOUNDED ON https://www.coingecko.com \n QUANTITY OF COINS REFERS TO THE NUMBER OF COINS BOUGHT \n ENTER PRICE REFERS TO THE BOUGHT PRICE PER COIN \n CHOOSE THE EXCHANGE/WALLET THE ASSET RESIDES";
                break;

            case 3:
                message = "THE ASSET WAS SAVED SUCCESSFULLY";
                break;

            case 4:
                message = "THE ASSET WAS DELETED SUCCESSFULLY";
                break;

            case 5:
                message = "THE ASSET WAS UPDATED SUCCESSFULLY";
                break;

            case 6:
                message = "RELOAD SUCCESSFUL";
                break;

                case 7:
                message = "RELOADING PLEASE WAIT";
                break;

        }
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
