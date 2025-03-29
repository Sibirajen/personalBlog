package com.sibirajen.personalBlog.repository;

import com.sibirajen.personalBlog.model.Article;
import com.sibirajen.personalBlog.util.GenerateFileID;
import com.sibirajen.personalBlog.util.enums.Type;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@Repository
public class ArticleRepository {
    private final JsonFileDatabase<Article> database;
    private static final Path articlePath = Path.of("/articles");

    public ArticleRepository() {
        this.database = new JsonFileDatabase<>(articlePath.toString());
    }

    public static String getFileId(String id){
        return GenerateFileID.getId(id, Type.ARTICLE);
    }

    public Article getArticleById(String id){
        try {
            return database.readFile(id , Article.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Article article){
        try {
            database.writeFile(article.getArticleId(), article);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Article> getArticles() {
        try {
            return database.readAllFiles(Article.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
