package com.example.project.controller;

import com.example.project.model.Notice;
import com.example.project.service.abstracts.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")

public class NoticeController {

    private NoticeService noticeService;
    @Autowired
    public NoticeController(NoticeService noticeService)
    {
        this.noticeService = noticeService;
    }



    @PostMapping("/notices")
    public ResponseEntity<HttpStatus> addNotice(Notice notice,@RequestParam("image") MultipartFile image) {
        this.noticeService.add(notice,image);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/notices/{id}")
    public ResponseEntity<HttpStatus> deleteNotice(@PathVariable("id") Long id){
        try{
            this.noticeService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/notices/{id}")
    public ResponseEntity<HttpStatus> updateNotice(@PathVariable("id") Long id,Notice notice, @RequestParam("image") MultipartFile image){
        try{
            this.noticeService.update(id,notice,image);
            return new ResponseEntity<>(HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/notices")
    public ResponseEntity<List<Notice>> getAllNotices(){
        try{
            List<Notice> notices = this.noticeService.findAll();
            return new ResponseEntity<>(notices, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/notices/{id}")
    public ResponseEntity<Notice> getNoticeById(@PathVariable Long id){
        try{

            return new ResponseEntity<>(this.noticeService.findById(id),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }






}
