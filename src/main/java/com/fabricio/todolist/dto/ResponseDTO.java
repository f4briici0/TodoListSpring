package com.fabricio.todolist.dto;

import com.fabricio.todolist.entity.Todo;

public record ResponseDTO (long codigo, String nome, String descricao, int prioridade, Boolean realizado){
    public ResponseDTO(Todo todo){
        this(todo.getId(), todo.getName(), todo.getDescription(), todo.getPriority(), todo.isRealized());
    }
}
