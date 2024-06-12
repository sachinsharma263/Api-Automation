package org.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    private String name;

//    private Map<String,Object> coord;
//
//    private List<Map<String,Object>> weather;

    private Coordinate coord;

    private List<WeatherInfo> weather;


    private int visibility;

    public WeatherResponse()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    public List<WeatherInfo> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherInfo> weather) {
        this.weather = weather;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    private JsonNode main;

    public JsonNode getMain() {
        return main;
    }

    public void setMain(JsonNode main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "name='" + name + '\'' +
                ", coord=" + coord +
                ", weather=" + weather +
                ", visibility=" + visibility +
                ", main=" + main +
                '}';
    }
}
