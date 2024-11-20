package com.fabricio.todolist.service;

import com.fabricio.todolist.dto.RequestDTO;
import com.fabricio.todolist.dto.ResponseDTO;
import com.fabricio.todolist.entity.Todo;
import com.fabricio.todolist.repositories.Repository;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.NoSuchElementException;

@org.springframework.stereotype.Service
public class Service {
    Repository repository;

    public Service(Repository repository){
        this.repository = repository;
    }

    public ResponseEntity<List<ResponseDTO>> getAll(){
        Sort sort = Sort.by("priority").descending().and(Sort.by("name").ascending());

        return new ResponseEntity<>(repository.findAll(sort).stream().map(ResponseDTO::new).toList(), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> save(RequestDTO data){
        Todo entity = new Todo(data);
        repository.save(entity);
        return new ResponseEntity<>(new ResponseDTO(entity), HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseDTO> edit(RequestDTO data){
        Todo entity_base;
        try{
            entity_base = repository.findById((int) data.codigo()).orElseThrow();
        } catch (Exception e){
            System.out.println(e);
            return ResponseEntity.notFound().build();
        }

        Todo entity = new Todo(entity_base);

        if(data.nome() != null){
            entity.setName(data.nome());
        }
        if (data.descricao() != null){
            entity.setDescription(data.descricao());
        }
        if (data.prioridade() != 0){
            entity.setPriority(data.prioridade());
        }
        if (data.realizado() != null){
            entity.setRealized(data.realizado());
        }

        repository.save(entity);
        return new ResponseEntity<>(new ResponseDTO(entity), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> deleteById(RequestDTO data){
        Todo entity;
        try{
            entity = repository.findById((int) data.codigo()).orElseThrow();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }

        repository.delete(entity);
        return new ResponseEntity<>(new ResponseDTO(entity), HttpStatus.NO_CONTENT);
    }
}
