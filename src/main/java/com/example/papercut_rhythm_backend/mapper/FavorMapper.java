package com.example.papercut_rhythm_backend.mapper;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FavorMapper {
    //添加收藏
    Integer addFavor(Integer workId, Integer userId, String workType);

    //删除收藏
    Integer deleteFavor(Integer workId, Integer userId, String workType);

    Integer isFavor(Integer workId, Integer userId, String workType);
}
