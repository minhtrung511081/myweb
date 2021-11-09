package com.minhtrung.controllers.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minhtrung.models.PurchaseInvoice;
import com.minhtrung.utils.HttpUtils;

@WebServlet(urlPatterns = "/api/purchase")
public class Purchase extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PurchaseInvoice invoice=HttpUtils.of(request.getReader()).toModel(PurchaseInvoice.class);
		
	}
	
}
