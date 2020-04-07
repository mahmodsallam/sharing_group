package com.mahmoudsallam.task.data.local.db;

import android.util.Log;

import com.mahmoudsallam.task.data.model.db.User;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class UsersDbHelper implements DbHelper {
    private final UsersDatabase mUsersDatabase;

    @Inject
    public UsersDbHelper(UsersDatabase mUsersDatabase) {
        this.mUsersDatabase = mUsersDatabase;
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return Observable.fromCallable(() -> mUsersDatabase.userDao().getUsers());
    }

    @Override
    public Observable<Boolean> insertAll(List<User> users) {
        return Observable.fromCallable(() -> {
            mUsersDatabase.userDao().insertAll(users);
            return true;
        });
    }

}
