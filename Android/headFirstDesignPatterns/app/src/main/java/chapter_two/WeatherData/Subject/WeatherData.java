package chapter_two.WeatherData.Subject;

import java.util.ArrayList;

/**
 * Created by nbsm on 10-11-2016.
 */

public class WeatherData implements Subject{
    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(0);
        if (i != 0){
            observers.remove(i);
        }
        // observers.remove(o) kon ook maar null handling?
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update(temperature,humidity,pressure);
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
