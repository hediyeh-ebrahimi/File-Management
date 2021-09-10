package com.file.bean;

import com.file.Spring;
import com.file.model.entity.Image;
import com.file.model.service.ImageService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@ManagedBean
@RequestScoped
public class Index {
    private Part imageUploaded;
    private String uploadMessage;
    private List<Image> images;

    @Autowired
    private ImageService imageService;

    public Part getImageUploaded() {
        return imageUploaded;
    }

    public void setImageUploaded(Part imageUploaded) {
        this.imageUploaded = imageUploaded;
    }


    public String getUploadMessage() {
        return uploadMessage;
    }

    public void setUploadMessage(String uploadMessage) {
        this.uploadMessage = uploadMessage;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public ImageService getImageService() {
        return imageService;
    }

    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        Index.applicationContext = applicationContext;
    }

    private static ApplicationContext applicationContext = null;
    public Index() {
//        applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        this.imageService = (ImageService) Spring.getBean("imageService");
        this.images = this.imageService.findAll();
    }

    public String uploadImage() throws IOException, URISyntaxException {
        if (this.imageUploaded.getSize() > 0) {
            String fileName = StringUtils.cleanPath(this.imageUploaded.getSubmittedFileName());
            String name = UUID.randomUUID() + "." + FilenameUtils.getExtension(fileName);
            String uploadDir = "F:\\java_tutorial\\file-Management\\web\\resources\\images";
            String cachedDir = FacesContext.getCurrentInstance().getExternalContext().getRealPath("")+
                     File.separator +"resources" + File.separator + "images";

            Path copyLocation = Paths
                    .get(uploadDir + File.separator + StringUtils.cleanPath(name));
            Path cachedCopyLocation = Paths
                    .get(cachedDir + File.separator + StringUtils.cleanPath(name));
            String extension = FilenameUtils.getExtension(this.imageUploaded.getSubmittedFileName());
            System.out.println(extension);
            List<String> availableExtensions = Arrays.asList("jpec","gif","png");
            if (!availableExtensions.contains(extension)) {
                setUploadMessage("File is occured by error of type.");
                return "index";
            }

            try {
                Files.copy(this.imageUploaded.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
                Files.copy(this.imageUploaded.getInputStream(), cachedCopyLocation, StandardCopyOption.REPLACE_EXISTING);
                setUploadMessage("File is uploaded successfully.");
                Image image = new Image();
                image.setImageName(name);
                image.setOriginalImageName(fileName);
                image.setVolume(this.imageUploaded.getSize());
                image.setCreatedDate(LocalDate.now());
                image.setExtension (extension);
                this.imageService.save(image);
            } catch (Exception e) {
                setUploadMessage("File is occured by error.");
                e.printStackTrace();
            }
        }
        this.images =  this.imageService.findAll();
        return "index";
    }


}