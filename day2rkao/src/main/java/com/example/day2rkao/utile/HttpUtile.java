package com.example.day2rkao.utile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtile {
    public static String get(String urlStr){
        String result ="";
        try {
            URL url = new URL(urlStr);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode==200){
               result= streamString(httpURLConnection.getInputStream());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String streamString(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader isr = new BufferedReader(new InputStreamReader(inputStream));
        try {
            for (String temp=isr.readLine();temp!=null;temp=isr.readLine()){
                stringBuilder.append(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
