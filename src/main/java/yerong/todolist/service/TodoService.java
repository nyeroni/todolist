package yerong.todolist.service;

import yerong.todolist.domain.dto.ToDoRequestDto;
import yerong.todolist.domain.dto.ToDoResponseDto;
import yerong.todolist.domain.dto.ToDoStatusResponseDto;

import java.util.List;

public interface TodoService {

    List<ToDoResponseDto> getToDoList();
    boolean insertToDoList(ToDoRequestDto toDoRequestDto);
    ToDoStatusResponseDto updateStatusToDoList(Long id);
    boolean deleteToDoList(Long id);
}
