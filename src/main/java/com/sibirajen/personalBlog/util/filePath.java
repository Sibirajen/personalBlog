package com.sibirajen.personalBlog.util;

import java.nio.file.Path;

public class filePath {
    private final Path articlePath = Path.of("src/main/java/com/sibirajen/personalBlog/data/article");
    private final Path userPath = Path.of("src/main/java/com/sibirajen/personalBlog/data/user");

    public Path getArticlePath() {
        return articlePath;
    }

    public Path getUserPath() {
        return userPath;
    }
}
