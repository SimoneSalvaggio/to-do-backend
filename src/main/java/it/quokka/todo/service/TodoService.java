package it.quokka.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.quokka.todo.model.Todo;
import it.quokka.todo.repository.TodoRepository;
import it.quokka.todo.service.dto.TodoDTO;
import it.quokka.todo.service.mapper.TodoMapper;

@Service
public class TodoService {
	
	@Autowired
	TodoMapper todoMapper;
	
	@Autowired
	TodoRepository todoRepository;
	
	public List<TodoDTO> findAll() {
		List<Todo> list = todoRepository.findAll();
		List<TodoDTO> dtoList = todoMapper.toDto(list);
		return dtoList;
	}
	
	public TodoDTO findById(Integer id) {
		Todo opt = todoRepository.findById(id).orElse(null);
		TodoDTO ms = todoMapper.toDto(opt);
		return ms;
	}
	
	public TodoDTO save(TodoDTO todoDto) {
		Todo ms = todoMapper.toEntity(todoDto);
		ms = todoRepository.save(ms);
		todoDto = todoMapper.toDto(ms);
		return todoDto;
	}

	public TodoDTO getTodoByTagId(Integer tagId) {
		Todo opt = todoRepository.findByTagId(tagId).orElse(null);
		TodoDTO ms = todoMapper.toDto(opt);
		return ms;
	}

//	public TodoDTO getTodoByTagId(Integer tagId) {
//		Todo opt = todoRepository.findByTagId(tagId);
//		TodoDTO todo = todoMapper.toDto(opt);
//		return todo;
//	}

}
