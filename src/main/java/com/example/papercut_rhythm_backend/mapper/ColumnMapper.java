package com.example.papercut_rhythm_backend.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ColumnMapper {
    //获取所有专栏
    List<Map<String, Object>> getAllColumns();

    Integer getColumnFavorCountByColumnId(String columnIdString);

    Integer getColumnArtCountByColumnId(String columnIdString);

    List<Map<String, Object>> getColumnLabels(Integer ColumnId);

    List<Map<String, Object>> getColumnArticles(Integer ColumnId);

    String getColumnTitleByColumnId(Integer ColumnId);

    Integer addColumn(Integer userId, String title, String content, String coverImg);

    Map<String, Object> getColumn(String columnId);

    List<Map<String, Object>> getColumnByUserId(Integer userId);

    void deleteColumn(Integer id);
}
