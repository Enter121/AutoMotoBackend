package me.yaacob.core.service;

import me.yaacob.core.model.Article;
import me.yaacob.core.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ArticleService {

    ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Transactional
    public Article createArticle(String author){
        Article article = new Article();
        article.setAuthor(author);
        articleRepository.save(article);
        return article;
    }

    @Transactional
    public void updateArticle(Article article){
        articleRepository.save(article);
    }

    @Transactional
    public void deleteArticle(Long id){
        articleRepository.deleteById(id);
    }

    @Transactional
    public Article getArticle(Long id){
        Optional<Article> article =articleRepository.findById(id);
        if(article.isPresent()){
            return  article.get();
        }
        return null;
    }

    @Transactional
    public List<Article> getAllArticles(){
        return articleRepository.findAll();
    }

    @Transactional
    public Page<Article> getArticles(Pageable pageable){
        return articleRepository.findAll(pageable);
    }




}
