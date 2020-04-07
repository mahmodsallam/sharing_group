package com.mahmoudsallam.task.ui.main;

import android.media.MediaRouter;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mahmoudsallam.task.data.DataManager;
import com.mahmoudsallam.task.data.model.api.UsersResponse;
import com.mahmoudsallam.task.data.model.db.User;
import com.mahmoudsallam.task.ui.base.BaseViewModel;
import com.mahmoudsallam.task.utils.rx.SchedulerProvider;

import java.util.List;
import java.util.PrimitiveIterator;

import io.reactivex.functions.Consumer;

public class MainViewModel extends BaseViewModel<MainNavigator> {
    private MutableLiveData<List<UsersResponse>> _usersList = new MutableLiveData<>();
    LiveData<List<UsersResponse>> usersList = _usersList;

    private MutableLiveData<Boolean> _showNoInternet = new MutableLiveData<>();
    LiveData<Boolean> showNoInternet = _showNoInternet;


    public MainViewModel(DataManager dataManager,
                         SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void getUsers() {
        getCompositeDisposable().add(getDataManager()
                .getUsers()
                .doOnNext(usersResponseList -> Log.d("SIZE", "size" + usersResponseList.size()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(usersResponseList -> {
                    Log.d("users", usersResponseList.toString());
                    _usersList.setValue(usersResponseList);
                    insertAllUsers(usersResponseList);

                }, throwable -> {
                    Log.d("users", throwable.getMessage());

                })

        );


    }

    private void insertAllUsers(List<UsersResponse> usersResponseList) {
        getDataManager().insertAll(UsersResponse.mapToUserList(usersResponseList))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .doOnNext(aBoolean -> Log.d("STATUS", aBoolean.toString()))
                .subscribe(aBoolean -> {
                    Log.d("users", aBoolean.toString());

                }, throwable -> {
                    Log.d("users", throwable.getMessage());

                });

    }

    public void getUsersFromLocal() {
        getCompositeDisposable().add(getDataManager()
                .getAllUsers()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(userList -> {
                    _usersList.setValue(User.mapToUserResponse(userList));
                    if (userList.isEmpty())
                        _showNoInternet.setValue(true);
                }, throwable -> {
                    Log.d("users", throwable.getMessage());
                }));
    }
}

