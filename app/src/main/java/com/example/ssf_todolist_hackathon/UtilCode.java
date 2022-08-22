package com.example.ssf_todolist_hackathon;

public class UtilCode {
    private static UtilCode instance;


    public UtilCode() {
    }

    static {
        try {instance = new UtilCode();
        }
        catch (Exception e) {
            throw new RuntimeException();
        }
    }

}