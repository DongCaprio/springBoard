package com.sharpen.springPractice.dto;

import com.sharpen.springPractice.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ArticleDto {
    
    private String title;
    private String content;

    public ArticleDto(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }

    public Article toEntity() {
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
