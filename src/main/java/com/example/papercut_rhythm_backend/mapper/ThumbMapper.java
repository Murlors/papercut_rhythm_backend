package com.example.papercut_rhythm_backend.mapper;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ThumbMapper {

    Integer getThumbsCountByTopicId(Integer topicId, String type);

    Integer addThumbs(Integer topicId, Integer userId, String type);

    Integer deleteThumbs(Integer topicId, Integer userId, String type);

    //是否点过赞了
    Integer isThumbs(Integer topicId, Integer userId, String type);
}
