package todo.todoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todo.todoapp.repository.TodoRepository;
import todo.todoapp.todoentity.TodoEntity;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public TodoEntity createTodoList(TodoEntity todoEntity) {
        return todoRepository.save(todoEntity);
    }

    @Override
    public List<TodoEntity> fetchAllTodoList() {
        return (List<TodoEntity>) todoRepository.findAll();
    }

    @Override
    public TodoEntity updateTodoList(TodoEntity todoEntity) {

        TodoEntity objt = todoRepository.findById(todoEntity.getId()).get();
        if (objt != null) {
            objt.setDescription(todoEntity.getDescription());
            objt.setStatus(todoEntity.getStatus());
            objt.setTitle(todoEntity.getTitle());
        }

        return todoRepository.save(todoEntity);
    }

    @Override
    public String deleteTodoList(Long id) {
        TodoEntity objt = todoRepository.findById(id).get();
        String deleteMsg = null;
        if (objt != null) {
            todoRepository.deleteById(id);
            deleteMsg = "Todo item deleted successfully!" + id;
        }
        return deleteMsg;
    }

}
