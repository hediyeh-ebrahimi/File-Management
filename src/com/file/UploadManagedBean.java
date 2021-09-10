package com.file;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;


@SessionScoped
@ManagedBean(name = "uploadManagedBean")
public class UploadManagedBean {


    private String photo = "";
    private Part part;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public String processUpload() {
        UploadHelper uploadHelper = new UploadHelper();
        this.photo = uploadHelper.processUpload(this.part);
        return "result";
    }

}