package me.yaacob.core.service;

import me.yaacob.core.model.Article;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

@Service
public class StorageService {


    public Path fileLocation= Paths.get("uploads");

    public boolean store(MultipartFile file, String path) {

        File newFile = fileLocation.resolve(path).normalize().toFile();


    try{
        FileUtils.copyInputStreamToFile(file.getInputStream(), newFile);
        return true;
    }catch (IOException e){
        return false;
    }

    }
    public Resource getResource(Article article,String filename) {
        try{
            return new UrlResource(fileLocation.resolve(article.getId().toString().concat("/").concat(filename)).toUri());
        }catch (MalformedURLException e){
            return null;
        }

    }


}
