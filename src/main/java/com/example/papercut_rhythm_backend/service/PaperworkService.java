package com.example.papercut_rhythm_backend.service;

import com.example.papercut_rhythm_backend.bean.R;

import java.util.ArrayList;
import java.util.Map;

public interface PaperworkService {
    R<ArrayList<Map<String, Object>>> getPaperwork(Integer currentPage, Integer pageSize);

    R<String> uploadPaperwork(Integer userId, String title, String content, String imageUrl, String backgroundCustom, String color, String backgroundUrl);

    R<ArrayList<Map<String, Object>>> getPaperworkByAuthorId(String id);

    R<ArrayList<Map<String, Object>>> getPaperworkById(String id);

    R<ArrayList<Map<String, Object>>> deletePaperworkById(String id);
}
