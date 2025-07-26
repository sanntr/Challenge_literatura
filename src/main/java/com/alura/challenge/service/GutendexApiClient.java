package com.alura.challenge.service;

import com.google.gson.JsonArray;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import com.google.gson.JsonParser;

public class GutendexApiClient {
    public JsonArray consultaApi(String url){
        try {
            // Crear cliente HTTP
            HttpClient client = HttpClient.newBuilder()
                    .followRedirects(HttpClient.Redirect.ALWAYS)
                    .build();

            // Crear solicitud GET
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .timeout(Duration.ofSeconds(100))
                    .GET()
                    .build();
            // Enviar   solicitud y obtener respuesta como String
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.statusCode());
            return JsonParser.parseString(response.body()).getAsJsonObject().get("results").getAsJsonArray();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("no se pudo enviar");
            return null;
        }


    }
}
