package me.yaacob.core.dto;



import me.yaacob.core.model.Article;
import me.yaacob.core.model.car_parameters.CarColor;
import me.yaacob.core.model.car_parameters.FuelType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArticleDTO {

    Map<String,String> blurHashes;
    List<String> imagePaths;

    Long articleId;

    String brand;

    String model;

    String type;

    private int price;

    private FuelType fuelType;

    private CarColor carColor;

    private int mileage;

    private int year;

    private String vin;

    private String description;

    private String version;

    private int horsepower;

    private int doors;

    private int engineCapacity;

    private String phoneNumber;

    private String author;



    public ArticleDTO(Long articleId, List<String> imagePaths, Map<String,String> blurHashes, String brand, String model, String type, int price, FuelType fuelType, CarColor carColor, int mileage, int year, String vin, String description, String version, int horsepower, int doors, int engineCapacity, String phoneNumber, String author) {
        this.articleId = articleId;
        this.imagePaths=imagePaths;
        this.blurHashes = blurHashes;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.price = price;
        this.fuelType = fuelType;
        this.carColor = carColor;
        this.mileage = mileage;
        this.year = year;
        this.vin = vin;
        this.description = description;
        this.version = version;
        this.horsepower = horsepower;
        this.doors = doors;
        this.engineCapacity = engineCapacity;
        this.phoneNumber = phoneNumber;
        this.author = author;
    }


    public static ArticleDTO map(Article article){

        Map<String,String> blurHashes=new HashMap<>();
        article.getImageList().forEach((v)->blurHashes.put(v.getPath(),v.getBlurHash()));

        List<String> imagePaths=article.getImageList().stream().map(v->v.getPath()).toList();

        return new ArticleDTO(article.getId(),imagePaths, blurHashes,article.getCar().getBrand(),article.getCar().getModel(),article.getCar().getType(),article.getPrice(),article.getFuelType(),article.getCarColor(),article.getMileage(),article.getYear(),article.getVin(),article.getDescription(),article.getVersion(),article.getHorsepower(),article.getDoors(),article.getEngineCapacity(),article.getPhoneNumber(),article.getAuthor());
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public CarColor getCarColor() {
        return carColor;
    }

    public void setCarColor(CarColor carColor) {
        this.carColor = carColor;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
