package me.yaacob.core.dto;


import me.yaacob.core.model.Article;
import me.yaacob.core.model.Car;
import me.yaacob.core.model.car_parameters.FuelType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PreviewDTO {


    Map<String,String> blurHashes;
    List<String> imagePaths;

    public PreviewDTO(Long articleId, List<String> imagePaths, Map<String,String> blurHashes, Car car, int price, FuelType fuelType, int year, int mileage) {
        this.articleId = articleId;
        this.imagePaths = imagePaths;
        this.blurHashes = blurHashes;
        this.price = price;
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.fuelType = fuelType;
        this.year = year;
        this.mileage = mileage;
    }

    public PreviewDTO() {
    }

    private Long articleId;

    private String brand;

    private String model;

    private int price;

    private FuelType fuelType;

    private int year;

    private int mileage;


    public static PreviewDTO map(Article article){

        Map<String,String> blurHashes=new HashMap<>();
        article.getImageList().forEach((v)->blurHashes.put(v.getPath(),v.getBlurHash()));

        List<String> imagePaths=article.getImageList().stream().map(v->v.getPath()).toList();

        return new PreviewDTO(article.getId(), imagePaths, blurHashes, article.getCar(),article.getPrice(),article.getFuelType(),article.getYear(),article.getMileage());
    }


    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Map<String, String> getBlurHashes() {
        return blurHashes;
    }

    public void setBlurHashes(Map<String, String> blurHashes) {
        this.blurHashes = blurHashes;
    }

    public List<String> getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(List<String> imagePaths) {
        this.imagePaths = imagePaths;
    }
}
