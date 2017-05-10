package com.example.android.listsample.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 10.05.2017.
 */

public abstract class CommentItem implements ICommentItem{
    String id;
    String name;
    String message;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    public static List <ICommentItem> getDemoItems(){
        List <ICommentItem> list = new ArrayList<>();

        ICommentItem item1 = new AuthorCommentItem();
        item1.setId("0");
        item1.setMessage("first auttor message");
        list.add(item1);

        item1 = new MyCommentItem();
        item1.setId("1");
        item1.setMessage("first my message");
        list.add(item1);

        item1 = new UserCommentItem();
        item1.setId("2");
        item1.setMessage("first user message");
        list.add(item1);

        return list;
    }
}
