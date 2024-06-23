package com.example.papercut_rhythm_backend.service;

import com.example.papercut_rhythm_backend.bean.Comment;
import com.example.papercut_rhythm_backend.bean.R;

import java.util.ArrayList;
import java.util.Map;

public interface ForumService {


    R<ArrayList<Map<String, Object>>> getTopicList(Integer currentPage, Integer pageSize, String userId);

    R<Map<String, Object>> getTopicDetail(String id);

    R<ArrayList<Map<String, Object>>> searchTopic(String keyword, String userId);

    R<ArrayList<Comment>> getTopicComment(String topicId);

    R<String> likeTopic(String topicId, String userId);

    R<String> addTopicComment(String topicId, String content, String userId);

    R<ArrayList<Map<String, Object>>> getTopAuthorList();

    R<String> addTopic(String title, String content, String userId);

    R<String> deleteTopic(String topicId);

    R<Map<String, Object>> getAllCommentCount();

    R<Map<String, Object>> getAllVisitCount();


    R<ArrayList<Map<String, Object>>> searchTopicByUserId(String keyUserId, String userId);

    R<String> deleteTopicById(String topicId);

}
