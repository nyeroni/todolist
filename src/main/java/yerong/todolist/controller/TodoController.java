package yerong.todolist.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yerong.todolist.domain.dto.ToDoRequestDto;
import yerong.todolist.domain.dto.ToDoResponseDto;
import yerong.todolist.service.TodoService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class TodoController {

    private final TodoService todoService;
    @GetMapping("/")
    public String index(Model model){
        List<ToDoResponseDto> toDoList = todoService.getToDoList();
        model.addAttribute("todoList", toDoList);
        model.addAttribute("todo", new ToDoResponseDto());
        return "index";
    }
    @PostMapping("/todo/addTodo")
    public String insertTodo(ToDoRequestDto dto){
        todoService.insertToDoList(dto);
        return "redirect:/";
    }

    @PostMapping("/todo/{id}/update")
    public String updateStatus(@PathVariable("id") Long id){
        todoService.updateStatusToDoList(id);
        return "redirect:/";
    }

    @PostMapping("/todo/{id}/delete")
    public String deleteTodo(@PathVariable("id") Long id){
        todoService.deleteToDoList(id);
        return "redirect:/";
    }
}
