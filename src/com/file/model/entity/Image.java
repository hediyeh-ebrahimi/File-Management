package com.file.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Table(name = "image")
@Entity(name = "image")
public class Image implements Serializable {
    @Id
    @Column(name = "image_id", columnDefinition = "number")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_seq")
    @SequenceGenerator(name = "image_seq", sequenceName = "image_seq", allocationSize = 1)
    private Long imageId;

    @Column(name = "image_name", columnDefinition = "nvarchar2(100)")
    private String imageName;

    @Column(name = "original_image_name", columnDefinition = "nvarchar2(100)")
    private String originalImageName;

    @Column(name = "volume", columnDefinition = "number")
    private Long volume;

    @Column(name = "create_at")
    private LocalDate createdDate;

//    @Column(name = "image_size", columnDefinition = "nvarchar2(15)")
//    private String size;

    @Column(name = "extension", columnDefinition = "nvarchar2(10)")
    private String extension;

    public Image() {
    }

    public Image(String imageName, String originalImageName, Long volume, LocalDate createdDate, String extension) {
        this.imageName = imageName;
        this.originalImageName = originalImageName;
        this.volume = volume;
        this.createdDate = createdDate;
        this.extension = extension;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getOriginalImageName() {
        return originalImageName;
    }

    public void setOriginalImageName(String originalImageName) {
        this.originalImageName = originalImageName;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}