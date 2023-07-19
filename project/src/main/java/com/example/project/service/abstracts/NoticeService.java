package com.example.project.service.abstracts;


import com.example.project.model.Notice;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface NoticeService {
    void add(Notice notice, MultipartFile image);
    void delete(Long id);
    void update(Long id, Notice notice, MultipartFile file);
    List<Notice> findAll();
    Notice findById(Long id);
}
