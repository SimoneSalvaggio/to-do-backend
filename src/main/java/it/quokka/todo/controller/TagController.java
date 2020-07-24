package it.quokka.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.quokka.todo.service.TagService;
import it.quokka.todo.service.dto.TagDTO;

@RestController
@RequestMapping("/tag")
public class TagController {
	
	@Autowired
    private TagService tagService;
	
	@GetMapping("/all")
    public List<TagDTO> showAll() {
        List<TagDTO> tags = null;
        try {
        	tags = tagService.findAll();
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return tags;
    }
	
	@GetMapping("/{id}/find")
    public TagDTO showTodoById(@PathVariable Integer id) {
		TagDTO tag = null;
		try {
			tag = tagService.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return tag;
    }
	
	@PostMapping("/update")
    public void save(@RequestBody TagDTO tag) {
		try {
			tag = tagService.save(tag);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
}