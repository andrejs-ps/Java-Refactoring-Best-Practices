package com.onlineshop.handlers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpClient.newBuilder;

public class HttpHelper {


    public String getCurrencyRate(String baseCurrency){
        HttpClient httpClient = newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.exchangeratesapi.io/latest?base=" + baseCurrency))
                .build();

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return response.body();

    }
}
