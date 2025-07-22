package com.alura.challenge.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DatosApi {
    public  String consultaApi(){
        try {
            // Crear cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Crear solicitud GET
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://gutendex.com/books/"))
                    .GET()
                    .build();
            // Enviar   solicitud y obtener respuesta como String
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body().split("results")[1];
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }


    }
}
