package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController {
    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    private TodoService todoService;
    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        List<Todo> todos = todoService.findByUsername("in28minutes");
        model.addAttribute("todos",todos);
        return "listTodos";
    }

    @RequestMapping(value = "add-todo",method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        String username = (String) model.get("username");
        Todo todo = new Todo(0,username,"Default Desc",LocalDate.now().plusYears(1),false);
        model.put("todo",todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors())
        {
            return "todo";
        }
        String username = (String) model.get("username");
        todoService.addTodo(username,todo.getDescription(), LocalDate.now().plusYears(1),false);
        return "redirect:list-todos";
    }
    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoService.deleteById(id);
       return "redirect:list-todos";
    }
    @RequestMapping(value = "update-todo",method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id,ModelMap model){
        Todo todo = todoService.findById(id);
        model.addAttribute("todo",todo);
       return "todo";
    }
    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors())
        {
            return "todo";
        }
        String username = (String) model.get("username");
        todo.setUsername(username);
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }
}
