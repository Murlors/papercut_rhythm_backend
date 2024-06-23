package com.example.papercut_rhythm_backend.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommentMapper {

    Integer getCommentCountByTopicId(Integer topicId, String type);

    List<Map<String, Object>> getCommentListByTopicId(Integer topicId, String type);

    Integer addComment(Integer topicId, Integer userId, String content, String type);
}
