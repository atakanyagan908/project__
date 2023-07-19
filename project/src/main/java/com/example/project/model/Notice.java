package com.example.project.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "notices")
public class Notice extends Event{



    @Column(name = "image_path")
    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }



}
