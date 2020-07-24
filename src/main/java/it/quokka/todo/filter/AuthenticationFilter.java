package it.quokka.todo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import it.quokka.todo.controller.beans.UtentiLog;
import it.quokka.todo.model.Utenti;

@Component
public class AuthenticationFilter implements Filter {

	@Autowired
	private UtentiLog utentiLog;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("CIAO SONO IL FILTRO!");
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		String url = httpReq.getRequestURI();
		String method = httpReq.getMethod();
		System.out.println(url);

		if (HttpMethod.OPTIONS.matches(method)) {
			chain.doFilter(request, response);
		} else {

			if (url.contains("login")) {
				System.out.println("RICHIESTA APPROVATA!");
				chain.doFilter(request, response);
			} else {
				String token = httpReq.getHeader("auth-token");
				if (token != null) {
					Utenti ut = utentiLog.getUtentiMap().get(token);
					if (ut != null) {
						System.out.println("TOKEN VALIDO RICHIESTA APPROVATA!");
						chain.doFilter(request, response);
					} else {
						System.out.println("TOKEN NON VALIDO RICHIESTA BLOCCATA!");
						httpResp.setStatus(HttpServletResponse.SC_FORBIDDEN);
					}
				} else {
					System.out.println("TOKEN NON PRESENTE RICHIESTA BLOCCATA!");
					httpResp.setStatus(HttpServletResponse.SC_FORBIDDEN);
				}
			}
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}
