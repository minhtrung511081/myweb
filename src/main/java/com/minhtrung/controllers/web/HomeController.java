package com.minhtrung.controllers.web;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minhtrung.constant.constantC;
import com.minhtrung.models.Account;
import com.minhtrung.models.Product;
import com.minhtrung.services.IAccountService;
import com.minhtrung.services.IProductService;
import com.minhtrung.utils.FormUtils;
import com.minhtrung.utils.SessionUtils;

@WebServlet(urlPatterns = {"/trang-chu", "/dang-nhap","/thoat"})
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	
	@Inject
	private IProductService productService;
	
	@Inject
	private IAccountService accountService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action!=null && action.equals("login")) {
			String alert = request.getParameter("alert");
			String message = request.getParameter("message");
			if(alert!=null && message!=null) {
				request.setAttribute("message", resourceBundle.getString(message));
				request.setAttribute("alert", alert);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
			rd.forward(request, response);
		}else if(action!=null && action.equals("logout")) {
			SessionUtils.getInstance().removeValue(request, constantC.KEY_SESSION);
			response.sendRedirect(request.getContextPath()+"/trang-chu");
		}else {
//			List<Product> list = productService.getAll();
//			request.setAttribute("list",list);
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account accountService = getAccountService(MapRequestToModelAccount(request));
		if (isUser(accountService)) {
			putSessionAccount(request, constantC.KEY_SESSION, accountService);
			if(accountService.getRole().getCode().equalsIgnoreCase(constantC.ADMIN)) {
				response.sendRedirect(request.getContextPath()+"/admin-home");
			}else if(accountService.getRole().getCode().equalsIgnoreCase(constantC.USER)){
				response.sendRedirect(request.getContextPath()+"/trang-chu");
			}
		} else {
			response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=username_password_invalid&alert=danger");
		}
	}
	

	private void putSessionAccount(HttpServletRequest request, String key, Account account) {
		SessionUtils.getInstance().putValue(request, key, account);
	}

	private Account getAccountService(Account accountRequest) {
		return accountService.findByUsernameAndPassword(accountRequest);
	}

	private Account MapRequestToModelAccount(HttpServletRequest request) throws IOException {
		return FormUtils.toModels(Account.class, request);
	}
	
	private boolean isUser(Account accountService) {
		if (accountService != null)
			return true;
		return false;
	}

}
