package com.example.papercut_rhythm_backend.mapper;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ThumbMapper {

    @Select("SELECT COUNT(*) FROM thumbs WHERE type = #{type} AND thumbs_topic_id = #{topicId}")
    Integer getThumbsCountByTopicId(Integer topicId, String type);

    @Insert("INSERT INTO thumbs (thumbs_topic_id,thumbs_user_id,type) VALUES (#{topicId},#{userId},#{type})")
    Integer addThumbs(Integer topicId, Integer userId, String type);

    @Delete("DELETE FROM thumbs WHERE thumbs_topic_id = #{topicId} AND thumbs_user_id = #{userId} AND type = #{type}")
    Integer deleteThumbs(Integer topicId, Integer userId, String type);

    //是否点过赞了
    @Select("SELECT COUNT(*) FROM thumbs WHERE type = #{type} AND thumbs_topic_id = #{topicId} AND thumbs_user_id = #{userId}")
    Integer isThumbs(Integer topicId, Integer userId, String type);
}
