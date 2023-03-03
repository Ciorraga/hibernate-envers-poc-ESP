package com.pocsma.hibernateenvers.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.pocsma.hibernateenvers.app.entity.Car;
import com.pocsma.hibernateenvers.app.repository.CarRepository;
import com.pocsma.hibernateenvers.app.service.CarService;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepository;

	@Override
	public List<Car> getCars() {
		return carRepository.findAll();
	}

	@Override
	public Car getCar(Long id) {
		return carRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not Found"));
	}

	@Override
	public Car updateCar(Long id, Car newCar) {
		newCar.setId(id);
		return carRepository.save(newCar);
	}

	@Override
	public Car saveCar(Car newCar) {
		return carRepository.save(newCar);
	}

	@Override
	public void deleteCar(Long id) {
		carRepository.deleteById(id);
	}

}
