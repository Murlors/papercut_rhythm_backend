package com.example.papercut_rhythm_backend.mapper;

import com.example.papercut_rhythm_backend.bean.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Map;


@Mapper
@Repository
@Component
public interface ForumMapper {

    @Select("SELECT t.id, t.title,t.content,t.content,t.status,t.create_time, u.id as u_id,u.username,u.avatar,u.`rank` as u_rank,u.role_id,u.introduction,u.email\n" +
            "FROM topic t left JOIN user u on u.id = t.creator_id ORDER BY t.create_time DESC")
    ArrayList<Map<String, Object>> getTopicList();

    @Select("SELECT * FROM topic WHERE id = #{id} ORDER BY create_time DESC")
    Map<String, Object> getTopicById(String topicId);

    @Select("SELECT * FROM topic WHERE creator_id = #{keyUserId} ORDER BY create_time DESC")
    ArrayList<Map<String, Object>> getTopicByUserId(Integer keyUserId);

    @Select("SELECT t.id, t.title,t.content,t.content,t.status,t.create_time, u.id as u_id,u.username,u.avatar,u.`rank` as u_rank,u.role_id,u.introduction,u.email " +
            "FROM topic t left JOIN user u on u.id = t.creator_id WHERE t.title LIKE CONCAT('%',#{keyword},'%') ORDER BY t.create_time DESC")
    ArrayList<Map<String, Object>> searchTopic(String keyword);

    @Select("SELECT * FROM comment WHERE comment_topic_id = #{topicId} AND type = '1' ORDER BY comment_time DESC")
    ArrayList<Comment> getTopicCommentById(Integer topicId);


    @Insert("INSERT INTO comment (comment_topic_id,comment_user_id,content,comment_time,type) VALUES (#{topicId},#{userId},#{content},NOW(),'1')")
    Integer addTopicComment(String topicId, String content, String userId);

    @Select("SELECT u.id,u.username,u.avatar,u.`rank`,u.role_id,COUNT(t.id) as topic_count,u.introduction FROM user u LEFT JOIN topic t on t.creator_id = u.id GROUP BY u.id ORDER BY COUNT(t.id) DESC LIMIT 3")
    ArrayList<Map<String, Object>> getTopAuthorList();

    @Insert("INSERT INTO topic (title,content,creator_id,create_time,status) VALUES (#{title},#{content},#{userId},NOW(),'1')")
    Integer addTopic(String title, String content, String userId);

    //获取贴子的总数
    @Select("SELECT COUNT(*) FROM topic")
    Integer getTopicCount();

    @Delete("DELETE FROM topic WHERE id = #{topicId}")
    Integer deleteTopic(String topicId);

    @Select("SELECT COUNT(*) FROM comment WHERE type = \"1\"")
    Integer getAllCommentCount();

    @Select("SELECT SUM(visit_count) FROM topic ")
    Integer getAllVisitCount();

    @Update("UPDATE topic SET visit_count = visit_count+1 WHERE id=#{topicId}")
    Integer addVisitCount(String topicId);

    @Delete("DELETE FROM topic WHERE id = #{topicId}")
    Integer deleteTopicById(String topicId);
}
