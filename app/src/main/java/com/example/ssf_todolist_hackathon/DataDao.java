package com.example.ssf_todolist_hackathon;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Data Access Object
 */
@Dao
public interface DataDao {
    @Insert
    void setInsertData(Data data);
    @Update
    void setUpdateData(Data data);
    @Delete
    void setDeleteData(Data data);
    @Query("SELECT * FROM Data")
    List<Data> getDataAll();
}
