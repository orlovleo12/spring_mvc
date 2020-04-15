package web.model;

import org.springframework.stereotype.Component;

@Component
public class Car {

    private String number;
    private String series;
    private String color;

    public Car() {}

    public Car(String number, String series, String color) {
        this.number = number;
        this.series = series;
        this.color = color;
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
