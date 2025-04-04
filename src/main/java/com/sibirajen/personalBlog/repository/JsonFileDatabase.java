package com.sibirajen.personalBlog.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JsonFileDatabase<T> {
    private final ObjectMapper objectMapper;
    private final Path DATABASE_PATH;

    public JsonFileDatabase(String path) {
        this.objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        this.DATABASE_PATH = Path.of("src/main/java/com/sibirajen/personalBlog/data", path);
    }

    public void writeFile(String id, T bean) throws IOException {
        Path filePath = DATABASE_PATH.resolve( id + ".json");
        Files.createDirectories(DATABASE_PATH);
        objectMapper.writeValue(filePath.toFile(), bean);
    }

    public List<T> readAllFiles(Class<T> clazz) throws IOException {
        try (Stream<Path> paths = Files.list(DATABASE_PATH)) {
            return paths
                    .filter( path -> path.toString().endsWith(".json"))
                    .map( path -> {
                        try {
                            return objectMapper.readValue(path.toFile(), clazz);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .collect(Collectors.toList());
        }
    }

    public T readFile(String id, Class<T> clazz) throws IOException {
        Path filePath = DATABASE_PATH.resolve(id + ".json");
        if(!Files.exists(filePath)){
            throw new RuntimeException("File doesn't exists");
        }
        return objectMapper.readValue(filePath.toFile(), clazz);
    }
}
