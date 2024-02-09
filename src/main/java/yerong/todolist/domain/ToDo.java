package yerong.todolist.domain;

import jakarta.persistence.*;
import lombok.*;

import static lombok.AccessLevel.PROTECTED;

@Entity(name = "ToDo")
@Table(name = "todo")
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
@Getter
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long id;

    @Column(nullable = false)
    private String message;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Builder
    private ToDo(String message, Status status){
        this.message = message;
        this.status = status;
    }

    public void setStatus(Status status){
        this.status = status;
    }


}
