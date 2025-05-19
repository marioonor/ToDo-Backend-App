package todo.todoapp.service;

import java.util.List;

import todo.todoapp.todoentity.TodoEntity;

public interface TodoService {

    TodoEntity createTodoList(TodoEntity todoEntity);

    List<TodoEntity> fetchAllTodoList();

    TodoEntity updateTodoList(TodoEntity todoEntity);

    String deleteTodoList(Long id);

}
