package com.ryy.giftlist.web.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/pages/*")// Todas las paginas dentro la carpeta "pages" estarAn protegidas por el Filtro
public class SessionFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession(false);

		// Verificar si la sesion existe y el usuario esta autenticado
		if (session == null || session.getAttribute("isLoggedIn") == null
				|| !(Boolean) session.getAttribute("isLoggedIn")) {
			// Si no esta autenticado, redirigir a la pagina de login
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.xhtml");
		} else {
			// Continuar con la cadena de filtros/solicitudes si esta autenticado
			chain.doFilter(request, response);
		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Inicializacion del filtro si es necesario
	}

	@Override
	public void destroy() {
		// Limpieza del filtro si es necesario
	}

}
