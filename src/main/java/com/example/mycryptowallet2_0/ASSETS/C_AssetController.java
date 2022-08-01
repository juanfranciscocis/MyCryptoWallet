package com.example.mycryptowallet2_0.ASSETS;

import java.io.Serializable;
import java.util.ArrayList;

public class C_AssetController implements Serializable {
    //DATA MEMBERS
    private ArrayList<C_NewAsset> c_newAssetArrayList = new ArrayList<>();

    //FUNCTION MEMBERS
    //CONSTRUCTOR
    public C_AssetController() {
    }

    //GETTERS AND SETTERS
    public ArrayList<C_NewAsset> getC_newAssetArrayList() {
        return c_newAssetArrayList;
    }

    public void setC_newAssetArrayList(ArrayList<C_NewAsset> c_newAssetArrayList) {
        this.c_newAssetArrayList = c_newAssetArrayList;
    }


    //CALCULATING THE TOTAL VALUE OF THE ASSETS
    public float getTotalValue(){
        float totalValue = 0;
        for (int i = 0 ; i<c_newAssetArrayList.size(); i++){
            totalValue += c_newAssetArrayList.get(i).getActualValue();
        }
        System.out.println("TOTAL VALUE CALCULATED SUCCESSFULLY (ASSET CONTROLLER)");
        return totalValue;
    }



}
