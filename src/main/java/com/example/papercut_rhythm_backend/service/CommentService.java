package com.example.papercut_rhythm_backend.service;

import com.example.papercut_rhythm_backend.bean.R;

import java.util.List;
import java.util.Map;

public interface CommentService {
    Integer getCommentCountByTopicId(Integer TopicId, String type);

    R<List<Map<String, Object>>> getCommentListByTopicId(Integer TopicId, String type);

    R<String> addComment(String topicId, String userId, String content, String type);


}
