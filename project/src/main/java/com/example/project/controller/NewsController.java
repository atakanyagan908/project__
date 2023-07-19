package com.example.project.controller;

import com.example.project.model.News;
import com.example.project.model.Notice;
import com.example.project.service.abstracts.NewsService;
import com.example.project.service.abstracts.NoticeService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NewsController {

    private NewsService newsService;
    @Autowired
    public NewsController(NewsService newsService)
    {
        this.newsService = newsService;
    }

    @PostMapping("/news")
    public ResponseEntity<HttpStatus> addNews(@RequestBody News news){
        try{
            this.newsService.add(news);
            return new ResponseEntity<>(HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }
    @PutMapping("/news/{id}")
    public ResponseEntity<HttpStatus> updateNews(@PathVariable Long id,@RequestBody News news){
        try{
            this.newsService.update(id,news);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }
    @DeleteMapping("/news/{id}")
    public ResponseEntity<HttpStatus> deleteNews(@PathVariable Long id)
    {
        try{
            this.newsService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/news")
    public ResponseEntity<List<News>> getAllNews(){

        try{
            List<News> news = this.newsService.findAll();
            return new ResponseEntity<>(news,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/news/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable Long id){
        try{
            News news = this.newsService.findById(id);
            return new ResponseEntity<>(news,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

}
