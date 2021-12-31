package com.example.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Car;
import com.example.repository.CarRepository;
import com.example.service.CarService;

@Service
public class CarServiceImpl implements CarService {
	@Autowired
	private CarRepository carRepository;
	
	@Override
	@Transactional
	public Object saveCar(Car car) {
		Map<String, Object> map=new HashMap<String, Object>();
		if(car.getCompanyName().isEmpty())
		{
			map.put("Status", "Error");
			map.put("Msg", "please Enter the Company Name");
		}
		else if(car.getModel().isEmpty())
		{
			map.put("status","Error");
			map.put("Msg","Please enter the model name");
		}
		else {
			carRepository.save(car);
			map.put("status","200");
			map.put("Msg","Data inserted successfully");
		}
		return map;
	}

	@Override
	@Transactional
	public List<Car> getAllCars() {
		// TODO Auto-generated method stub
		return carRepository.findAll();
	}

	@Override
	@Transactional
	public Car getCarInfoById(int id) {
		// TODO Auto-generated method stub
		return carRepository.findById(id).orElse(null);
	}

@Override
@Transactional
public Object deletCarInfo(int id) {
Map<String, Object> map=new HashMap<String, Object>();
carRepository.deleteById(id);
map.put("Status", "200");
map.put("Msg", "Data Deleted SuccessFully");
return map;
}

@Override
public Object updateCarInfo(Car car) {
	// TODO Auto-generated method stub
	Map<String, Object> map=new HashMap<String, Object>();
	if(car.getCompanyName().isEmpty())
	{
		map.put("Status", "Error");
		map.put("Msg", "please Enter the Company Name");
	}
	else if(car.getModel().isEmpty())
	{
		map.put("status","Error");
		map.put("Msg","Please enter the model name");
	}
	else {
		carRepository.saveAndFlush(car);
		map.put("status","200");
		map.put("Msg","Data updated successfully");
	}
	return map;
}



}
