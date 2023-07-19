package com.example.project.service.concretes;

import com.example.project.model.Notice;
import com.example.project.repository.NoticeRepository;
import com.example.project.service.abstracts.NoticeService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
public class NoticeManager implements NoticeService {

    private NoticeRepository noticeRepository;
    private FileService fileService;
    @Autowired
    public NoticeManager(NoticeRepository noticeRepository, FileService fileService)
    {
        this.noticeRepository = noticeRepository;
        this.fileService = fileService;
    }

    @Override
    public void add(Notice notice, MultipartFile image) {

        try{
            String imagePath = this.fileService.storeFile(image);
            notice.setImagePath(imagePath);
            this.noticeRepository.save(notice);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(Long id) {
        this.noticeRepository.deleteById(id);


    }

    @Override
    public void update(Long id, Notice notice, MultipartFile image) {
        try{
            String imagePath = this.fileService.storeFile(image);
            Optional<Notice> result = this.noticeRepository.findById(id);
            Notice _notice = result.get();
            _notice.setContent(notice.getContent());
            _notice.setHeader(notice.getHeader());
            _notice.setDate(notice.getDate());
            _notice.setImagePath(imagePath);
            this.noticeRepository.save(_notice);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }


    }

    @Override
    public List<Notice> findAll() {
        return this.noticeRepository.findAll();
    }

    @Override
    public Notice findById(Long id) {
        Optional<Notice> notice = this.noticeRepository.findById(id);
        return notice.get();
    }
}
