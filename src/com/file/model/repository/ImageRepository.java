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
        this.entityManger.persist(image);
    }

    @Transactional
    public void delete(Image image) {
        this.entityManger.remove(this.entityManger.contains(image) ? image : this.entityManger.merge(image));

    }
}
