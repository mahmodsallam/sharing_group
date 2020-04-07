package com.mahmoudsallam.task.data.model.api;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mahmoudsallam.task.data.model.db.User;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class UsersResponse implements Parcelable {
    public UsersResponse(Company company,
                         String website, String phone,
                         Address address, String email,
                         String username, String name, int id) {
        this.company = company;
        this.website = website;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.username = username;
        this.name = name;
        this.id = id;
    }

    @Expose
    @SerializedName("company")
    private Company company;
    @Expose
    @SerializedName("website")
    private String website;
    @Expose
    @SerializedName("phone")
    private String phone;
    @Expose
    @SerializedName("address")
    private Address address;
    @Expose
    @SerializedName("email")
    private String email;
    @Expose
    @SerializedName("username")
    private String username;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("id")
    private int id;

    protected UsersResponse(Parcel in) {
        website = in.readString();
        phone = in.readString();
        email = in.readString();
        username = in.readString();
        name = in.readString();
        id = in.readInt();
    }

    public static final Creator<UsersResponse> CREATOR = new Creator<UsersResponse>() {
        @Override
        public UsersResponse createFromParcel(Parcel in) {
            return new UsersResponse(in);
        }

        @Override
        public UsersResponse[] newArray(int size) {
            return new UsersResponse[size];
        }
    };

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(website);
        dest.writeString(phone);
        dest.writeString(email);
        dest.writeString(username);
        dest.writeString(name);
        dest.writeInt(id);
    }

    public static List<User> mapToUserList(List<UsersResponse> usersResponseList) {
        List<User> userList = new ArrayList<>();

        for (UsersResponse mUserResponse :
                usersResponseList) {
            User user = new User();
            user.name = mUserResponse.getName();
            user.id = mUserResponse.getId();
            user.email = mUserResponse.getEmail();
            user.address = mUserResponse.getAddress().toString();
            user.company = mUserResponse.getCompany().toString();
            user.userName = mUserResponse.getUsername();
            user.phone = mUserResponse.getPhone();
            user.website = mUserResponse.getWebsite();

            userList.add(user);
        }
        return userList;
    }
}
