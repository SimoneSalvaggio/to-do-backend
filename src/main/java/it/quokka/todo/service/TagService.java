package it.quokka.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.quokka.todo.model.Tag;
import it.quokka.todo.repository.TagRepository;
import it.quokka.todo.service.dto.TagDTO;
import it.quokka.todo.service.mapper.TagMapper;

@Service
public class TagService {
	
	@Autowired
	TagMapper tagMapper;
	
	@Autowired
	TagRepository tagRepository;
	
	public List<TagDTO> findAll() {
		List<Tag> list = tagRepository.findAll();
		List<TagDTO> dtoList = tagMapper.toDto(list);
		return dtoList;
	}
	
	public TagDTO findById(Integer id) {
		Tag opt = tagRepository.findById(id).orElse(null);
		TagDTO ms = tagMapper.toDto(opt);
		return ms;
	}

	public TagDTO save(TagDTO tagDto) {
		
		Tag tag = tagMapper.toEntity(tagDto);
		tag = tagRepository.save(tag);
		tagDto = tagMapper.toDto(tag);
		return tagDto;
	}

}
