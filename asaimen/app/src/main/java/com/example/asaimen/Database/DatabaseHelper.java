package com.example.asaimen.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.asaimen.Dao.NguoiDungDao;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context,"asa.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("Create table NguoiDung(userName text primary key,passWord text,phone text,hoTen text)");
    }

    @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
 db.execSQL("drop table if exists"+NguoiDungDao.TABLE_NAME);
    }
}
