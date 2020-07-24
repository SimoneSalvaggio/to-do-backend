package it.quokka.todo.service.validator.rules.todo;
import java.util.List;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import it.quokka.todo.model.Todo;
import it.quokka.todo.service.validator.FieldError;


@Rule(name = "titoloRule", description = "not null")
public class TitleRule {
	@Condition
	public boolean isTitleNull(@Fact("todo") Todo todo) {
		boolean isValid = false;
		if (todo.getTitle() != null) {
			isValid = true;
		}
		return !isValid;
	}
	@Action
	public void error(@Fact("error") List<FieldError> errors) {
		FieldError error = new FieldError();
		error.setEntityError("todo");
		error.setField("title");
		error.setError("Inserisci un titolo");
		errors.add(error);
	}
}