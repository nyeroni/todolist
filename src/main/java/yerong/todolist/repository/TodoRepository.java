package yerong.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yerong.todolist.domain.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
