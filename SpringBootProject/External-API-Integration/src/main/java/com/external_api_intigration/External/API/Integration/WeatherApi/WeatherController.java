package com.external_api_intigration.External.API.Integration.WeatherApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class WeatherController {

    @Autowired
    private WeatherService weatherService;
    
    @GetMapping("/{city}")
    public ResponseEntity<?> WeatherApiCall (@PathVariable String city){
        // String city = "Haridwar";
        WeatherResponse weatherResponse = weatherService.getWeather(city);
        if(weatherResponse != null){
            return new ResponseEntity<>("Hi today Weather. " +weatherResponse.getCurrent().getWeather_descriptions()  + "\n" 
            + weatherResponse.getRequest().getType() + " : " + weatherResponse.getRequest().getQuery() + "\nTime : " 
            + weatherResponse.getCurrent().getObservationTime() + "\n Temperature : " 
            + weatherResponse.getCurrent().getTemperature() +"\n toString  Current : " 
            + weatherResponse.getCurrent().toString() +"\n toString  Request : " 
            + weatherResponse.getRequest().toString() , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

}
