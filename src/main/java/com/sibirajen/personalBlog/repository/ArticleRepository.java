package com.sibirajen.personalBlog.repository;

import com.sibirajen.personalBlog.util.GenerateFileID;
import com.sibirajen.personalBlog.util.enums.Type;
import org.springframework.stereotype.Repository;

import java.nio.file.Path;

@Repository
public class ArticleRepository {
    private final JsonFileDatabase database;
    private static final Path articlePath = Path.of("/articles");

    public ArticleRepository() {
        this.database = new JsonFileDatabase(articlePath.toString());
    }

    public static String getFileId(String id){
        return GenerateFileID.getId(id, Type.ARTICLE);
    }
}
