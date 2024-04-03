package me.yaacob.core.controller;

import me.yaacob.core.dto.PreviewDTO;
import me.yaacob.core.model.Article;
import me.yaacob.core.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/automoto")
public class AutoMotoController {

    ArticleService articleService;

    @Autowired
    public AutoMotoController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/getPreviews")
    public Page<PreviewDTO> getPreview(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page,size, Sort.by("author").ascending());
        return articleService.getArticles(pageable).map(PreviewDTO::map);
    }


    @GetMapping("/createArticle")
    public ResponseEntity<String> createArticle(@RequestParam(defaultValue = "") String author){
        if(author.isEmpty()){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Lack of author");
        }
        Article article = articleService.createArticle(author);
        return ResponseEntity.ok(article.getId().toString());
    }


}
