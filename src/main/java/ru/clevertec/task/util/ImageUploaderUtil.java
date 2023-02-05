package ru.clevertec.task.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ImageUploaderUtil {

    private ImageUploaderUtil() {

    }

    public static String save(MultipartFile image, String uploadDirectory) {
        Path uploadPath = Paths.get(uploadDirectory);
        String imageName = image.getOriginalFilename();
        try (InputStream inputStream = image.getInputStream()) {
            if (imageName != null) {
                Path filePath = uploadPath.resolve(imageName);
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageName;
    }
}