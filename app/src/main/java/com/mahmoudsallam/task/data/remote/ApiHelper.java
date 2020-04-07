package com.mahmoudsallam.task.data.remote;

import com.mahmoudsallam.task.data.model.api.UsersResponse;

import java.util.List;

import io.reactivex.Observable;

public interface ApiHelper {
    Observable<List<UsersResponse>>getUsers();
}
