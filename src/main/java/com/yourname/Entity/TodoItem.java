package com.yourname.Entity;

import javax.persistence.*;

@Entity(name = "TodoItem`")
@Table(name = "`TodoItem`")
public class TodoItem {

    @Id
    private Integer id;

    private String text;

    public TodoItem(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public TodoItem(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
