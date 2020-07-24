package it.quokka.todo.service.validator;

import java.util.ArrayList;
import java.util.List;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.springframework.stereotype.Component;

import it.quokka.todo.model.Tag;

@Component
public class TagValidator implements EntityValidator<Tag> {
	
	@Override
	public List<FieldError> validate(Tag tag){
		
		List<FieldError> errors = new ArrayList<FieldError>();
		
		Rules rules = new Rules();
		Facts facts = new Facts();
		DefaultRulesEngine rulesEngine = new DefaultRulesEngine();
		
		facts.put("messaggiSistema", tag);
		facts.put("errors", errors);
		rulesEngine.fire(rules, facts);
		
		return errors;
	}

}
