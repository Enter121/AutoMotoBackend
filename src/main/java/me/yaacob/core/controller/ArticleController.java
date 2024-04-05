package me.yaacob.core.controller;

import io.trbl.blurhash.BlurHash;
import me.yaacob.core.dto.ArticleDTO;
import me.yaacob.core.model.Article;
import me.yaacob.core.model.ImagePackage;
import me.yaacob.core.service.ArticleService;
import me.yaacob.core.service.StorageService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/article")
public class ArticleController {

    ArticleService articleService;
    StorageService storageService;

    @Autowired
    public ArticleController(ArticleService articleService, StorageService storageService) {
        this.articleService = articleService;
        this.storageService = storageService;
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Void> updateArticle(ArticleDTO articleDTO){
        Article article = articleService.getArticle(articleDTO.getArticleId());
        if(article!=null){
            article.update(articleDTO);
            articleService.updateArticle(article);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @GetMapping(value = "/delete/{id}")
    public void updateArticle(@PathVariable Long id){
       articleService.deleteArticle(id);
    }


    @PostMapping(value = "/uploadImage")
    public ResponseEntity<String> uploadImage(@RequestParam(value = "image") MultipartFile file, @RequestParam(value = "id") Long id)  {

        String uuid= UUID.randomUUID().toString();
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());

        Article article = articleService.getArticle(id);
        if(article==null)return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("bad id");

        String path= uuid.concat(".").concat(extension);


        String blurHash="";
        try{
            blurHash = BlurHash.encode(ImageIO.read(file.getInputStream()));
        }catch (IOException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("bad file format");
        }

        ImagePackage imagePackage = new ImagePackage(article.getId().toString(),path,blurHash);

        boolean okay=storageService.store(file,path);

        if(okay) {
            article.addImage(imagePackage);
            articleService.updateArticle(article);
        }


        return ResponseEntity.status(okay?HttpStatus.OK:HttpStatus.BAD_REQUEST).body(okay?("file uploaded"):"error");

    }



    @GetMapping("/getImage/{articleId}/{path}")
    @ResponseBody
    public ResponseEntity<InputStreamResource>  serveFile(@PathVariable(name = "articleId") Long articleId, @PathVariable(name = "path") String path) throws IOException {

        Article article = articleService.getArticle(articleId);

        if(article==null)return ResponseEntity.badRequest().build();
        Resource resource = storageService.getResource(article,path);

        if (resource == null)
            return ResponseEntity.notFound().build();

        //return //ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                //"attachment; filename=\"" + resource.getFilename() + "\"").body(resource);

        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(new InputStreamResource(resource.getInputStream()));
    }


}
