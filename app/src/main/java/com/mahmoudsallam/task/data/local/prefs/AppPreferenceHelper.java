package com.mahmoudsallam.task.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

public class AppPreferenceHelper implements PreferencesHelper {

    private static final String FISRT_TIME_KEY = "FISRT_TIME_KEY";
    private static final String PREF_NAME = "USERS_PREF";
    private final SharedPreferences mPrefs;


    @Inject
    public AppPreferenceHelper(Context context) {
        mPrefs = context.getSharedPreferences(PREF_NAME, context.MODE_PRIVATE);
    }

    @Override
    public void setIsFirstTime(String firstTime) {
        mPrefs.edit().putString(FISRT_TIME_KEY, firstTime).apply();
    }

    @Override
    public String getIsFirstTime() {
        return mPrefs.getString(FISRT_TIME_KEY, null);
    }
}
