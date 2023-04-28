package com.roadside.assistance.warningservice.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;

@RestController
@RequestMapping("/warning")
public class WarningRestApi {

    @GetMapping("/weather")
    public String getWeatherForecast(Model model) throws IOException {
        double latitude = 51.48;
        double longitude = 7.40;

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.open-meteo.com")
                .path("/v1/forecast")
                .queryParam("latitude", latitude)
                .queryParam("longitude", longitude)
                .queryParam("hourly", "temperature_2m,relativehumidity_2m,windspeed_10m")
                .queryParam("timezone", "auto")
                .build();

        String url = uriComponents.toUriString();
        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.getForObject(url, String.class);
        JsonObject rootObject = JsonParser.parseString(response).getAsJsonObject();
        JsonObject hourlyData = rootObject.getAsJsonObject("hourly");

        JsonArray timeStamps = hourlyData.getAsJsonArray("time");
        JsonArray temperatureForecast = hourlyData.getAsJsonArray("temperature_2m");
        JsonArray humidityForecast = hourlyData.getAsJsonArray("relativehumidity_2m");
        JsonArray windForecast = hourlyData.getAsJsonArray("windspeed_10m");


        model.addAttribute("timeStamps", timeStamps);
        model.addAttribute("temperature", temperatureForecast);
        model.addAttribute("humidity", humidityForecast);
        model.addAttribute("wind", windForecast);

        for (int i = 0; i < timeStamps.size(); i++) {
            System.out.println("Time: " + timeStamps.get(i) + " // Temperature: " + temperatureForecast.get(i) + " // Humidity: " + humidityForecast.get(i) + " // Wind: " + windForecast.get(i));
        }

        return "weather";
    }

    /*
    // Collision warning system
    @GetMapping("/collision/{distance}/{speed}/{time}/{type}/{position}/{size}/{trajectory}")
    public String getCollisionWarning(
            @PathVariable("distance") double distance,
            @PathVariable("speed") double speed,
            @PathVariable("time") double time,
            @PathVariable("type") String type,
            @PathVariable("position") String position,
            @PathVariable("size") String size,
            @PathVariable("trajectory") String trajectory) {
        // Implement logic to generate collision warning
        return "Collision warning generated";
    }

    // Maintenance warning system
    @GetMapping("/maintenance/{mileage}/{time}/{oil}/{brake}/{tire}/{transmission}/{battery}")
    public String getMaintenanceWarning(
            @PathVariable("mileage") int mileage,
            @PathVariable("time") int time,
            @PathVariable("oil") int oil,
            @PathVariable("brake") int brake,
            @PathVariable("tire") int tire,
            @PathVariable("transmission") int transmission,
            @PathVariable("battery") int battery) {
        // Implement logic to generate maintenance warning
        return "Maintenance warning generated";
    }

    // Security warning system
    @GetMapping("/security/{gps}/{access}/{sensor}/{alarm}/{immobilization}/{tracking}/{emergency}")
    public String getSecurityWarning(
            @PathVariable("gps") String gps,
            @PathVariable("access") boolean access,
            @PathVariable("sensor") String sensor,
            @PathVariable("alarm") boolean alarm,
            @PathVariable("immobilization") boolean immobilization,
            @PathVariable("tracking") boolean tracking,
            @PathVariable("emergency") String emergency) {
        // Implement logic to generate security warning
        return "Security warning generated";
    }
    */
    // Weather warning system
//    @GetMapping("/weather/{temperature}/{humidity}/{precipitation}/{intensity}/{wind}/{condition}/{visibility}")
//    public String getWeatherWarning(
//            @PathVariable("temperature") int temperature,
//            @PathVariable("humidity") int humidity,
//            @PathVariable("precipitation") String precipitation,
//            @PathVariable("intensity") String intensity,
//            @PathVariable("wind") String wind,
//            @PathVariable("condition") String condition,
//            @PathVariable("visibility") String visibility) {
//        // Implement logic to generate weather warning
//
//        return "Weather warning generated";
//    }


}