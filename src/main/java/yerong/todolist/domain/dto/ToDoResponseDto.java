package yerong.todolist.domain.dto;

import lombok.*;
import yerong.todolist.domain.Status;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ToDoResponseDto {

    private Long id;
    private String message;
    private Status status;
}
