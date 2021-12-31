package com.example.service;
import java.util.List;

import com.example.model.Car;
public interface CarService {
	

	public Object saveCar(Car car);
	public List<Car> getAllCars();
	public Car getCarInfoById(int id);
	public Object updateCarInfo(Car car);
	public Object deletCarInfo(int id);
	

}
