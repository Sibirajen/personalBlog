package com.sibirajen.personalBlog.repository;

import com.sibirajen.personalBlog.model.Article;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
