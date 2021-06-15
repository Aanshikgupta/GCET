package com.example.gcet.UI.Gallery;

public class Gallery {

    String key, imageUrl, department;

    public Gallery(String key, String imageUrl, String department) {
        this.key = key;
        this.imageUrl = imageUrl;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Gallery() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Gallery(String key, String imageUrl) {
        this.key = key;
        this.imageUrl = imageUrl;
    }
}
