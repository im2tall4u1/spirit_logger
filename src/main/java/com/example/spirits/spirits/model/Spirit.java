package com.example.spirits.spirits.model;

import javax.persistence.Entity;
import javax.persistence.Id;





@Entity
public class Spirit {
    @Id
    private int spiritId;
    private String brand;
    private String name;
    private String type;
    private String color;
    private int yearsAged;
    private Integer alcoholContent;

    public Spirit(){}


    public Spirit(int spiritId, String brand, String name, String type, String color, int yearsAged, int alcoholContent) {
        this.spiritId = spiritId;
        this.brand = brand;
        this.name = name;
        this.type = type;
        this.color = color;
        this.yearsAged = yearsAged;
        this.alcoholContent = alcoholContent;
    }


    public int getSpiritId() {
        return spiritId;
    }


    public void setSpiritId(int spiritId) {
        this.spiritId = spiritId;
    }


    public String getBrand() {
        return brand;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }


    public int getYearsAged() {
        return yearsAged;
    }


    public void setYearsAged(int yearsAged) {
        this.yearsAged = yearsAged;
    }

    public int getAlcoholContent(){
        return alcoholContent;
    }

    public void setAlcoholContent(int alcoholContent){
        this.alcoholContent = alcoholContent;
    }

    @Override
    public String toString(){
        return "Spirit [name=" + name + ", type=" + type + ", color=" + color + ", Years Aged=" + yearsAged + "Alcohol Content=" + alcoholContent + "]";
    }
    
}
