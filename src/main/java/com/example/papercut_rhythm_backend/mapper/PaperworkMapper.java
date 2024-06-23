package com.example.papercut_rhythm_backend.mapper;


import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.Map;

@Mapper
public interface PaperworkMapper {

    ArrayList<Map<String, Object>> getPaperwork();

    void uploadPaperwork(String title, Integer author_id, String content, String img_url);

    void uploadPaperworkWithColor(String title, Integer author_id, String img_url, String content, String background_color);

    void uploadPaperworkWithImage(String title, Integer author_id, String img_url, String content, String background_url);

    ArrayList<Map<String, Object>> getPaperworkByAuthorId(Integer id);

    ArrayList<Map<String, Object>> getPaperworkById(Integer id);

    ArrayList<Map<String, Object>> deletePaperworkById(Integer id);
}
