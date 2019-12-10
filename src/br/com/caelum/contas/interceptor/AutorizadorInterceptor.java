package br.com.caelum.contas.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception {
		
		String uri = request.getRequestURI();
		if (uri.endsWith("/usuario/form") || uri.endsWith("/usuario/efetuaLogin") || uri.contains("resources")) {
			return true;
		}
		
		if (request.getSession().getAttribute("usuarioLogado") != null) {
			return true;
		} 
		
		response.sendRedirect("/contas/usuario/form");
		return false;
		
	}
	
}
