package ru.tfoms.tfomsapp.service;

import nu.xom.Element;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class ServiceUtil {

    public String getChildValueByName(Element element, String name){
        if (element.getLocalName().equals(name)){
            return element.getValue();
        }
        return "";
    }

    public void showMessagesEx(String str){
        System.out.println(str);
        //Notification.show(str);
    }

    public BufferedReader getHBBufferedReader(String strURL) throws IOException {
        URL url;
        url = new URL(strURL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        return new BufferedReader(new InputStreamReader(con.getInputStream()));
    }
}
