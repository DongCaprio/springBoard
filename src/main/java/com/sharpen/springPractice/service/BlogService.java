package com.sharpen.springPractice.service;

import com.sharpen.springPractice.domain.Article;
import com.sharpen.springPractice.dto.ArticleCreateRequest;
import com.sharpen.springPractice.dto.ArticleUpdateRequest;
import com.sharpen.springPractice.repository.BlogRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(ArticleCreateRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
    }

    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, ArticleUpdateRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not fount : " + id));

        article.update(request.getTitle(), request.getContent());
        return article;
    }
}
