package com.example.papercut_rhythm_backend.mapper;

import com.example.papercut_rhythm_backend.bean.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.Map;


@Mapper
public interface ForumMapper {

    ArrayList<Map<String, Object>> getTopicList();

    Map<String, Object> getTopicById(String topicId);

    ArrayList<Map<String, Object>> getTopicByUserId(Integer keyUserId);

    ArrayList<Map<String, Object>> searchTopic(String keyword);

    ArrayList<Comment> getTopicCommentById(Integer topicId);

    Integer addTopicComment(String topicId, String content, String userId);

    ArrayList<Map<String, Object>> getTopAuthorList();

    Integer addTopic(String title, String content, String userId);

    //获取贴子的总数
    Integer getTopicCount();

    Integer deleteTopic(String topicId);

    Integer getAllCommentCount();

    Integer getAllVisitCount();

    Integer addVisitCount(String topicId);

    Integer deleteTopicById(String topicId);
}
