package com.example.ssf_todolist_hackathon;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Data {
    @PrimaryKey(autoGenerate = true)
    private int id = 0;
    private boolean check;
    private int type;

    public Data(boolean check, int type, String text) {
        this.check = check;
        this.type = type;
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;
}
