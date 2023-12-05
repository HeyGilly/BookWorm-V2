package com.bookworm.bookwormv2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    //== Method is used to save the user Profile picture to the correct directory.
    public void saveFile(MultipartFile file, String fileName) throws IOException {
        try {
            //== Create a variable that captures the path where the file will be saved.
            Path directory = Paths.get("src/main/resources/static/img/profilePicture/");
            //== Check to see if the directory exists
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }

            //== Combines both file path and file name
            Path filePath = Paths.get(String.valueOf(directory), fileName);
            //== This writes the img file to the specific file path.
            Files.write(filePath, file.getBytes());
        } catch (IOException e) {
            throw new IOException("Failed to save file: " + e.getMessage());
        }
    }
}
