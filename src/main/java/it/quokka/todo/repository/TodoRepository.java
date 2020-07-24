package it.quokka.todo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.quokka.todo.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>  {

	Optional<Todo> findByTagId(Integer tagId);




}
