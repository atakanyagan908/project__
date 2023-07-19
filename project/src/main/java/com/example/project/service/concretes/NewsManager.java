package com.example.project.service.concretes;

import com.example.project.model.News;
import com.example.project.repository.NewsRepository;
import com.example.project.repository.NoticeRepository;
import com.example.project.service.abstracts.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Component
public class NewsManager implements NewsService {
    private NewsRepository newsRepository;
    @Autowired
    public NewsManager(NewsRepository newsRepository)
    {
        this.newsRepository = newsRepository;
    }

    @Override
    public void add(@RequestBody News news) {
        this.newsRepository.save(news);
    }

    @Override
    public void delete(Long id) {
        this.newsRepository.deleteById(id);
    }

    @Override
    public void update(Long id, News news) {
        Optional<News> result = this.newsRepository.findById(id);
        News _news = result.get();
        _news.setHeader(news.getHeader());
        _news.setContent(news.getContent());
        _news.setNewsLink(news.getNewsLink());
        _news.setDate(news.getDate());
        this.newsRepository.save(_news);
    }

    @Override
    public List<News> findAll() {
        return this.newsRepository.findAll();
    }

    @Override
    public News findById(Long id) {
        Optional<News> news = this.newsRepository.findById(id);
        return news.get();
    }
}
