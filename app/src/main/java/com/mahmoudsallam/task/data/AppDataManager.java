package com.mahmoudsallam.task.data;

import android.content.Context;

import com.mahmoudsallam.task.data.local.db.DbHelper;
import com.mahmoudsallam.task.data.local.prefs.PreferencesHelper;
import com.mahmoudsallam.task.data.model.api.UsersResponse;
import com.mahmoudsallam.task.data.model.db.User;
import com.mahmoudsallam.task.data.remote.ApiHelper;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final ApiHelper mApiHelper;
    private final DbHelper mDbHelper ;
    private final PreferencesHelper mPreferencesHelper ;

    private final Context mContext;

    @Inject
    public AppDataManager(ApiHelper mApiHelper, Context mContext , DbHelper mDbHelper ,
                          PreferencesHelper mPreferencesHelper ) {
        this.mApiHelper = mApiHelper;
        this.mContext = mContext;
        this.mDbHelper=mDbHelper ;
        this.mPreferencesHelper=mPreferencesHelper ;
    }

    @Override
    public Observable<List<UsersResponse>> getUsers() {
        return mApiHelper.getUsers();
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return mDbHelper.getAllUsers();
    }

    @Override
    public Observable<Boolean> insertAll(List<User> users) {
        return mDbHelper.insertAll(users);
    }

    @Override
    public void setIsFirstTime(String firstTime) {
        mPreferencesHelper.setIsFirstTime(firstTime);
    }

    @Override
    public String getIsFirstTime() {
        return mPreferencesHelper.getIsFirstTime();
    }
}
