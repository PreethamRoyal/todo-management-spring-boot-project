package net.javaguides.todo.controller;


import lombok.AllArgsConstructor;
import net.javaguides.todo.dto.TodoDto;

import net.javaguides.todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;


    //Build Add Todo REST API

    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){
        TodoDto savedTodo= todoService.addTodo(todoDto);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    // bUILD GET Todo REST API

    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable ("id") Long todoId){
        TodoDto todoDto=todoService.getTodo(todoId);
        return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }

    //Build GET All Todo REST API
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos(){
        List<TodoDto> todos=todoService.getAllTodos();
        //return new ResponseEntity<>(todos,HttpStatus.OK);
        return  ResponseEntity.ok(todos);
    }

    //Build Update Todo REST API
    @PutMapping("{id}")

    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto,@PathVariable("id") Long todoId){
        TodoDto updatedTodo=todoService.updateTodo(todoDto,todoId);
        return ResponseEntity.ok(updatedTodo);
    }

    //Build Delete Todo REST API

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId){
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok("Todo deleted Successfully.");
    }

    // Build Complete Todo REST API
    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDto> completeTodo(@PathVariable("id") Long todoId){
        TodoDto updatedTodo=todoService.completeTodo(todoId);
        return ResponseEntity.ok(updatedTodo);
    }



    //Build incomplete Todo REST API

    @PatchMapping("{id}/in-complete")
    public ResponseEntity<TodoDto> inComplete(@PathVariable("id") Long todoId){
        TodoDto updatedTodo=todoService.inCompleteTodo(todoId);
        return ResponseEntity.ok(updatedTodo);
    }
}
