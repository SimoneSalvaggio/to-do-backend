package it.quokka.todo.service.validator;

import java.util.ArrayList;
import java.util.List;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.springframework.stereotype.Component;

import it.quokka.todo.model.Todo;
import it.quokka.todo.service.validator.rules.todo.TitleRule;

@Component
public class TodoValidator implements EntityValidator<Todo> {
	
	@Override
	public List<FieldError> validate(Todo todo){
		
		List<FieldError> errors = new ArrayList<FieldError>();
		
		Rules rules = new Rules();
		Facts facts = new Facts();
		DefaultRulesEngine rulesEngine = new DefaultRulesEngine();
		
		rules.register(new TitleRule());
		
		facts.put("messaggiSistema", todo);
		facts.put("errors", errors);
		rulesEngine.fire(rules, facts);
		
		return errors;
	}
}