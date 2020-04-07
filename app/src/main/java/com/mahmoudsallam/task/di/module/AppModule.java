package com.mahmoudsallam.task.di.module;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.mahmoudsallam.task.data.AppDataManager;
import com.mahmoudsallam.task.data.DataManager;
import com.mahmoudsallam.task.data.local.db.DbHelper;
import com.mahmoudsallam.task.data.local.db.UsersDatabase;
import com.mahmoudsallam.task.data.local.db.UsersDbHelper;
import com.mahmoudsallam.task.data.local.prefs.AppPreferenceHelper;
import com.mahmoudsallam.task.data.local.prefs.PreferencesHelper;
import com.mahmoudsallam.task.data.remote.ApiHelper;
import com.mahmoudsallam.task.data.remote.AppApiHelper;
import com.mahmoudsallam.task.utils.rx.AppSchedulerProvider;
import com.mahmoudsallam.task.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(UsersDbHelper usersDbHelper) {
        return usersDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferenceHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    UsersDatabase provideAppDatabase(Context context) {
        return Room.databaseBuilder(context, UsersDatabase.class, "users_db").fallbackToDestructiveMigration()
                .build();
    }


}
