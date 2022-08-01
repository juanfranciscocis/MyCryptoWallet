package com.example.mycryptowallet2_0.FML_CONTROLLERS;

import com.example.mycryptowallet2_0.ASSETS.C_AssetController;
import com.example.mycryptowallet2_0.ASSETS.C_NewAsset;
import com.example.mycryptowallet2_0.C_Files;
import com.example.mycryptowallet2_0.Main;
//import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MAIN_MENUController {
    @FXML
    private Label actualPrice0;

    @FXML
    private Label actualPrice1;

    @FXML
    private Label actualPrice10;

    @FXML
    private Label actualPrice11;

    @FXML
    private Label actualPrice12;

    @FXML
    private Label actualPrice2;

    @FXML
    private Label actualPrice3;

    @FXML
    private Label actualPrice4;

    @FXML
    private Label actualPrice5;

    @FXML
    private Label actualPrice6;

    @FXML
    private Label actualPrice7;

    @FXML
    private Label actualPrice8;

    @FXML
    private Label actualPrice9;

    @FXML
    private Label cryptoHolding0;

    @FXML
    private Label cryptoHolding1;

    @FXML
    private Label cryptoHolding10;

    @FXML
    private Label cryptoHolding11;

    @FXML
    private Label cryptoHolding12;

    @FXML
    private Label cryptoHolding2;

    @FXML
    private Label cryptoHolding3;

    @FXML
    private Label cryptoHolding4;

    @FXML
    private Label cryptoHolding5;

    @FXML
    private Label cryptoHolding6;

    @FXML
    private Label cryptoHolding7;

    @FXML
    private Label cryptoHolding8;

    @FXML
    private Label cryptoHolding9;

    @FXML
    private Label exchange1Label;
    @FXML
    private Label exchange2Label;
    @FXML
    private Label exchange3Label;

    @FXML
    private Label exchange4Label;

    @FXML
    private Label exchange5Label;

    @FXML
    private Label exchange6Label;

    @FXML
    private Label exchange7Label;

    @FXML
    private Label exchangePrice1Label;

    @FXML
    private Label exchangePrice2Label;

    @FXML
    private Label exchangePrice3Label;

    @FXML
    private Label exchangePrice4Label;

    @FXML
    private Label exchangePrice5Label;

    @FXML
    private Label exchangePrice6Label;

    @FXML
    private Label exchangePrice7Label;

    @FXML
    private Label exhange2Label;

    @FXML
    private Label marketPrice0;

    @FXML
    private Label marketPrice1;

    @FXML
    private Label marketPrice10;

    @FXML
    private Label marketPrice11;

    @FXML
    private Label marketPrice12;

    @FXML
    private Label marketPrice2;

    @FXML
    private Label marketPrice3;

    @FXML
    private Label marketPrice4;

    @FXML
    private Label marketPrice5;

    @FXML
    private Label marketPrice6;

    @FXML
    private Label marketPrice7;

    @FXML
    private Label marketPrice8;

    @FXML
    private Label marketPrice9;

    @FXML
    private Label name0;

    @FXML
    private Label name1;

    @FXML
    private Label name10;

    @FXML
    private Label name11;

    @FXML
    private Label name12;

    @FXML
    private Label name2;

    @FXML
    private Label name3;

    @FXML
    private Label name4;

    @FXML
    private Label name5;

    @FXML
    private Label name6;

    @FXML
    private Label name7;

    @FXML
    private Label name8;

    @FXML
    private Label name9;

    @FXML
    private Label totalBalanceLabel;

    @FXML
    private Label totalBalanceLossGainLabel;

    @FXML
    void changeAssetsButton(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fmxlChangeAssetsMenu = new FXMLLoader(Main.class.getResource("CHANGE_ASSET_MENU.fxml"));
        Scene scene = new Scene(fmxlChangeAssetsMenu.load());
        stage.setTitle("CHANGE ASSETS");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void checkCoinPriceButton(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlCoincheckerMenu = new FXMLLoader(Main.class.getResource("COIN_PRICE_MENU.fxml"));
        Scene scene = new Scene(fxmlCoincheckerMenu.load());
        stage.setTitle("CHECK PRICES");
        stage.setScene(scene);
        stage.show();

    }
    
    @FXML
    void newAssetButton(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlCoincheckerMenu = new FXMLLoader(Main.class.getResource("NEW_ASSET_MENU.fxml"));
        Scene scene = new Scene(fxmlCoincheckerMenu.load());
        stage.setTitle("ADD CRYPTO TO PORTAFOLIO");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void refreshPricesButton(MouseEvent event) throws IOException, InterruptedException {
        refreshData();
        //SHOWING THE INFORMATION POPUP
        Stage stage = new Stage();
        FXMLLoader fxmlInfo = new FXMLLoader(Main.class.getResource("INFORMATION_POPUP.fxml"));
        INFORMATION_POPUP_Controller information_popup_controller = new INFORMATION_POPUP_Controller();
        information_popup_controller.setCode(6);
        fxmlInfo.setController(information_popup_controller);
        Scene scene = new Scene(fxmlInfo.load());
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    private void refreshData(){


        try{
            ArrayList<C_NewAsset> updatedAssets = new ArrayList<>();
            C_Files c_files = new C_Files();
            for (int i = 0 ; i < c_files.readAssetController().get(0).getC_newAssetArrayList().size();i++){
                C_NewAsset c_newAsset = c_files.readAssetController().get(0).getC_newAssetArrayList().get(i);
                c_newAsset.setMarketPrice();
                updatedAssets.add(c_newAsset);
            }
            C_AssetController c_assetController = new C_AssetController();
            c_assetController.setC_newAssetArrayList(updatedAssets);
            c_files.writeAssetController(c_assetController);

            System.out.println("REFRESHED: " + new C_Files().readAssetController().get(0).getC_newAssetArrayList().size() + " ASSETS(BUTTON RESPONSE)");
            showAssets(); //UPDATES ASSETS
            calcExchanges(); //UPDATES EXCHANGE TOTALS
            showTotal(); //UPDATES TOTAL BALANCE
            System.out.println("FINISHED REFRESHING ALL DATA");

        }catch (Exception e){
            System.out.println("ERROR REFRESHING DATA");
        }


    }


    @FXML
    void initialize() throws IOException, InterruptedException {
        assert exchange1Label != null : "fx:id=\"exchange1Label\" was not injected: check your FXML file 'MAIN_MENU.fxml'.";
        assert exchange3Label != null : "fx:id=\"exchange3Label\" was not injected: check your FXML file 'MAIN_MENU.fxml'.";
        assert exchangePrice1Label != null : "fx:id=\"exchangePrice1Label\" was not injected: check your FXML file 'MAIN_MENU.fxml'.";
        assert exchangePrice2Label != null : "fx:id=\"exchangePrice2Label\" was not injected: check your FXML file 'MAIN_MENU.fxml'.";
        assert exchangePrice3Label != null : "fx:id=\"exchangePrice3Label\" was not injected: check your FXML file 'MAIN_MENU.fxml'.";
        assert exhange2Label != null : "fx:id=\"exhange2Label\" was not injected: check your FXML file 'MAIN_MENU.fxml'.";
        assert totalBalanceLabel != null : "fx:id=\"totalBalanceLabel\" was not injected: check your FXML file 'MAIN_MENU.fxml'.";
        assert totalBalanceLossGainLabel != null : "fx:id=\"totalBalanceLossGainLabel\" was not injected: check your FXML file 'MAIN_MENU.fxml'.";
        calcInterestGained();
        calcDaysPassed(); //CALCULATES DAYS PASSED
        refreshData();//REFRESHES DATA ON STARTUP
        compareUpdateGainLoss(); //UPDATES GAIN/LOSS
        new C_Files().writeGainLoss(showTotal()); //WRITES GAIN LOSS TO FILE


    }


    public float showTotal() throws IOException, InterruptedException {
        float totalBalance = 0;
        try{
            totalBalance = new C_Files().readAssetController().get(0).getTotalValue();
            totalBalanceLabel.setText(String.valueOf(totalBalance));
            System.out.println("SHOWING TOTAL IN WIDGET (SHOW TOTAL FUNCTION)");

        }catch (Exception e){
            System.out.println();
        }

        return totalBalance;

    }

    private void showAssets() throws IOException, InterruptedException {
        Label[]namesAssetArray = {name0, name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12};
        Label[]marketPriceAssetArray = {marketPrice0, marketPrice1, marketPrice2, marketPrice3, marketPrice4, marketPrice5, marketPrice6, marketPrice7, marketPrice8, marketPrice9, marketPrice10, marketPrice11, marketPrice12};
        Label[]cryptoHoldingAssetArray = {cryptoHolding0, cryptoHolding1, cryptoHolding2, cryptoHolding3, cryptoHolding4, cryptoHolding5, cryptoHolding6, cryptoHolding7, cryptoHolding8, cryptoHolding9, cryptoHolding10, cryptoHolding11, cryptoHolding12};
        Label[]actualPriceAssetArray = {actualPrice0, actualPrice1, actualPrice2, actualPrice3, actualPrice4, actualPrice5, actualPrice6, actualPrice7, actualPrice8, actualPrice9, actualPrice10, actualPrice11, actualPrice12};

        try {
            DecimalFormat decimalFormat = new DecimalFormat();
            decimalFormat.setMaximumFractionDigits(2);
            for(int i = 0; i<=13; i++){
                if (new C_Files().readAssetController().get(0).getC_newAssetArrayList().size() > i){

                    //check if id has "-" in it
                    if (new C_Files().readAssetController().get(0).getC_newAssetArrayList().get(i).getId().contains("-")){

                        namesAssetArray[i].setText(new C_Files().readAssetController().get(0).getC_newAssetArrayList().get(i).getId().substring(0, new C_Files().readAssetController().get(0).getC_newAssetArrayList().get(i).getId().indexOf("-")).toUpperCase());
                    }else {
                        namesAssetArray[i].setText(new C_Files().readAssetController().get(0).getC_newAssetArrayList().get(i).getId().toUpperCase());
                    }
                    marketPriceAssetArray[i].setText("$"+String.valueOf(new C_Files().readAssetController().get(0).getC_newAssetArrayList().get(i).getMarketPrice()));
                    cryptoHoldingAssetArray[i].setText(String.valueOf(new C_Files().readAssetController().get(0).getC_newAssetArrayList().get(i).getQuantity()));
                    actualPriceAssetArray[i].setText("$"+String.valueOf(new C_Files().readAssetController().get(0).getC_newAssetArrayList().get(i).getActualValue()));

                }else {
                    namesAssetArray[i].setText("NO DATA");
                    marketPriceAssetArray[i].setText("NO DATA");
                    cryptoHoldingAssetArray[i].setText("NO DATA");
                    actualPriceAssetArray[i].setText("NO DATA");
                }
            }

        }catch (Exception e){
            System.out.println("NO MORE ASSETS IN PORTAFOLIO TO SHOW (SHOW ASSETS FUNCTION)");
        }


    }

    private void calcExchanges(){
        try{
            System.out.println("CALCULATING EXHANGES TOTALS (CALC EXCHANGES FUNCTION)");
            C_Files c_files = new C_Files();
            //create a sum variable for each exchange
            double sumExchangeBinance = 0;
            double sumExchangeFTX = 0;
            double sumExchangeBITGET = 0;
            double sumExchangeMETAMASK = 0;
            double sumExchangeCOINBASE = 0;
            double sumExchangeHONEYGAIN = 0;
            double sumExchangeOTHER = 0;

            for(int i = 0; i < c_files.readAssetController().get(0).getC_newAssetArrayList().size();i++ ){
                if (c_files.readAssetController().get(0).getC_newAssetArrayList().get(i).getExchange().equals("BINANCE")){
                    sumExchangeBinance += c_files.readAssetController().get(0).getC_newAssetArrayList().get(i).getActualValue();
                }else if (c_files.readAssetController().get(0).getC_newAssetArrayList().get(i).getExchange().equals("FTX")){
                    sumExchangeFTX += c_files.readAssetController().get(0).getC_newAssetArrayList().get(i).getActualValue();
                }else if (c_files.readAssetController().get(0).getC_newAssetArrayList().get(i).getExchange().equals("BITGET")){
                    sumExchangeBITGET += c_files.readAssetController().get(0).getC_newAssetArrayList().get(i).getActualValue();
                }else if (c_files.readAssetController().get(0).getC_newAssetArrayList().get(i).getExchange().equals("METAMASK")){
                    sumExchangeMETAMASK += c_files.readAssetController().get(0).getC_newAssetArrayList().get(i).getActualValue();
                }else if (c_files.readAssetController().get(0).getC_newAssetArrayList().get(i).getExchange().equals("HONEYGAIN")){
                    sumExchangeCOINBASE += c_files.readAssetController().get(0).getC_newAssetArrayList().get(i).getActualValue();
                }else if (c_files.readAssetController().get(0).getC_newAssetArrayList().get(i).getExchange().equals("COINBASE")){
                    sumExchangeHONEYGAIN += c_files.readAssetController().get(0).getC_newAssetArrayList().get(i).getActualValue();
                }else{
                    sumExchangeOTHER += c_files.readAssetController().get(0).getC_newAssetArrayList().get(i).getActualValue();
                }
            }

            System.out.println("SHOWING EXCHANGES TOTALS (CALC EXCHANGES FUNCTION)");
            double[] sumExchangeArray = {sumExchangeBinance, sumExchangeFTX, sumExchangeBITGET, sumExchangeMETAMASK, sumExchangeCOINBASE, sumExchangeHONEYGAIN, sumExchangeOTHER};
            Label[]exchangeArray = {exchange1Label, exchange2Label, exchange3Label, exchange4Label, exchange5Label, exchange6Label, exchange7Label};
            Label[]exchangeValueArray = {exchangePrice1Label, exchangePrice2Label, exchangePrice3Label, exchangePrice4Label, exchangePrice5Label, exchangePrice6Label, exchangePrice7Label};
            for(int i = 0; i < exchangeArray.length; i++){
                DecimalFormat decimalFormat = new DecimalFormat();
                decimalFormat.setMaximumFractionDigits(2);
                exchangeValueArray[i].setText("$"+ String.valueOf(sumExchangeArray[i]));
            }

        }catch (Exception e){
            System.out.println("NO ASSETS TO CALC TOTAL (CALC EXCHANGES FUNCTION)");
        }


    }


    private void compareUpdateGainLoss() throws IOException, InterruptedException {
        try{
            System.out.println("SHOWING GAIN LOSS (COMPARE UPDATE GAIN LOSS FUNCTION)");
            float readGainLoss =new C_Files().readGainLoss().get(0);
            float actualTotal = showTotal();
            if ( readGainLoss > actualTotal) {
                float loss = ((showTotal()*100)/readGainLoss)-100;
                totalBalanceLossGainLabel.setStyle("-fx-text-fill: #ff2366;");
                totalBalanceLossGainLabel.setText(String.valueOf(loss)+"%");
            }else {
                float gain = ((showTotal()*100)/readGainLoss)-100;
                totalBalanceLossGainLabel.setStyle("-fx-text-fill: #61a816;");
                totalBalanceLossGainLabel.setText("+"+String.valueOf(gain)+"%");
            }

        }catch (Exception e){
            System.out.println("NO ASSETS TO CALC TOTAL (COMPARE UPDATE GAIN LOSS FUNCTION)");
        }

    }


    private void calcInterestGained(){
        try{
            int calcDaysPassed = calcDaysPassed();
            if (calcDaysPassed >0) {
                for (int j = 0 ; j<calcDaysPassed;j++) {
                    C_Files c_files = new C_Files();
                    ArrayList<C_NewAsset> c_newAssetArrayList = c_files.readAssetController().get(0).getC_newAssetArrayList();
                    for (int i = 0; i < c_newAssetArrayList.size(); i++) {
                        float interest = (c_newAssetArrayList.get(i).getPercentageToEarn() / 100);
                        float interestGained = (float) (c_newAssetArrayList.get(i).getQuantity() * interest);
                        float newValue = (float) (c_newAssetArrayList.get(i).getQuantity() + interestGained);
                        c_newAssetArrayList.get(i).setQuantity(newValue);
                    }

                    //DELETING ALL DATA FROM EXISTING FILE
                    try (BufferedWriter bf = Files.newBufferedWriter(Path.of("Assets.dat"),
                            StandardOpenOption.TRUNCATE_EXISTING)) {
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //WRITING NEW DATA TO EXISTING FILE
                    for (int i = 0; i < c_newAssetArrayList.size(); i++) {
                        c_files.writeAssets(c_newAssetArrayList.get(i));
                    }

                    //WRITE DATA TO CONTROLLER
                    C_AssetController c_assetController = new C_AssetController();
                    c_assetController.setC_newAssetArrayList(c_newAssetArrayList);
                    c_files.writeAssetController(c_assetController);

                }

            }

        }catch (Exception e){
            System.out.println("NO ASSETS TO CALC INTEREST (CALC INTEREST GAINED FUNCTION)");
        }

    }

    private int calcDaysPassed(){
        int daysPassed = 0;

       try {
            C_Files c_files = new C_Files();

            Date passedDate = c_files.readPassedDate().get(0); //DATE RETRIVED FROM FILE

            Date currentDate = new Date(System.currentTimeMillis()); //CURRENT DATE

            long diff = currentDate.getTime() - passedDate.getTime();
            daysPassed = Integer.parseInt(String.valueOf(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)));
            System.out.println ("DAYS PASSED SINCE OPENED: " + daysPassed);

            if (daysPassed !=0){
                c_files.writeCurrentDate(currentDate);
            }

        } catch (Exception e) {
            System.out.println("PROBLEM CALCULATING DATES (CALC DAYS PASSED FUNCTION)");
            Date date = new Date(System.currentTimeMillis());
            new C_Files().writeCurrentDate(date);
        }

       return daysPassed;
    }





















}
