package com.yourname.Service.Interface;


import com.yourname.Entity.AppUser;
import com.yourname.Exception.AppUserNotCreatedException;
import com.yourname.Exception.AppUserNotFoundException;

public interface IAppUserService {
    AppUser findById(String id) throws AppUserNotFoundException;

    AppUser createUser(AppUser user) throws AppUserNotCreatedException;

    void deleteUser(String id) throws AppUserNotFoundException;

    AppUser updateUser(AppUser user) throws AppUserNotFoundException;
}
