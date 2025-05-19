package todo.todoapp.controller;

import org.springframework.web.bind.annotation.RestController;

import todo.todoapp.service.TodoService;
import todo.todoapp.todoentity.TodoEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class TodoController {
    
    @Autowired
    private TodoService todoService;

    @PostMapping("add")
    public ResponseEntity<TodoEntity> createTodoList(@RequestBody TodoEntity todoEntity) {
        return ResponseEntity.ok(todoService.createTodoList(todoEntity));
    }

    @GetMapping("show")
    public ResponseEntity<List<TodoEntity>> fetchAllTodoList() {
        return ResponseEntity.ok(todoService.fetchAllTodoList());
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<TodoEntity> updateTodoList(@PathVariable("id") Long id, @RequestBody TodoEntity todoEntity) {
        return ResponseEntity.ok(todoService.updateTodoList(todoEntity));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteTodoList(@PathVariable("id") Long id) {
        return ResponseEntity.ok(todoService.deleteTodoList(id));
    }
    
}
