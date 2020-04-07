package com.mahmoudsallam.task.data;

import com.mahmoudsallam.task.data.local.db.DbHelper;
import com.mahmoudsallam.task.data.local.prefs.PreferencesHelper;
import com.mahmoudsallam.task.data.model.api.UsersResponse;
import com.mahmoudsallam.task.data.remote.ApiHelper;

import java.util.List;

import io.reactivex.Observable;

public interface DataManager extends ApiHelper, PreferencesHelper, DbHelper {
    Observable<List<UsersResponse>> getUsers();
}
