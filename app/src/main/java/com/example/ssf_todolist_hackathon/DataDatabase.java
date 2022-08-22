package com.example.ssf_todolist_hackathon;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Data.class},version = 1)
public abstract class DataDatabase extends RoomDatabase {
    public abstract DataDao dataDao();
}


