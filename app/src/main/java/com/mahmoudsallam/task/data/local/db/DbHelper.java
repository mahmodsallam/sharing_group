package com.mahmoudsallam.task.data.local.db;

import android.icu.lang.UScript;

import com.mahmoudsallam.task.data.model.db.User;

import java.util.List;

import io.reactivex.Observable;

public interface DbHelper {
    Observable<List<User>> getAllUsers();

    Observable<Boolean> insertAll(List<User> users);
}
