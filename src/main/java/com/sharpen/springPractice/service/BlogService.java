package com.sharpen.springPractice.service;

import com.sharpen.springPractice.domain.Article;
import com.sharpen.springPractice.dto.ArticleCreateRequest;
import com.sharpen.springPractice.dto.ArticleUpdateRequest;
import com.sharpen.springPractice.exception.MyEntityNotFoundException;
import com.sharpen.springPractice.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(ArticleCreateRequest request) {
        return blogRepository.save(request.toEntity());
    }

    @Transactional(readOnly = true)
    public Page<Article> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Article findById(long id) {
        return findArticle(id);
    }

    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    public Article update(long id, ArticleUpdateRequest request) {
        Article article = findArticle(id);

        article.update(request.getTitle(), request.getContent());
        return article;
    }

    private Article findArticle(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> MyEntityNotFoundException.of(id));
    }
}
