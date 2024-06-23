package com.example.papercut_rhythm_backend.mapper;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleMapper {

    Map<String, Object> getArticleById(Integer articleId);

    Integer addArticle(String title, String content, Integer creatorId, Integer columnId, String coverImg);

    Integer addVisitCount(Integer articleId);

    List<Map<String, Object>> getArticleByUserId(Integer keyUserId);

    Integer deleteArticleById(Integer articleId);
}
