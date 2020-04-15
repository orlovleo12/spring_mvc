package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private  ArrayList<Car> carList = new ArrayList<>();

    public CarService() {
        carList.add(new Car("1", "1", "black"));
        carList.add(new Car("2", "1", "white"));
        carList.add(new Car("3", "1", "blue"));
    }

    public  List<Car> getCarList() {
        return carList;
    }
}
