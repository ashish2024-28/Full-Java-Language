package com.external_api_intigration.External.API.Integration.WeatherApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherService {
    
    // get Api key from Weather websit 
    @Value("${weather.api.key}")
    private String apiKey ;

    // check the api and api key response 
    // then convert (response) JSON to Java POJO class : search on google convert json to pojo
    // create a class(any name) for json's pojo  
    private static final String API = "http://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    // RestTemplate => http requst kre kay response dayta hai.
    // RestTemplate hit api and get response
    @Autowired
    private RestTemplate restTemplate;


    public WeatherResponse getWeather(String city){
        String finalAPI = API.repla\ce("CITY", city).replace("API_KEY", apiKey);

        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI,HttpMethod.GET, null, WeatherResponse.class); // jo response aa rahe hai usko convert to pogo
        // the process of converting response data from Json to (pojo) java object called deserilize 
        //                                               pojo to json called serilization
        WeatherResponse body = response.getBody();
        return body ;
    }

}


// Step 1: Get Your API Access Key

// Step 2: API Endpoints
    // Weatherstack provides several endpoints to access different types of weather data:

    // Current Weather: Retrieve current weather conditions.
    // Historical Weather: Access past weather data for a specific date.
    // Historical Time-Series: Retrieve weather data over a range of dates.
    // Weather Forecast: Get forecasts for up to 14 days.
    // Location Lookup: Look up one or multiple locations.

    // Base URL: All API requests start with: => http://api.weatherstack.com/
    // You can also get started quickly with Postman by forking the official Weatherstack API Postman Collection.

// Step 3: Make API Requests
    // Try simple requests for current, historical, and forecast weather data. Append your access_key and query parameters.

// Current Weather
    // http://api.weatherstack.com/current?access_key=YOUR_ACCESS_KEY&query=New York
    // Optional parameters:
    // &units=m
    // &language=en
    // &callback=MY_CALLBACK

// Historical Weather
    // http://api.weatherstack.com/historical?access_key=YOUR_ACCESS_KEY&query=New York&historical_date=2015-21-01
    // Optional parameters:
    // &hourly=1
    // &interval=3
    // &units=m
    // &language=en
    // &callback=MY_CALLBACK

// Historical Weather Time-Series
    // http://api.weatherstack.com/historical?access_key=YOUR_ACCESS_KEY&query=New York&historical_date_start=2015-10-21&historical_date_end=2015-10-25
    // // Optional parameters:
    // &hourly=1
    // &interval=3
    // &units=m
    // &language=en
    // &callback=MY_CALLBACK

// Weather Forecast
    // http://api.weatherstack.com/forecast?access_key=YOUR_ACCESS_KEY&query=New York
    // // Optional parameters:
    // &forecast_days=7
    // &hourly=1
    // &interval=3
    // &units=m
    // &language=en
    // &callback=MY_CALLBACK
