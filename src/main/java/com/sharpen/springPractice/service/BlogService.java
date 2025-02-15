package com.sharpen.springPractice.service;

import com.sharpen.springPractice.domain.Article;
import com.sharpen.springPractice.dto.AddArticleRequestDto;
import com.sharpen.springPractice.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequestDto request) {
        return blogRepository.save(request.toEntity());
    }
}
