package com.yourname.Service;

import com.yourname.Entity.AppUser;
import com.yourname.Exception.AppUserNotCreatedException;
import com.yourname.Exception.AppUserNotFoundException;
import com.yourname.Repository.AppUserRepository;
import com.yourname.Service.Interface.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements IAppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    PasswordEncoder pe =  new BCryptPasswordEncoder();

    public AppUser findById(String id) throws AppUserNotFoundException {
        if (this.appUserRepository.findById(id).isPresent()) {
            AppUser user = this.appUserRepository.findById(id).get();
            return user;
        } else {
            throw new AppUserNotFoundException();
        }
    }

    public AppUser createUser(AppUser user) throws AppUserNotCreatedException {

        user.setPassword(pe.encode(user.getPassword()));
        this.appUserRepository.save(user);
        try {
            return findById(user.getUsername());
        } catch (AppUserNotFoundException e) {
            throw new AppUserNotCreatedException();
        }
    }

    public void deleteUser(String id) throws AppUserNotFoundException {
        if (this.appUserRepository.findById(id).isPresent()) {
            AppUser user = this.appUserRepository.findById(id).get();
            this.appUserRepository.delete(user);
        } else {
            throw new AppUserNotFoundException();
        }
    }

    public AppUser updateUser(AppUser user) throws AppUserNotFoundException {
        if (this.appUserRepository.findById(user.getUsername()).isPresent()) {
            AppUser returnedUser = this.appUserRepository.findById(user.getUsername()).get();
            if(user.getFirstName() != null) returnedUser.setFirstName(user.getFirstName());
            if(user.getLastName() != null)returnedUser.setLastName(user.getLastName());
            if(user.getPassword() != null) returnedUser.setPassword(pe.encode(user.getPassword()));
            if(user.getRole() != null) returnedUser.setRole(user.getRole());
            this.appUserRepository.save(returnedUser);
            return returnedUser;
        } else {
            throw new AppUserNotFoundException();
        }
    }
}
