package com.yourname.Service;

import com.yourname.Entity.AppUser;
import com.yourname.Repository.AppUserRepository;
import com.yourname.Service.Interface.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements IAppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    public AppUser findById(String id)
    {
        if(this.appUserRepository.findById(id).isPresent()){
            AppUser user = this.appUserRepository.findById(id).get();
            return user;
        }
        else{
            return null;
        }
    }

    public AppUser createUser(AppUser user){
        this.appUserRepository.save(user);
        return user;
    }

    public void deleteUser(String id){
        if(this.appUserRepository.findById(id).isPresent()){
            AppUser user = this.appUserRepository.findById(id).get();
            this.appUserRepository.delete(user);
        }
    }

    public AppUser updateUser(AppUser user){
        if(this.appUserRepository.findById(user.getUsername()).isPresent()){
            AppUser returnedUser = this.appUserRepository.findById(user.getUsername()).get();
            returnedUser.setFirstName(user.getFirstName());
            returnedUser.setLastName(user.getLastName());
            returnedUser.setPassword(user.getPassword());
        }
        return user;
    }
}
