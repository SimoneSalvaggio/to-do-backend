package it.quokka.todo.service.validator;

public class FieldError {
	private String entityError;
	private String field;
	private String error;
	
	public String getEntityError() {
		return entityError;
	}
	public void setEntityError(String entityError) {
		this.entityError = entityError;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	

}
