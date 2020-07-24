package it.quokka.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.quokka.todo.controller.beans.UtentiLog;
import it.quokka.todo.model.Utenti;
import it.quokka.todo.repository.UtentiRepository;
import it.quokka.todo.security.JwtAuthenticationService;

@RestController
@RequestMapping("/user")
public class UtentiController {
	
	@Autowired
	private UtentiLog utentiLog;

	@Autowired
	private UtentiRepository utRepo;
	
	@Autowired
	private JwtAuthenticationService jwtUtil;

	@RequestMapping("/login")
	public ResponseEntity<String> login(@RequestParam("username") String username, @RequestParam("password") String password) {
		System.out.println("EFFETTUO LOGIN");
		ResponseEntity<String> resp = null;
		Utenti ut = utRepo.findByUsernameAndPassword(username, password);

		if (ut != null) {
			String token = jwtUtil.authenticate(username, password);
			utentiLog.getUtentiMap().put(token, ut);
			resp = new ResponseEntity<String>(token, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		}
		return resp;

	}

}
