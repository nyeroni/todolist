package yerong.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yerong.todolist.domain.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
