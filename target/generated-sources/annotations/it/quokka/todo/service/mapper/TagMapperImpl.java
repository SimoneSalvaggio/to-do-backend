package it.quokka.todo.service.mapper;

import it.quokka.todo.model.Tag;
import it.quokka.todo.service.dto.TagDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-24T17:58:02+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"
)
@Component
public class TagMapperImpl extends TagMapper {

    @Override
    public Tag toEntity(TagDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Tag tag = new Tag();

        tag.setId( dto.getId() );
        tag.setDescription( dto.getDescription() );
        tag.setColor( dto.getColor() );

        return tag;
    }

    @Override
    public TagDTO toDto(Tag entity) {
        if ( entity == null ) {
            return null;
        }

        TagDTO tagDTO = new TagDTO();

        tagDTO.setId( entity.getId() );
        tagDTO.setDescription( entity.getDescription() );
        tagDTO.setColor( entity.getColor() );

        return tagDTO;
    }

    @Override
    public List<Tag> toEntity(List<TagDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Tag> list = new ArrayList<Tag>( dto.size() );
        for ( TagDTO tagDTO : dto ) {
            list.add( toEntity( tagDTO ) );
        }

        return list;
    }

    @Override
    public List<TagDTO> toDto(List<Tag> entity) {
        if ( entity == null ) {
            return null;
        }

        List<TagDTO> list = new ArrayList<TagDTO>( entity.size() );
        for ( Tag tag : entity ) {
            list.add( toDto( tag ) );
        }

        return list;
    }
}
