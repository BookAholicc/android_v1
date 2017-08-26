package com.bookaholic.userApp.Model;

import android.support.v7.widget.RecyclerView;

/**
 * Created by nandhu on 26/8/17.
 */

public class Wall{
    public int wallId;
    public  String userImageURL;
    public  int userId;
    public  String userName;
    public  int Walltext;
    public  int likeCount;
    public  int commentId;
    public int commentCount;
    public boolean isImagePresent;

    public Wall(int wallId, String userImageURL, int userId, String userName, int walltext, int likeCount, int commentId,int commentCount) {
        this.wallId = wallId;
        this.userImageURL = userImageURL;
        this.userId = userId;
        this.userName = userName;
        Walltext = walltext;
        this.likeCount = likeCount;
        this.commentId = commentId;
        this.commentCount = commentCount;
    }
}

