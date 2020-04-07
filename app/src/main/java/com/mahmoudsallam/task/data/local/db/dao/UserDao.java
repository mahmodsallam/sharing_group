package com.mahmoudsallam.task.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.mahmoudsallam.task.data.model.db.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM users")
    List<User> getUsers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<User> users);

}
