package com.mahmoudsallam.task.data.model.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.mahmoudsallam.task.data.model.api.Address;
import com.mahmoudsallam.task.data.model.api.Company;
import com.mahmoudsallam.task.data.model.api.Geo;
import com.mahmoudsallam.task.data.model.api.UsersResponse;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "users")
public class User {
    @PrimaryKey
    public int id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "email")
    public String email;
    @ColumnInfo(name = "user_name")
    public String userName;
    @ColumnInfo(name = "address")
    public String address;
    @ColumnInfo(name = "phone")
    public String phone;
    @ColumnInfo(name = "website")
    public String website;
    @ColumnInfo(name = "company")
    public String company;


    public static List<UsersResponse> mapToUserResponse(List<User> userList) {
        List<UsersResponse> usersResponseList = new ArrayList<>();
        for (User user : userList) {
            Company company = new Company(user.company, user.company, user.company);
            Address address = new Address(new Geo(), user.address, null, null, null);
            UsersResponse usersResponse = new UsersResponse(company, user.website, user.phone, address,
                    user.email, user.userName, user.name, user.id
            );
            usersResponseList.add(usersResponse);
        }
        return usersResponseList;
    }
}
