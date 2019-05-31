package com.yourname.Controller;

import com.yourname.Entity.AppUser;
import com.yourname.Entity.TodoItem;
import com.yourname.Exception.AppUserNotCreatedException;
import com.yourname.Exception.AppUserNotFoundException;
import com.yourname.Exception.TodoItemNotFoundException;
import com.yourname.Service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appuser")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @RequestMapping(method = RequestMethod.PUT)
    public AppUser updateAppUser(@RequestBody AppUser u) throws AppUserNotFoundException {
        return this.appUserService.updateUser(u);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteAppUser(@PathVariable("id") String id) throws AppUserNotFoundException {
        this.appUserService.deleteUser(id);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public AppUser getAppUser(@PathVariable("id") String id) throws AppUserNotFoundException {
        return this.appUserService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addAppUser(@RequestBody AppUser u) throws AppUserNotCreatedException {
         this.appUserService.createUser(u);
    }
}
