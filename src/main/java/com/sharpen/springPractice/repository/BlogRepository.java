package com.sharpen.springPractice.repository;

import com.sharpen.springPractice.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
