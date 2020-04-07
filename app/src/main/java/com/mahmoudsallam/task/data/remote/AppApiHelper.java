package com.mahmoudsallam.task.data.remote;

import com.mahmoudsallam.task.data.model.api.UsersResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class AppApiHelper implements ApiHelper {
    @Inject
    public AppApiHelper() {
    }

    @Override
    public Observable<List<UsersResponse>> getUsers() {
        return Rx2AndroidNetworking.get(ApiEndPoint.BASE_URL)
                .build()
                .getObjectListObservable(UsersResponse.class);
    }
}
