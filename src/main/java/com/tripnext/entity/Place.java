package com.tripnext.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Place {

    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )

    private Long id;

    private String placeName;

    private String location;

    @Column(length = 10000)
    private String imageUrl;

    private String category;

    @Column(length = 5000)
    private String description;

    // DEFAULT CONSTRUCTOR

    public Place() {
    }

    // PARAMETERIZED CONSTRUCTOR

    public Place(
            Long id,
            String placeName,
            String location,
            String imageUrl,
            String category,
            String description
    ) {

        this.id = id;
        this.placeName = placeName;
        this.location = location;
        this.imageUrl = imageUrl;
        this.category = category;
        this.description = description;
    }

    // GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(
            String description
    ) {
        this.description = description;
    }
}