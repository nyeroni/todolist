package yerong.todolist.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yerong.todolist.domain.Status;
import yerong.todolist.domain.ToDo;
import yerong.todolist.domain.dto.ToDoRequestDto;
import yerong.todolist.domain.dto.ToDoResponseDto;
import yerong.todolist.domain.dto.ToDoStatusResponseDto;
import yerong.todolist.repository.ToDoRepository;
import yerong.todolist.service.TodoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TodoServiceImpl implements TodoService {

    private final ToDoRepository toDoRepository;

    @Override
    @Transactional
    public List<ToDoResponseDto> getToDoList() {
        List<ToDo> toDos = toDoRepository.findAll();
        return toDos.stream()
                .map(toDo -> ToDoResponseDto.builder()
                        .id(toDo.getId())
                        .message(toDo.getMessage())
                        .status(toDo.getStatus())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean insertToDoList(ToDoRequestDto toDoRequestDto) {
        String message = toDoRequestDto.getMessage();
        if(message!=null){
            ToDo todo = ToDo.builder()
                    .message(message)
                    .status(Status.UNFINISHED)
                    .build();
            toDoRepository.save(todo);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public ToDoStatusResponseDto updateStatusToDoList(Long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow();
        return ToDoStatusResponseDto
                .builder()
                .id(toDo.getId())
                .status(toDo.getStatus())
                .build();
    }

    @Override
    @Transactional
    public boolean deleteToDoList(Long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow();
        if(toDo!=null){
            toDoRepository.delete(toDo);
            return true;
        }
        return false;
    }
}
