# MyCryptoWallet
This project is a Java FX application developed fully by Juan Francisco Cisneros. The app has been only tested on Mac OS but there should be no problem when running it on a Windows system.

## Description
MyCryptoWallet is a portafolio where anyone can store their assets. The app will not collect personal information, will not connect to actual crypto wallets
but instead the app is designed to just show important data of your assets in a central app.

## How To Use It?
Once the app is fully compiled (recomend Intellij IDEA), when open no data will be shown. Usimg the "ADD ASSET" button the user will be prompted to input
a coin information. 

### Where can I find the COIN ID?
The app uses the Coin Gecko free Api to gather crypto prices, the ID can be found in their offcial website: https://www.coingecko.com
Just choose an asset and the website will display the ID. For example for Binance USD the ID = binancecoin

### What is Percentage Earnings ? (Compund Interest)
Most of MyCryptoWallet users will encounter the app useful for storing data in the long term (long term investments). Percentage Earnings asks for a percentage
number, this parameter should be inputed in case you earn X percentage in staking for that coin. For example I will input one Bitcoin with a percentage earning of 10 (%)
tomorrow the asset quantity will be updated to 1.10 bitcoins and so on. (compund interest)
If you don't understand how to use this parameter or the coin is not in a staking process please input a "0" in the field.

### Can I edit assets and delete them?
Yes, access the "Change Assets" menu, choose the asset. Press the red "X" in case you want to delete the asset from the app. Or just input the new information 
the asset will have and press the green button to update the information


### Is the app connected to the internet?
MyCryptoWallet will only connect to the internet when opening and gathering the lastest prices and when the refresh button is pressed.

### What is Check Coin Price?
This is a simple menu where you can input a coin id in order to check a coin price or to check if the connection to Coin Gecko is working. 

## There is a bug or glitch on the app. How can I solve it?
Please first share the bug with me by emailing me at juanfrancistm2011@icloud.com

In case you have knowlage on java prgramming and you want to take a look at my code please do so. Remember to pull a request so that everyone can benefit from you help.

