package it.quokka.todo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.quokka.todo.service.TodoService;
import it.quokka.todo.service.dto.TodoDTO;

@RestController
@RequestMapping("/todo")
public class TodoController {

	@Autowired
    private TodoService todoService;
	
	@GetMapping("/all")
    public List<TodoDTO> showAll() {
        List<TodoDTO> todos = null;
        try {
        	todos = todoService.findAll();
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return todos;
    }
	
	@GetMapping("/{id}/find")
    public TodoDTO showTodoById(@PathVariable Integer id) {
		TodoDTO todo = null;
		try {
			todo = todoService.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return todo;
    }
	
	@GetMapping("/{tagId}/findByTag")
    public TodoDTO showTodoByTagId(@PathVariable Integer tagId) {
		TodoDTO todo = null;
		try {
			todo = todoService.getTodoByTagId(tagId);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return todo;
    }
	
	@PostMapping("/update")
    public void save(@RequestBody TodoDTO todo) {
		LocalDateTime now = LocalDateTime.now();
		todo.setCreationDate(now);
		try {			
			todoService.save(todo);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
