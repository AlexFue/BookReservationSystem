package com.example.bookreservationsystem;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LogDao {

    // returns number of rows in logs table
    @Query("select count(*) from logs")
    int count();

    @Query("select * from logs")
    List<Log> getAllLogs();

    @Query("select * from logs where mLogId = :logId")
    Log findById(int logId);

    @Insert
    long addLog(Log log);

    @Insert
    long[] insertLogs(Log... logs);
}
