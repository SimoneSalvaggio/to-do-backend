package it.quokka.todo.service.mapper;

import it.quokka.todo.model.Tag;
import it.quokka.todo.model.Todo;
import it.quokka.todo.service.dto.TodoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-23T18:11:02+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"
)
@Component
public class TodoMapperImpl extends TodoMapper {

    @Override
    public List<Todo> toEntity(List<TodoDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Todo> list = new ArrayList<Todo>( dto.size() );
        for ( TodoDTO todoDTO : dto ) {
            list.add( toEntity( todoDTO ) );
        }

        return list;
    }

    @Override
    public List<TodoDTO> toDto(List<Todo> entity) {
        if ( entity == null ) {
            return null;
        }

        List<TodoDTO> list = new ArrayList<TodoDTO>( entity.size() );
        for ( Todo todo : entity ) {
            list.add( toDto( todo ) );
        }

        return list;
    }

    @Override
    public TodoDTO toDto(Todo entity) {
        if ( entity == null ) {
            return null;
        }

        TodoDTO todoDTO = new TodoDTO();

        todoDTO.setTagId( entityTagIdId( entity ) );
        todoDTO.setId( entity.getId() );
        todoDTO.setTitle( entity.getTitle() );
        todoDTO.setDescription( entity.getDescription() );
        todoDTO.setCreationDate( entity.getCreationDate() );

        return todoDTO;
    }

    @Override
    public Todo toEntity(TodoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Todo todo = new Todo();

        todo.setTagId( todoDTOToTag( dto ) );
        todo.setId( dto.getId() );
        todo.setTitle( dto.getTitle() );
        todo.setDescription( dto.getDescription() );
        todo.setCreationDate( dto.getCreationDate() );

        return todo;
    }

    private Integer entityTagIdId(Todo todo) {
        if ( todo == null ) {
            return null;
        }
        Tag tagId = todo.getTagId();
        if ( tagId == null ) {
            return null;
        }
        Integer id = tagId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Tag todoDTOToTag(TodoDTO todoDTO) {
        if ( todoDTO == null ) {
            return null;
        }

        Tag tag = new Tag();

        tag.setId( todoDTO.getTagId() );

        return tag;
    }
}
