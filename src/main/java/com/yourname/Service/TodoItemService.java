package com.yourname.Service;

import com.yourname.Entity.TodoItem;
import com.yourname.Exception.TodoItemNotFoundException;
import com.yourname.Repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class TodoItemService {

    @Autowired
    public TodoItemRepository todoItemRepository;

    public List<TodoItem> getAllItems(){
        List<TodoItem> items = todoItemRepository.findAll();
        Collections.sort(items, new Comparator<TodoItem>() {
            @Override
            public int compare(TodoItem lhs, TodoItem rhs) {
                return lhs.getCreateDateTime().compareTo(rhs.getCreateDateTime());
            }
        });
        return todoItemRepository.findAll();
    }

    public List<TodoItem> addItem(TodoItem t){
        this.todoItemRepository.save(t);
        return todoItemRepository.findAll();
    }

    public void removeItem(Integer id) throws TodoItemNotFoundException {
        if(this.todoItemRepository.findById(id).isPresent()){
            TodoItem temp = this.todoItemRepository.findById(id).get();
            this.todoItemRepository.delete(temp);
        }
        else{
            throw new TodoItemNotFoundException();
        }
    }

    public TodoItem updateItem(TodoItem t) throws TodoItemNotFoundException {
        if(this.todoItemRepository.findById(t.getId()).isPresent()){
            TodoItem temp = this.todoItemRepository.findById(t.getId()).get();
            temp.setText(t.getText());
            this.todoItemRepository.save(temp);
            return temp;
        }
        else{
            throw new TodoItemNotFoundException();
        }
    }

    public boolean isItemNameValid(String name){
        return !name.isEmpty();
    }

    public TodoItem getTodoItemById(int id){
        if(todoItemRepository.findById(id).isPresent())
            return todoItemRepository.findById(id).get();
        else
            return null;
    }
}
