package it.quokka.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.quokka.todo.model.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {

}
