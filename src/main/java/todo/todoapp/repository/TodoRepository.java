package todo.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.todoapp.todoentity.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

}
