package com.mahmoudsallam.task.data.local.db;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.mahmoudsallam.task.data.local.db.dao.UserDao;
import com.mahmoudsallam.task.data.model.db.User;

@Database(entities = {User.class}, version = 1)
public abstract class UsersDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
