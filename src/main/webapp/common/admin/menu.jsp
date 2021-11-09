<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="layoutSidenav_nav">
	<nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
		<div class="sb-sidenav-menu">
			<div class="nav">
				
				<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
					
					 Tài khoản
					
					<!-- nut len xuong -->
					
					<div class="sb-sidenav-collapse-arrow">
						<i class="fas fa-angle-down"></i>
					</div>
					
					<!-- dong nut len xuong -->
				</a>
				<div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
					<nav class="sb-sidenav-menu-nested nav accordion"
						id="sidenavAccordionPages">
						
						
						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth"> 
						
						Người dùng
						
						<!-- nut len xuong -->
							<div class="sb-sidenav-collapse-arrow"> <i class="fas fa-angle-down"></i> </div>
						<!-- dong nut len xuong -->
						</a>
						
						
						<div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
							
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="login.html">Login</a> <a
									class="nav-link" href="register.html">Register</a> <a
									class="nav-link" href="password.html">Forgot Password</a>
							</nav>
						</div>
						
					</nav>
				</div>
			</div>
		</div>
		<div class="sb-sidenav-footer">
			<div class="small">Logged in as:</div>
			Trung Admin
		</div>
	</nav>
</div>