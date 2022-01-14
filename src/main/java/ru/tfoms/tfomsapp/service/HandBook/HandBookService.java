package ru.tfoms.tfomsapp.service.HandBook;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.tfoms.tfomsapp.domain.HandBook.Handbook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HandBookService {

    public Handbook getHandBook(String strURL) throws Exception {
        URL url = new URL(strURL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(in, Handbook.class);
    }
}
