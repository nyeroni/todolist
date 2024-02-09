package yerong.todolist.domain.dto;

import lombok.*;
import yerong.todolist.domain.Status;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ToDoStatusResponseDto {
    private Long id;
    private Status status;
}
