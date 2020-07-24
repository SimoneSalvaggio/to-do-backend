package it.quokka.todo.service.mapper;

import org.mapstruct.Mapper;

import it.quokka.todo.model.Tag;
import it.quokka.todo.service.dto.TagDTO;

@Mapper(componentModel = "spring", uses= {TodoMapper.class})
public abstract class TagMapper implements EntityMapper<TagDTO, Tag> {

}
