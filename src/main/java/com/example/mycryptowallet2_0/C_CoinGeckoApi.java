package com.example.mycryptowallet2_0;

//import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C_CoinGeckoApi {

    //CONSTRUCTOR
    public C_CoinGeckoApi(){
    }

    //GET PRICE BY ID
    public String cryptoPrice(String id) throws IOException, InterruptedException {
        Pattern regex;
        Matcher matcher;
        //RETURN PRICE
        String numberFounded = "";
        //CONNECTION TO THE API
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://coingecko.p.rapidapi.com/simple/price?ids="+id+"&vs_currencies=usd"))
                .header("X-RapidAPI-Host", "coingecko.p.rapidapi.com")
                .header("X-RapidAPI-Key", "7052501479msha3c962ec04c7717p12f541jsn366cbeddd13d")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body() + "(API RESPONSE)");


        //MANAGING THE RETURN OF THE API TO ONLY GET THE PRICE
        regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        matcher= regex.matcher(response.body());
        while(matcher.find()){
            numberFounded = matcher.group(1);
        }



        return numberFounded;
    }


}
