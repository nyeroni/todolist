package yerong.todolist.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import yerong.todolist.domain.dto.ToDoRequestDto;
import yerong.todolist.domain.dto.ToDoResponseDto;
import yerong.todolist.service.TodoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class TodoController {

    private final TodoService todoService;
    private final MessageSource messageSource;

    @GetMapping("/")
    public String home(Model model){
        return "redirect:/todo";
    }
    @GetMapping("/todo")
    public String index(Model model){
        List<ToDoResponseDto> toDoList = todoService.getToDoList();
        model.addAttribute("todoList", toDoList);
        model.addAttribute("todo", new ToDoRequestDto());
        return "index";
    }
    @PostMapping("/todo/addTodo")
    public String insertTodo(@Valid @ModelAttribute ToDoRequestDto dto, BindingResult bindingResult){
        if (StringUtils.isEmpty(dto.getMessage())) {
            String errorMessage = messageSource.getMessage("error.message.required", null, LocaleContextHolder.getLocale());
            bindingResult.addError(new FieldError("dto", "message", errorMessage));
        }
        if (bindingResult.hasErrors()) {

            return "index";
        }

        todoService.insertToDoList(dto);
        return "redirect:/todo";
    }

    @PostMapping("/todo/{id}/update")
    public String updateStatus(@PathVariable("id") Long id){
        log.info("success update");
        todoService.updateStatusToDoList(id);
        return "redirect:/todo";
    }
    @PostMapping("/todo/{id}/delete")
    public String deleteTodo(@PathVariable("id") Long id){
        log.info("success delete");
        todoService.deleteToDoList(id);
        return "redirect:/todo";
    }
    @PostMapping("/todo/{id}/deletev2")
    public String updateStatus2(@PathVariable("id") Long id){
        log.info("success update2");
        todoService.deleteToDoList(id);
        return "redirect:/todo";
    }

}
