package com.minhtrung.controllers.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minhtrung.constant.constantC;
import com.minhtrung.models.Account;
import com.minhtrung.models.ModelUtils;
import com.minhtrung.models.Product;
import com.minhtrung.paging.PageRequest;
import com.minhtrung.paging.Pageble;
import com.minhtrung.paging.Sorter;
import com.minhtrung.services.IProductService;
import com.minhtrung.utils.HttpUtils;
import com.minhtrung.utils.SessionUtils;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;


@WebServlet(urlPatterns = {"/api/product"})
public class ProductController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IProductService productService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String page = request.getParameter("page");
		String limitRequest = request.getParameter("limit");
		if(request.getParameter("id")!=null) {
			Long id = Long.parseLong(request.getParameter("id"));
			mapper.writeValue(response.getOutputStream(), productService.findOne(id));
		}else if(page!=null & limitRequest!=null) {
			Integer currentPage = Integer.parseInt(page);
			Integer limit = Integer.parseInt(limitRequest);
			Pageble pageble = new PageRequest(currentPage, limit, new Sorter(request.getParameter("sortname"), request.getParameter("sortby")));
			List<Product> list = productService.getAll(pageble);
			mapper.writeValue(response.getOutputStream(), list);
		}
		
		else {
//			List<Product> list = productService.getAll();
//			mapper.writeValue(response.getOutputStream(), list);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("utf-8");
		Account account =(Account) SessionUtils.getInstance().getValue(request, constantC.KEY_SESSION);
		if(account!=null) {
			Product product=HttpUtils.of(request.getReader()).toModel(Product.class);
			product.setCreatedBy(account.getFullname());
			
			Long id = productService.insert(product);
			mapper.writeValue(response.getOutputStream(), productService.findOne(id));
		}else mapper.writeValue(response.getOutputStream(), constantC.ERROR_USER);

	}
	 
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		Account account =(Account) SessionUtils.getInstance().getValue(request, constantC.KEY_SESSION);
		Product productRequest=HttpUtils.of(request.getReader()).toModel(Product.class);
		Product productDB = productService.findOne(productRequest.getId());
		if(account!=null && productDB!=null) {
			productService.update(productRequest);
			mapper.writeValue(response.getOutputStream(), productService.findOne(productRequest.getId()));
		}else mapper.writeValue(response.getOutputStream(), constantC.ERROR_USER);
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		Account account =(Account) SessionUtils.getInstance().getValue(request, constantC.KEY_SESSION);
		ModelUtils modelUtils=HttpUtils.of(request.getReader()).toModel(ModelUtils.class);
		
		if(account!=null) {
			productService.delete(modelUtils.getIds());
			mapper.writeValue(response.getOutputStream(), constantC.DELETE_SUCCESS);
		}else mapper.writeValue(response.getOutputStream(), constantC.ERROR_USER);
	}
	
	
}
