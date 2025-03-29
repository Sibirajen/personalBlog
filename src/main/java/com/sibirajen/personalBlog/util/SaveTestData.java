package com.sibirajen.personalBlog.util;

import com.sibirajen.personalBlog.model.Article;
import com.sibirajen.personalBlog.repository.ArticleRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SaveTestData {

    public static void main(String[] args) {
        ArticleRepository repo = new ArticleRepository();
        List<Article> articles = new ArrayList<>();

        articles.add(new Article("John Doe", "A004", "Microservices with Spring Boot",
                "Microservices architecture has revolutionized software development by enabling scalable and maintainable applications. " +
                        "Spring Boot, in combination with Spring Cloud, simplifies the development of microservices by providing built-in tools for service discovery, " +
                        "configuration management, and inter-service communication. This article explores key concepts such as API gateway, circuit breakers, " +
                        "distributed tracing, and database per microservice patterns, helping developers design robust microservices applications.",
                LocalDate.of(2024, 3, 20)));

        articles.add(new Article("Jane Smith", "A005", "Optimizing Spring Boot Applications",
                "Performance optimization is crucial for any production-ready Spring Boot application. This article discusses best practices " +
                        "such as enabling caching, using asynchronous processing, reducing memory footprint, and optimizing database queries with JPA and Hibernate. " +
                        "Additionally, it covers profiling tools like Spring Boot Actuator and Micrometer to monitor performance metrics effectively, ensuring " +
                        "your applications run smoothly under high load conditions.",
                LocalDate.of(2024, 2, 15)));

        articles.add(new Article("Michael Johnson", "A006", "Securing REST APIs with JWT",
                "In modern applications, securing REST APIs is a top priority. JSON Web Token (JWT) authentication is widely used to ensure " +
                        "secure and stateless authentication. This article walks through implementing JWT authentication in Spring Boot, including " +
                        "token generation, validation, and role-based access control. It also explains integrating Spring Security with JWT to protect " +
                        "endpoints and enhance API security, making sure only authorized users access sensitive data.",
                LocalDate.of(2024, 1, 10)));


        for(Article article: articles){
            repo.save(article);
        }
    }
}
