package com.example.helloworld.Model;

public class Planet {
    private String name;
    private int number;
    private String images;

    public Planet(String name, int number, String images) {
        this.name = name;
        this.number = number;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
