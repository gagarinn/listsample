package com.example.android.listsample.model;

/**
 * Created by Android on 10.05.2017.
 */

public interface ICommentItem {
    void setId(String id);
    void setName(String name);
    void setMessage(String message);

    String getId();
    String getName();
    String getMessage();

}
