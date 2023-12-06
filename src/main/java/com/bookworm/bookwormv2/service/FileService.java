package com.bookworm.bookwormv2.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


//-- This service is to save the uploaded image into a directory.
@Service
public class FileService {


    public String saveFile(MultipartFile file) throws IOException {

        //== The pathway that the image is going to be saved in.
        String uploadDir = "src/main/resources/static/img/profilePicture/";

        // Check if the directory exists, create it if not
        Path directory = Paths.get(uploadDir);
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }

        //== Generates a Unique Name for the file
        String fileName =  System.currentTimeMillis() + "_" + file.getOriginalFilename();
        //== Creating the full a new pathway for the uploaded file to be saved in the system.
        Path filePath = Path.of(uploadDir + fileName);

        //== When you upload a file using a web form, the content of the file is typically sent as a part of a HTTP request body.
        //== Basically turns string into stream bytes.
        //== Memory efficient and can read and process content without loading entire file.
        //== StandardCopyOption.REPLACE_EXISTING ->  if the target file already exists, copy over it.
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return fileName;
    }



}
