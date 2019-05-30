package com.yourname.Service.Interface;


import com.yourname.Entity.TodoItem;
import com.yourname.Exception.TodoItemNotFoundException;

import java.util.List;

public interface ITodoItemService {

    List<TodoItem> getAllItems();

    List<TodoItem> addItem(TodoItem t);

    void removeItem(Integer id) throws TodoItemNotFoundException;

    TodoItem updateItem(TodoItem t) throws TodoItemNotFoundException;

}
