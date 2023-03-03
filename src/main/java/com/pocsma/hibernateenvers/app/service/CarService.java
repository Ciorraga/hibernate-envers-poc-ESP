package com.pocsma.hibernateenvers.app.service;

import java.util.List;

import com.pocsma.hibernateenvers.app.entity.Car;

public interface CarService {

	List<Car> getCars();
	
	Car getCar(Long id);
	
	Car saveCar(Car newCar);

	void deleteCar(Long id);

	Car updateCar(Long id, Car newCar);
	
}
