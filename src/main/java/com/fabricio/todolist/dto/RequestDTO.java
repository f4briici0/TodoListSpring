package com.fabricio.todolist.dto;

public record RequestDTO (long codigo, String nome, String descricao, int prioridade, Boolean realizado){
}
