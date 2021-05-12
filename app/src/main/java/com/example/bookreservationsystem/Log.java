package com.example.bookreservationsystem;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "logs")
public class Log {

    @PrimaryKey(autoGenerate = true)
    private int mLogId;

    @ColumnInfo(name="message")
    private String mMessage;

    public Log(String message){
        mMessage = message;
    }

    public int getLogId() {
        return mLogId;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setLogId(int mLogId) {
        this.mLogId = mLogId;
    }

    public void setMessage(String mMessage) {
        this.mMessage = mMessage;
    }
}
