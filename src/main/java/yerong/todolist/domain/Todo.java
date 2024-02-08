package yerong.todolist.domain;

import jakarta.persistence.*;
import lombok.*;

import static lombok.AccessLevel.PROTECTED;

@Entity(name = "ToDo")
@Table(name = "todo")
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
@Getter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long id;

    @Column(nullable = false)
    private String message;

    @Builder
    private Todo(String message){
        this.message = message;
    }


}
