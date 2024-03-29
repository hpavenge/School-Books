package chapter_two.WeatherData.rework;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by nbsm on 10-11-2016.
 */

public class CurrentConditionsDisplay implements Observer {
    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    public void update(Observable obs, Object arg){
        if (obs instanceof WeatherData){
            WeatherData weatherData = (WeatherData)obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    public void display(){
        System.out.println("Current conditions: " + temperature + "F degress and" + humidity + "% humidity");
    }

}
