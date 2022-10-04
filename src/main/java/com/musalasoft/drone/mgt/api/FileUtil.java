package com.musalasoft.drone.mgt.api;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public abstract class FileUtil {

    public static String storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        Path imageStorageLocation = Paths.get("./images")
                .toAbsolutePath().normalize();

        try {
            // Check if the file's name contains invalid character

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = imageStorageLocation.resolve(fileName);
            File destFile = targetLocation.toFile();
            if (!destFile.exists()) {
                Files.createDirectories(targetLocation);
            }
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return file.getName();
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
}
