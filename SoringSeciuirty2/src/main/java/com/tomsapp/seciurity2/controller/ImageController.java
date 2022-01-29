package com.tomsapp.seciurity2.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ImageController {

    Cloudinary cloudinary;

    ImageController(){

        Map config = new HashMap();
        config.put("cloud_name", "dviam7axd");
        config.put("api_key", "185763631689782");
        config.put("api_secret", "e-mcRQXC0YPsWY909qVtuM2WOLI");
        this.cloudinary = new Cloudinary(config);

    }

    public String saveImage(String fileSource){

        File file = new File(fileSource);

        Map upload = null;
        try {
            upload = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Object url = upload.get("url");

        return url.toString();
    }

}
