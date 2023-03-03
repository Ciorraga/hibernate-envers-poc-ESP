package com.pocsma.hibernateenvers.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pocsma.hibernateenvers.app.entity.Car;
import com.pocsma.hibernateenvers.app.service.CarService;

@RestController
public class CarRestController {

	@Autowired
	private CarService carService;
	
	@GetMapping("/cars")
	public ResponseEntity<List<Car>> getAllCars(
			@RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "20") int size) {
		
		List<Car> cars = carService.getCars();
				
		return !cars.isEmpty() 
				? new ResponseEntity<>(cars, HttpStatus.OK) 
				: new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/cars/{id}")
    public Car getCar(@PathVariable("id") Long id) {		
		return carService.getCar(id);
    }
	
	@PostMapping(value = "/cars")
	public ResponseEntity<Object> saveCar(@RequestBody Car car){
		
		Car newCar = carService.saveCar(car);
		
		return ResponseEntity.ok(newCar);
	}
	
	@PutMapping(value = "/cars/{id}")
	public ResponseEntity<Object> updateCar(@PathVariable("id") Long id, 
			@RequestBody Car car){
		
		Car newCar = carService.updateCar(id, car);
		
		return ResponseEntity.ok(newCar);
	}
	
	@DeleteMapping(value = "/cars/{id}")
	public ResponseEntity<Object> deleteCar(@PathVariable("id") Long id){
		
		if(getCar(id) != null) {
			carService.deleteCar(id);
		}
		
		return ResponseEntity.ok("Car not found with id: " + id);
		
	}
	
}
