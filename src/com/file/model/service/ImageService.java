package com.file.model.service;

import com.file.Spring;
import com.file.model.entity.Image;
import com.file.model.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    private ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        System.out.println("----------**************888888-----------------");
        this.imageRepository = imageRepository;
    }

    public List<Image> findAll(){
        return this.imageRepository.findAll();
    }

    public void save(Image image){
        this.imageRepository.insert(image);
    }
}
