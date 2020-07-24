package it.quokka.todo.security;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import it.quokka.todo.model.Utenti;
import it.quokka.todo.repository.UtentiRepository;

@Service
public class JwtAuthenticationService {
	
	@Value("${jwt.secret}")
	private String chiave;

	
	@Autowired
	private UtentiRepository utentiRepo;

	public String authenticate(String username, String password) {
		String token = null;
		Utenti utente = utentiRepo.findByUsernameAndPassword(username, password);
		if (utente != null) {
			token = generateToken(utente);
		}
		return token;
	}
	
	private String generateToken(Utenti utente) {

		Map<String, Object> claims = new HashMap<>();

		Integer id = utente.getId();
		String username = utente.getUsername();
		String password = utente.getPassword();

		claims.put("id", id);
		claims.put("username", username);
		claims.put("password", password);

		Header<?> header = Jwts.header();
		header.setType("JWT");
		LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());
		LocalDateTime expLdt = now.plusDays(7);

		Date iatDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
		Date expDate = Date.from(expLdt.atZone(ZoneId.systemDefault()).toInstant());

		String jwtToken = Jwts.builder().setHeader((Map<String, Object>) header).setClaims(claims)
				.setSubject("user_jwt_token").setIssuedAt(iatDate).setExpiration(expDate)
				.signWith(SignatureAlgorithm.HS256, chiave).compact();

		return jwtToken;
	}



}
