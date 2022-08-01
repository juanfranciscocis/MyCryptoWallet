package com.example.mycryptowallet2_0;

import com.example.mycryptowallet2_0.ASSETS.C_AssetController;
import com.example.mycryptowallet2_0.ASSETS.C_NewAsset;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class C_Files {
    //DATA MEMBERS
    //NONE

    //FUNCTION MEMBERS
    //CONSTRUCTOR
    public C_Files() {
    }

    //SAVING ASSETS
    public void writeAssets(C_NewAsset c_newAsset) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Assets.dat", true)));) {
            objectOutputStream.writeObject(c_newAsset);
            System.out.println("ASSET SAVED (FILE RESPONSE)");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //READING ASSETS
    public ArrayList<C_NewAsset> readAssets() {

        ArrayList<C_NewAsset> list = new ArrayList<C_NewAsset>();
        try {
            FileInputStream istream = new FileInputStream("Assets.dat");
            ObjectInputStream ois = null;


            while (istream.available() > 0) {
                ois = new ObjectInputStream(istream);
                C_NewAsset c_newAsset = (C_NewAsset) ois.readObject();
                list.add(c_newAsset);
            }
            System.out.println("ASSETS SIZE: " + list.size() + "(FILE RESPONSE)");

        } catch (Exception e) {
            System.out.println(e);
        }


        return list;


    }


    //SAVING THE ASSET CONTROLLER
    public void writeAssetController(C_AssetController c_assetController) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("AssetController.dat", false)));) {
            objectOutputStream.writeObject(c_assetController);
            System.out.println("ASSET CONTROLLER SAVED (FILE RESPONSE)");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //READING THE ASSET CONTROLLER
    public ArrayList<C_AssetController> readAssetController() {

        ArrayList<C_AssetController> list = new ArrayList<C_AssetController>();
        try {
            FileInputStream istream = new FileInputStream("AssetController.dat");
            ObjectInputStream ois = null;


            while (istream.available() > 0) {
                ois = new ObjectInputStream(istream);
                C_AssetController c_assetController = (C_AssetController) ois.readObject();
                list.add(c_assetController);
            }

        } catch (Exception e) {
            System.out.println(e);
        }


        return list;


    }

    //SAVING THE GAIN LOSS
    public void writeGainLoss(float gainLoss) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("GainLoss.dat", false)));) {
            objectOutputStream.writeObject(gainLoss);
            System.out.println("GAIN LOSS SAVED (FILE RESPONSE)");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //READING THE GAIN LOSS
    public ArrayList<Float> readGainLoss() {

        ArrayList<Float> list = new ArrayList<Float>();
        try {
            FileInputStream istream = new FileInputStream("GainLoss.dat");
            ObjectInputStream ois = null;


            while (istream.available() > 0) {
                ois = new ObjectInputStream(istream);
                float gainLoss = (Float) ois.readObject();
                list.add(gainLoss);
            }

        } catch (Exception e) {
            System.out.println(e);
        }


        return list;


    }


    //SAVING THE CURRENT DATE
    public void writeCurrentDate(Date date) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("CurrentDate.dat", false)));) {
            objectOutputStream.writeObject(date);
            System.out.println("DATE SAVED!!! (FILE RESPONSE)");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //READING THE CURRENT DATE
    //READING THE GAIN LOSS
    public ArrayList<Date> readPassedDate() {

        ArrayList<Date> list = new ArrayList<Date>();
        try {
            FileInputStream istream = new FileInputStream("CurrentDate.dat");
            ObjectInputStream ois = null;


            while (istream.available() > 0) {
                ois = new ObjectInputStream(istream);
                Date date = (Date) ois.readObject();
                list.add(date);
            }

        } catch (Exception e) {
            Date date = new Date(System.currentTimeMillis());
            writeCurrentDate(date);
            System.out.println("FIRST DATE SAVED (FILE RESPONSE)");
        }


        return list;


    }



}
