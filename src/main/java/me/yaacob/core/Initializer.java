package me.yaacob.core;

import jakarta.annotation.PostConstruct;
import me.yaacob.core.model.Car;
import me.yaacob.core.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Initializer {

    @Autowired
    CarRepository carRepository;


    //insert Cars
    //@PostConstruct
    private synchronized void init(){
        carRepository.deleteAll();
        List<Car> cars = List.of(
                new Car("Volkswagen", "Golf", "hatchback"),
                new Car("Volkswagen", "Passat", "sedan"),
                new Car("Volkswagen", "Tiguan", "SUV"),
                new Car("Volkswagen", "Polo", "hatchback"),
                new Car("Volkswagen", "Arteon", "sedan"),
                new Car("Volkswagen", "T-Roc", "SUV"),
                new Car("Toyota", "Corolla", "sedan"),
                new Car("Toyota", "Camry", "sedan"),
                new Car("Toyota", "Rav4", "SUV"),
                new Car("Toyota", "Yaris", "hatchback"),
                new Car("Toyota", "Prius", "hatchback"),
                new Car("Toyota", "Highlander", "SUV"),
                new Car("Ford", "Focus", "hatchback"),
                new Car("Ford", "Fiesta", "hatchback"),
                new Car("Ford", "Mustang", "coupe"),
                new Car("Ford", "Escape", "SUV"),
                new Car("Ford", "Explorer", "SUV"),
                new Car("Ford", "Edge", "SUV"),
                new Car("BMW", "3 Series", "sedan"),
                new Car("BMW", "5 Series", "sedan"),
                new Car("BMW", "X5", "SUV"),
                new Car("BMW", "X3", "SUV"),
                new Car("BMW", "X1", "SUV"),
                new Car("BMW", "4 Series", "coupe"),
                new Car("Mercedes-Benz", "C-Class", "sedan"),
                new Car("Mercedes-Benz", "E-Class", "sedan"),
                new Car("Mercedes-Benz", "GLC", "SUV"),
                new Car("Mercedes-Benz", "A-Class", "hatchback"),
                new Car("Mercedes-Benz", "GLE", "SUV"),
                new Car("Mercedes-Benz", "S-Class", "sedan"),
                new Car("Audi", "A4", "sedan"),
                new Car("Audi", "A3", "hatchback"),
                new Car("Audi", "Q5", "SUV"),
                new Car("Audi", "Q7", "SUV"),
                new Car("Audi", "A6", "sedan"),
                new Car("Audi", "Q3", "SUV")
        );

        carRepository.saveAll(cars);

    }


}
