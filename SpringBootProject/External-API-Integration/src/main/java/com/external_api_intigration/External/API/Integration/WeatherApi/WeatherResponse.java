package com.external_api_intigration.External.API.Integration.WeatherApi;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class WeatherResponse {

    private Request request;
    private Current current;

    @Data
    public static class Request {
        public String type;
        public String query;
        public String language;
        public String unit;

        @Override
        public String toString() {
            return "Request{" +
                    "type='" + type + '\'' +
                    ", query='" + query + '\'' +
                    ", language='" + language + '\'' +
                    ", unit='" + unit + '\'' +
                    '}';
        }
    }

    @Data
    public static class Current {

        @JsonProperty("observation_time")
        public String observationTime;

        public int temperature;
        public List<String> weather_icons;
        public List<String> weather_descriptions;

        public Astro astro;
        public AirQuality air_quality;

        public int wind_speed;
        public String wind_dir;
        public int humidity;
        public String is_day;

        @Override
        public String toString() {
            return "Current{" +
                    "observationTime='" + observationTime + '\'' +
                    ", temperature=" + temperature +
                    ", weather_icons=" + weather_icons +
                    ", weather_descriptions=" + weather_descriptions +
                    ", astro=" + astro +
                    ", air_quality=" + air_quality +
                    ", wind_speed=" + wind_speed +
                    ", wind_dir='" + wind_dir + '\'' +
                    ", humidity=" + humidity +
                    ", is_day='" + is_day + '\'' +
                    '}';
        }
    }

    @Data
    public static class AirQuality {
        public String co;
        public String no2;

        @Override
        public String toString() {
            return "AirQuality{" +
                    "co='" + co + '\'' +
                    ", no2='" + no2 + '\'' +
                    ", o3='" + o3 + '\'' +
                    '}';
        }

        public String o3;
    }

    @Data
    public static class Astro {
        public String sunrise;
        public String sunset;

        @Override
        public String toString() {
            return "Astro{" +
                    "sunrise='" + sunrise + '\'' +
                    ", sunset='" + sunset + '\'' +
                    ", moonrise='" + moonrise + '\'' +
                    ", moonset='" + moonset + '\'' +
                    '}';
        }

        public String moonrise;
        public String moonset;
    }


}








// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
// public class AirQuality{
//     public String co;
//     public String no2;
//     public String o3;
//     public String so2;
//     public String pm2_5;
//     public String pm10;
//     public String us-epa-index;
//     public String gb-defra-index;
// }

// public class Astro{
//     public String sunrise;
//     public String sunset;
//     public String moonrise;
//     public String moonset;
//     public String moon_phase;
//     public int moon_illumination;
// }

// public class Current{
//     public String observation_time;
//     public int temperature;
//     public int weather_code;
//     public List<String> weather_icons;
//     public List<String> weather_descriptions;
//     public Astro astro;
//     public AirQuality air_quality;
//     public int wind_speed;
//     public int wind_degree;
//     public String wind_dir;
//     public int pressure;
//     public int precip;
//     public int humidity;
//     public int cloudcover;
//     public int feelslike;
//     public int uv_index;
//     public int visibility;
//     public String is_day;
// }

// public class Location{
//     public String name;
//     public String country;
//     public String region;
//     public String lat;
//     public String lon;
//     public String timezone_id;
//     public String localtime;
//     public int localtime_epoch;
//     public String utc_offset;
// }

// public class Request{
//     public String type;
//     public String query;
//     public String language;
//     public String unit;
// }

// public class Root{
//     public Request request;
//     public Location location;
//     public Current current;
// }


