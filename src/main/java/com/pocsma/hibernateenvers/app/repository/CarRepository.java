package com.pocsma.hibernateenvers.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pocsma.hibernateenvers.app.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long>{

}
