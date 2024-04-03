package me.yaacob.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name="cars")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    public Car(String brand, String model, String type) {
        this.brand = brand;
        this.model = model;
        this.type = type;
    }

    public Car() {}

    private String brand;
    private String model;
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
