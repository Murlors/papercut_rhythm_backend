package com.example.papercut_rhythm_backend.bean;


import lombok.Data;

import java.util.Date;

@Data
public class Topic {

    private Integer id;
    private String title;
    private String content;
    private String contentIntroduction;

    private String status;
    private Integer CommentCount;
    private Integer creatorId;
    private Date createTime;
    private Integer thumbsUp;

    private User creatorInfo;

}
