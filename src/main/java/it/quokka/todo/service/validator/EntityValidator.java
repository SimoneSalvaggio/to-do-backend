package it.quokka.todo.service.validator;

import java.util.List;

public interface EntityValidator<E> {
	
	public List<FieldError> validate(E entity);

}
