package com.example.papercut_rhythm_backend.service;

public interface ThumbsService {


    Integer getThumbsCountByTopicId(Integer thumbsTopicId, String type);

    Integer addThumbs(String topicId, String userId, String type);

    Integer deleteThumbs(String topicId, String userId, String type);

    //是否点过赞了
    Integer isThumbs(String topicId, String userId, String type);
}
