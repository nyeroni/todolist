package yerong.todolist.domain.dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ToDoDeleteRequest {
    private Long id;
}
