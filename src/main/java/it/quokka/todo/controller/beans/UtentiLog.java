package it.quokka.todo.controller.beans;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import it.quokka.todo.model.Utenti;

@Component
public class UtentiLog {

	private Map<String,Utenti> utentiLogMap;

	public Map<String, Utenti> getUtentiMap() {
		if (this.utentiLogMap == null) {
			this.utentiLogMap = new HashMap<String, Utenti>();
		}
		return utentiLogMap;
	}
}
