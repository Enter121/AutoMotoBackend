package me.yaacob.core.service;

import me.yaacob.core.model.Article;
import me.yaacob.core.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticleService {

    ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    public Article createArticle(String author){
        Article article = new Article();
        article.setAuthor(author);
        articleRepository.save(article);
        return article;
    }

    public List<Article> getAllArticles(){
        return articleRepository.findAll();
    }

    public Page<Article> getArticles(Pageable pageable){
        return articleRepository.findAll(pageable);
    }


}
