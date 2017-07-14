package com.alura.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alura.springmvc.model.Usuario;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import static javax.swing.text.html.CSS.getAttribute;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception {

		// se for a pagina de login ou resources, deixa passar
		String uri = request.getRequestURI();
		System.out.println(uri);
		if(uri.endsWith("loginForm") || uri.endsWith("efetuaLogin") || uri.contains("resources")){
			System.out.println("It is a form");
			return true;
		}
		HttpSession session = request.getSession();
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if(usuarioLogado != null) {
			System.out.println("Usuario logado" + usuarioLogado.getLogin());
			return true;
		} else {
			System.out.println("Usuario not logado");
			response.sendRedirect("loginForm");
			return false;
		}
	}
}
