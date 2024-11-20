package com.fabricio.todolist.entity;

import com.fabricio.todolist.dto.RequestDTO;
import jakarta.persistence.*;
import org.apache.coyote.Request;

@Entity
@Table ( name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private long id;
    @Column (name = "name")
    private String name;
    @Column (name = "description")
    private String description;
    @Column (name = "priority")
    private int priority;
    @Column (name = "realized")
    private boolean realized;

    public Todo() {
    }

    public Todo(String name, String description, int priority, boolean realized) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.realized = realized;
    }

    public Todo(Todo data){
        this.id = data.getId();
        this.name = data.getName();
        this.description = data.getDescription();
        this.priority = data.getPriority();
        this.realized = data.isRealized();
    }

    public Todo(long id, String name, String description, int priority, boolean realized) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.realized = realized;
    }

    public Todo(RequestDTO data){
        this.id = data.codigo();
        this.name = data.nome();
        this.description = data.descricao();
        this.priority = data.prioridade();
        this.realized = data.realizado();
    }

    public Long getId(){
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isRealized() {
        return this.realized;
    }

    public void setRealized(boolean realized) {
        this.realized = realized;
    }
}
