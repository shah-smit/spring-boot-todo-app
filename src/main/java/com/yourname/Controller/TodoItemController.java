package com.yourname.Controller;

import com.yourname.Entity.TodoItem;
import com.yourname.Exception.TodoItemNotFoundException;
import com.yourname.Service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todoitems")
public class TodoItemController {

    @Autowired
    public TodoItemService todoItemService;

    @GetMapping(value = "")
    public List<TodoItem> getAllItems(){
        return this.todoItemService.getAllItems();
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<TodoItem> addItem(@RequestBody TodoItem t){
        return this.todoItemService.addItem(t);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable("id") Integer id) throws TodoItemNotFoundException {
        this.todoItemService.removeItem(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public TodoItem updateItem(@RequestBody TodoItem t) throws TodoItemNotFoundException {
        return this.todoItemService.updateItem(t);
    }

}
