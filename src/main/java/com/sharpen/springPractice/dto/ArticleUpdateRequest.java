package com.sharpen.springPractice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ArticleUpdateRequest {

    private String title;
    private String content;
}
