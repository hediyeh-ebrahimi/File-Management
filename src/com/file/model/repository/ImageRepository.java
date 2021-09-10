package com.file.model.repository;

import com.file.model.entity.Image;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ImageRepository {
    @PersistenceContext
    private EntityManager entityManger;

    public List<Image> findAll(){
        return this.entityManger.createQuery("select entity from image entity").getResultList();
    }

    @Transactional
    public void insert(Image image){
//        image.setImageName("11");
//        image.setOriginalImageName("22");
//        image.setCreatedDate(LocalDate.now());
//        image.setExtension("png");
//        image.setVolume(12L);
        System.out.println("----------22--------"+image.getImageName());
        System.out.println("----------23--------"+image.getExtension());
        System.out.println("----------24--------"+image.getOriginalImageName());
        System.out.println("----------25--------"+image.getCreatedDate());
        System.out.println("----------26--------"+image.getVolume());
        System.out.println("----------27--------"+image.getImageId());
        this.entityManger.persist(image);
    }
}
