package com.minhtrung.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minhtrung.constant.constantC;
import com.minhtrung.models.Account;
import com.minhtrung.utils.SessionUtils;

public class Authozation implements Filter {

	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context= filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String url = request.getRequestURI();
		if (url.startsWith("/ecommerce-servlet-jsp-jdbc/admin")) {
			Account account = (Account) SessionUtils.getInstance().getValue(request, constantC.KEY_SESSION);
			if (account != null) {
				if (account.getRole().getCode().equalsIgnoreCase(constantC.ADMIN)) {
					filterChain.doFilter(servletRequest, servletResponse);
				} else if (account.getRole().getCode().equalsIgnoreCase(constantC.USER)) {
					response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=not_permission&alert=danger");
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=not_login&alert=danger");
			}
		}else {
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}

	@Override
	public void destroy() {

	}

}
