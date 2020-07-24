package it.quokka.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.quokka.todo.model.Utenti;

@Repository
public interface UtentiRepository extends JpaRepository<Utenti, Integer> {

	Utenti findByUsernameAndPassword(String email, String password);

}
