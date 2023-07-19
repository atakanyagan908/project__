package com.example.project.service.abstracts;

import com.example.project.model.News;

import java.util.List;

public interface NewsService {
     void add(News news);
     void delete(Long id);
     void update(Long id, News news);
     List<News> findAll();
     News findById(Long id);


}
