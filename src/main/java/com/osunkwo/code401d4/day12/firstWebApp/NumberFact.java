package com.osunkwo.code401d4.day12.firstWebApp;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NumberFact {

    public static String driver(int number){
        String url = "http://numbersapi.com/"+number+"/trivia?json";
       return convertAndDisplayFact(getFactFromApi(url));
    }

    public static BufferedReader getFactFromApi(String urlString){
        try{
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader((con.getInputStream())));
            return reader;
        }catch(IOException e){
            System.out.println("Some thing went wrong with the API");
            return null;
        }
    }

    public static String convertAndDisplayFact(BufferedReader reader){
        Gson gson = new Gson();
        Number numberFact = gson.fromJson(reader,Number.class );
        return numberFact.toString();
    }

    //class to store the text value that comes back from the API
    public class Number{
        String text;
        Number(){
            text = "";
        }

        @Override
        public String toString(){
            return String.format("%s\n", text);
        }
    }
}
