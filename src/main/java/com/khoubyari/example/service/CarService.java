package com.khoubyari.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.khoubyari.example.dao.dynamodb.CarRepository;
import com.khoubyari.example.domain.Car;

/*
 * Sample service to demonstrate what the API controller would use to get things done
 */
@Service
public class CarService {

    private static final Logger log = LoggerFactory.getLogger(CarService.class);

    @Autowired
    private CarRepository carRepository;

    public CarService() {
    }

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public Car getCar(String id) {
        if (carRepository.existsById(id)) {
            return carRepository.findById(id).get();
        }
        return null;
    }

    public void updateCar(Car car) {
        carRepository.save(car);
    }

    public void deleteCar(String id) {
        carRepository.deleteById(id);
    }

    public Page<Car> getAllCars(Integer page, Integer size) {
        Page pageOfCars = carRepository.findAll(PageRequest.of(page, size));
        log.info("uma completed");
        log.info("uma execute");

        return pageOfCars;

    }

}
