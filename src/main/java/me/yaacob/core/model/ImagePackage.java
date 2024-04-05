package me.yaacob.core.model;



import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class ImagePackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String path;

    private String articleId;

    private String blurHash;


    public ImagePackage(String articleId, String path, String blurHash) {
        this.articleId = articleId;
        this.path = path;
        this.blurHash = blurHash;
    }

    public ImagePackage() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getBlurHash() {
        return blurHash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBlurHash(String blurHash) {
        this.blurHash = blurHash;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }
}
