package com.mahmoudsallam.task.ui.main;

import com.mahmoudsallam.task.data.model.api.UsersResponse;

import java.util.List;

public interface MainNavigator {
    void setUserData(List<UsersResponse>userList) ;
    void showUserDetails(UsersResponse usersResponse) ;
}
