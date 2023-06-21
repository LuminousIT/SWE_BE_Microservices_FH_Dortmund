package com.roadside.assistance.warningservice.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.roadside.assistance.warningservice.service.WarningService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/warning")
public class WarningRestApi {

    public WarningService warningService;
    public WarningRestApi(WarningService warningService) {
        this.warningService = warningService;
    }

  @GetMapping("/weather/{latitude:.+}/{longitude:.+}")
    public JsonObject getWeatherForecast(@PathVariable double latitude, @PathVariable double longitude) throws IOException {
//        double latitude = 51.48;
//        double longitude = 7.40;
        return warningService.getWeatherForecastData(latitude, longitude);
    }



}