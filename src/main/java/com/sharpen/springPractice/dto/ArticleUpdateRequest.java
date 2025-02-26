package com.sharpen.springPractice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleUpdateRequest {

    private final String title;
    private final String content;
}
