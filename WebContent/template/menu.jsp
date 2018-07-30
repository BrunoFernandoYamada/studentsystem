<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav" id="side-menu">

			<li>
				<a href="${rootWeb}/index.html">
					<i class="fa fa-dashboard fa-fw"></i>
					Home
				</a>
			</li>
			<!-- MENU -->
			<li>
				<!-- SUBMENU -->
				<a href="#">
					<i class="fa fa-cubes fa-fw"></i>
					Exemplo Menu
					<span class="fa arrow"></span>
				</a>
				<!-- SUBMENU -->
				<ul class="nav nav-second-level">
					<li>
						<a href="#">SubMenu 1</a>
					</li>
					<li>
						<a href="#">SubMenu 2</a>
					</li>
				</ul>
				<!-- /.nav-second-level -->
			</li>

			<!-- Cada li é um Menu -->
			<li>
				<!-- Realizando uma requizição via GET com STRUTS -->
				<a href="${rootWeb}/alunoAction.do?method=abrirTela">
					<i class="glyphicon glyphicon-education"></i>
					Aluno
				</a>
			</li>
		</ul>
	</div>
	<!-- /.sidebar-collapse -->
</div>