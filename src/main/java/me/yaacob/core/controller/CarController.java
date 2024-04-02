package me.yaacob.core.controller;

import me.yaacob.core.model.Car;
import me.yaacob.core.model.car_parameters.CarColor;
import me.yaacob.core.model.car_parameters.FuelType;
import me.yaacob.core.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
@RequestMapping("/carApi")
@RestController
public class CarController {

    CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/getBrands")
    public List<String> getBrands(){
        List<String> brands = carService.getCars().stream().map((v)->v.getBrand()).distinct().toList();
        return brands;
    }

    @GetMapping("/getModels/{brand}")
    public List<String> getModels(@PathVariable("brand") String brand){
        List<String> models = carService.getCars().stream().filter(v->brand.contains(v.getBrand())).map((v)->v.getModel()).distinct().toList();
        return models;
    }


    @GetMapping("/getColors")
    public List<String> getColors(){
        List<String> colors = Arrays.stream(CarColor.values()).map(v->v.name()).toList();
        return colors;
    }

    @GetMapping("/getFuelTypes")
    public List<String> getFuelTypes(){
        List<String> colors = Arrays.stream(FuelType.values()).map(v->v.name()).toList();
        return colors;
    }
}
