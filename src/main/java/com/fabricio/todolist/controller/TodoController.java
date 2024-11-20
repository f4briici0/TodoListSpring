package com.fabricio.todolist.controller;

import com.fabricio.todolist.dto.RequestDTO;
import com.fabricio.todolist.dto.ResponseDTO;
import com.fabricio.todolist.service.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Tests

@RestController
@RequestMapping("/")
public class TodoController {
    private Service service;

    public TodoController(Service service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ResponseDTO>> getAll(){
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> save(@RequestBody RequestDTO data){
        return service.save(data);
    }

    @PatchMapping
    public ResponseEntity<ResponseDTO> edit(@RequestBody RequestDTO data){
        return service.edit(data);
    }

    @DeleteMapping
    public ResponseEntity<ResponseDTO> deleteById(@RequestBody RequestDTO data){
        return service.deleteById(data);
    }
}
