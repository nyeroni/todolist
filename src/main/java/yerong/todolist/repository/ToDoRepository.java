package yerong.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import yerong.todolist.domain.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    @Modifying
    @Query("UPDATE ToDo t SET t.status = 'FINISH' WHERE t.id = :todoId")
    void finishUpdate(Long todoId);
}
