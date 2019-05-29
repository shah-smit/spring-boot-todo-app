package com.yourname.Controller;

import com.yourname.Entity.AppUser;
import com.yourname.Entity.TodoItem;
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
    public AppUser updateItem(@RequestBody AppUser u) {
        return this.appUserService.updateUser(u);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable("id") String id) {
        this.appUserService.deleteUser(id);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public AppUser getItem(@PathVariable("id") String id) {
        return this.appUserService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addItem(@RequestBody AppUser u){
         this.appUserService.createUser(u);
    }
}
