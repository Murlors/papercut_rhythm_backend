package com.example.papercut_rhythm_backend.service;

import com.example.papercut_rhythm_backend.bean.R;

import java.util.List;
import java.util.Map;

public interface ArticleService {
    R<Map<String, Object>> getArticle(String articleId);

    R<String> addArticle(String title, String content, String creatorId, String columnId, String coverImg);

    R<List<Map<String, Object>>> getArticleByUserId(String keyuserId);

    R<String> deleteArticleById(String articleId);

    R<String> thumbUpArticle(String articleId, String userId);
}
