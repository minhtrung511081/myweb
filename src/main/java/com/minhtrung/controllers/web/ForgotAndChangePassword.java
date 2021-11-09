package com.minhtrung.controllers.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minhtrung.config.AES;
import com.minhtrung.constant.constantC;
import com.minhtrung.models.Account;
import com.minhtrung.models.Email;
import com.minhtrung.services.IAccountService;
import com.minhtrung.utils.EmailUtils;
import com.minhtrung.utils.HttpUtils;

@WebServlet(urlPatterns = {"/forgot-password", "/register"})
public class ForgotAndChangePassword extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IAccountService accountService;
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account account= HttpUtils.of(request.getReader()).toModel(Account.class);
		Account accountDb= accountService.findByUsernameAndEmail(account);
		ObjectMapper mapper = new ObjectMapper();
		if(accountDb!=null) {
			Email email = new Email();
			email.setFrom(AES.decrypt("BmOkPTwRbLvoDuSC3chjPkrZNkf0TsgMwjV/Wfv9wQ6Z9KnTAgKQpAuiL3LqbZYm", constantC.SECRECT_KEY));
			email.setFromPassWord(AES.decrypt("/kNyKhWRysYVt+c7tDpv0Q==", constantC.SECRECT_KEY));
			email.setTo(accountDb.getEmail());
			StringBuilder builder = new StringBuilder();
			builder.append("Dear ").append(accountDb.getUsername()).append("<br>");
			builder.append("your are used the forgot password function . <br> ");
			builder.append("Your password is <b> ").append(accountDb.getPassword()).append("<br>");
			builder.append("Regards <br>");
			builder.append("Administration");
			email.setContent(builder.toString());
			try {
				EmailUtils.send(email);
			} catch (Exception e) {
				e.printStackTrace();
			}
			StringBuilder builder2 = new StringBuilder("đã gửi mật khẩu qua email ");
			builder2.append(accountDb.getEmail());
			mapper.writeValue(response.getOutputStream(), builder2.toString());
		}
	}
}
