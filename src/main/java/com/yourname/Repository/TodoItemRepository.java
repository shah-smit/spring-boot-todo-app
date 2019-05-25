package com.yourname.Repository;

import com.yourname.Entity.Student;
import com.yourname.Entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem,Integer> {
    public TodoItem findByTodoItemId(int Id);
}
