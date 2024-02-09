package yerong.todolist.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
    UNFINISHED("미완료"),
    FINISH("완료");
    private final String title;
}
