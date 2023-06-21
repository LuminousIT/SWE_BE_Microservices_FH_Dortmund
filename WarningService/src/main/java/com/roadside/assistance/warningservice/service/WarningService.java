package com.roadside.assistance.warningservice.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WarningService {
    public WarningService( ){
    }

    public JsonObject getWeatherForecastData(double latitude, double longitude) {

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.open-meteo.com")
                .path("/v1/forecast")
                .queryParam("latitude", latitude)
                .queryParam("longitude", longitude)
                .queryParam("hourly", "temperature_2m,rain,snowfall,relativehumidity_2m,windspeed_10m")
                .queryParam("timezone", "auto")
                .build();

        String url = uriComponents.toUriString();
        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.getForObject(url, String.class);
        JsonObject rootObject = JsonParser.parseString(response).getAsJsonObject();


        return rootObject;

    }
}
