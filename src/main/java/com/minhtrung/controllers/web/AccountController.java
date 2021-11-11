package com.minhtrung.controllers.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minhtrung.constant.constantC;
import com.minhtrung.models.Account;
import com.minhtrung.services.IAccountService;
import com.minhtrung.utils.HttpUtils;
import com.minhtrung.utils.SessionUtils;

@WebServlet(urlPatterns = {"/api/login","/api/register"})
public class AccountController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static ObjectMapper mapper;

	@Inject
	private IAccountService accountService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		if (mapper == null) {
			mapper = new ObjectMapper();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PushDataClient(response, accountService.getAll());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		request.setCharacterEncoding("UTF-8");
		if(action.equalsIgnoreCase("/api/register")) {
			Account account = MapRequestToModelAccount(request);
			PushDataClient(response, accountService.insert(account));
		}else {
			Account service = getAccountService(MapRequestToModelAccount(request));
			if (isUser(service)) {
				putSessionAccount(request, constantC.KEY_SESSION, service);
				if(service.getRolecode().equalsIgnoreCase(constantC.ADMIN)) {
					PushDataClient(response, constantC.ADMIN);
				}else if(service.getRolecode().equalsIgnoreCase(constantC.USER)){
					PushDataClient(response, constantC.USER);
				}
			} else {
				PushDataClient(response, constantC.ERROR_USER);
			}
		}
		
		
	}
	
	private void PushDataClient(HttpServletResponse response, Object account)
			throws IOException, JsonGenerationException, JsonMappingException {
		response.setContentType("application/json");
		mapper.writeValue(response.getOutputStream(), account);
	}

	private void putSessionAccount(HttpServletRequest request, String key, Account account) {
		SessionUtils.getInstance().putValue(request, key, account);
	}

	private Account getAccountService(Account accountRequest) {
		return accountService.findByUsernameAndPassword(accountRequest);
	}

	private Account MapRequestToModelAccount(HttpServletRequest request) throws IOException {
		return (Account)HttpUtils.of(request.getReader()).toModel(Account.class);
	}
	
	private boolean isUser(Account accountService) {
		if (accountService != null)
			return true;
		return false;
	}

}
