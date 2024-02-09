package yerong.todolist.domain.dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ToDoRequestDto {
    private String message;
}
