package com.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

public class UploadHelper {

    private final int limit_max_size = 10240000;
    private final String limit_type_file = "gif|jpg|png|jpeg";
    private final String path_to = "resources" + File.separator + "images";

    public String processUpload(Part fileUpload) {
        System.out.println("------------19-------------");
        String fileSaveData = "noimages.jpg";
        try {
            if (fileUpload.getSize() > 0) {
                String submittedFileName = getFilename(fileUpload);
                System.out.println("------------24-------------");
                if (checkFileType(submittedFileName)) {
                    if (fileUpload.getSize() > this.limit_max_size) {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "File size too large!", ""));
                    } else {
                        String currentFileName = submittedFileName;
                        System.out.println("------------30-------------");
                        String extension = currentFileName.substring(currentFileName.lastIndexOf("."), currentFileName.length());
                        Long nameRadom = Calendar.getInstance().getTimeInMillis();
                        String newfilename = nameRadom + extension;
                        fileSaveData = newfilename;
//                        String fileSavePath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("") + this.path_to;
//                        System.out.println("-----**------"+FacesContext.getCurrentInstance().);
                        System.out.println("-----35------"+FacesContext.getCurrentInstance().getExternalContext().getRealPath(""));
                        System.out.println("-----36------"+File.separator);
                        System.out.println("-----37------"+this.path_to);
//                        String fileSavePath = "resources\\images";
//                        String fileSavePath = "F:\\java_tutorial\\file-Management\\src\\images";
                        String fileSavePath = "\\src\\images";
                        try {
                            System.out.println("------------37-------------");
                            byte[] fileContent = new byte[(int) fileUpload.getSize()];
                            InputStream in = fileUpload.getInputStream();
                            in.read(fileContent);

                            File fileToCreate = new File(fileSavePath, newfilename);
                            File folder = new File(fileSavePath);
                            System.out.println("------------44---------");
                            if (!folder.exists()) {
                                System.out.println("------------46---------");
                                folder.mkdirs();
                            }
                            FileOutputStream fileOutStream = new FileOutputStream(fileToCreate);
                            fileOutStream.write(fileContent);
                            fileOutStream.flush();
                            fileOutStream.close();
                            System.out.println("------------51-------------");
                            fileSaveData = newfilename;
                        } catch (IOException e) {
                            fileSaveData = "noimages.jpg";
                        }
                    }
                } else {
                    fileSaveData = "noimages.jpg";
                }
                System.out.println("------------60-------------");
            }
        } catch (Exception ex) {
            fileSaveData = "noimages.jpg";
            System.out.println("------------64-------------");
        }
        System.out.println("------------67-------------"+fileSaveData);
        return fileSaveData;
    }

    private String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1);
            }
        }
        return null;
    }

    private boolean checkFileType(String fileName) {
        if (fileName.length() > 0) {
            String[] parts = fileName.split("\\.");
            if (parts.length > 0) {
                String extention = parts[parts.length - 1];
                return this.limit_type_file.contains(extention);
            }
        }
        return false;
    }

}