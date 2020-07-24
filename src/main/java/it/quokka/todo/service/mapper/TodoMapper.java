package it.quokka.todo.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.quokka.todo.model.Todo;
import it.quokka.todo.service.dto.TodoDTO;

@Mapper(componentModel = "spring", uses = { TagMapper.class })
public abstract class TodoMapper implements EntityMapper<TodoDTO, Todo> {
	@Override
	@Mapping(source = "tagId.id", target = "tagId")
	public abstract TodoDTO toDto(Todo entity);

	@Mapping(source = "tagId", target = "tagId.id")
	@Override
	public abstract Todo toEntity(TodoDTO dto);
}
