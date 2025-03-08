package com.sibirajen.personalBlog.repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class writeData {

    private final ObjectMapper objectMapper;

    public writeData() {
        this.objectMapper = new ObjectMapper();
    }

    public <T> void write(T bean, Path path) throws IOException {
        Files.createDirectories(path);
        objectMapper.writeValue(path.toFile(), bean.getClass());
    }
}
