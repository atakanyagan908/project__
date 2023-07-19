package com.example.project.service.concretes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileService {
    @Value("${file.upload-dir}")
    private String uploadDir;

    public String storeFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        File targetFile = new File(uploadDir + "/" + fileName);
        file.transferTo(targetFile);
        return targetFile.getAbsolutePath();
    }
}
