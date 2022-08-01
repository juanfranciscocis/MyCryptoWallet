package com.example.mycryptowallet2_0.ASSETS;

import com.example.mycryptowallet2_0.C_CoinGeckoApi;
//import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.io.Serializable;

public class C_NewAsset implements Serializable {

    //DATA MEMBERS
    private String id; //ID OF THE COIN -> FOR THE API
    private double quantity; //QUANTITY OF THE COIN THE USER BOUGHT
    private float price; //PRICE PER COIN THE USER BOUGHT
    private String exchange; //NAME OF THE EXCHANGE THE ASSET CAN BE FOUNDED
    private float marketPrice; //MARKET VALUE OF THE ASSET (CONNECTION TO THE API) -> GETTING THE PRICE
    private float actualValue; //ACTUAL VALUE OF THE ASSET (QUANTITY * MARKET PRICE)

    private float percentageToEarn; //PERCENTAGE TO EARN FROM THE ASSET


    //FUNCTION MEMBERS
    //CONSTRUCTOR
    public C_NewAsset(String id, double quantity, float price, String exchange,float percentageToEarn) throws  IOException, InterruptedException {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.exchange = exchange;
        this.percentageToEarn = percentageToEarn;
        setMarketPrice();
    }

    //GETTERS AND SETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public float getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice() throws  IOException, InterruptedException {
        //REACHING THE API AND GETTING THE MARKET PRICE
        marketPrice = Float.parseFloat(new C_CoinGeckoApi().cryptoPrice(id));
        System.out.println("MARKET PRICE UPDATED (ASSET RESPONSE)");
        setActualValue();
    }

    public float getActualValue() {
        return actualValue;
    }

    public void setActualValue() {
        //CALCULATING CUSTOMMER COIN PRICE
        this.actualValue = (float) (quantity * marketPrice);
    }

    public void setNewValue(float newValue){
        this.actualValue = newValue;
    }

    public float getPercentageToEarn() {
        return percentageToEarn;
    }

    public void setPercentageToEarn(float percentageToEarn) {
        this.percentageToEarn = percentageToEarn;
    }


}
