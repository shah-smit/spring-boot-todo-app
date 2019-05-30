package com.yourname.Service.Interface;


import com.yourname.Entity.AppUser;

public interface IAppUserService {
    AppUser findById(String id);

    AppUser createUser(AppUser user);

    void deleteUser(String id);

    AppUser updateUser(AppUser user);
}
