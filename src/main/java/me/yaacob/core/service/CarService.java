package me.yaacob.core.service;

import me.yaacob.core.model.Car;
import me.yaacob.core.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarService {

    CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional
    public List<Car> getCars(){
        return carRepository.findAll();
    }



}
