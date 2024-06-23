package com.example.papercut_rhythm_backend.service;

import com.example.papercut_rhythm_backend.bean.R;

import java.util.List;
import java.util.Map;

public interface ColumnService {

    R<List<Map<String, Object>>> getAllColumns(String userId);

    R<List<Map<String, Object>>> getColumnLabels(Integer ColumnId);

    R<List<Map<String, Object>>> getColumnArticles(Integer currentPage, Integer pageSize, Integer ColumnId, String userId);

    R<String> favorColumn(String columnId, String user_id);

    //添加专栏
    R<String> addColumn(String title, String content, String user_id, String coverImg);

    R<Map<String, Object>> getColumn(String userId, String columnId);

    R<String> notFavorColumn(String columnId, String userId);

    R<List<Map<String, Object>>> getColumnByUserId(String keyUserId);

    R<String> deleteColumn(String id);
}



