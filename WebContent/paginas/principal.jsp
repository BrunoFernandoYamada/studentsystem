<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Student System</title>

<jsp:include page="../template/imports/importscss.jsp"></jsp:include>

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">

			<!-- ###################### INICIO - CABEÇARIO ########################## -->
			<jsp:include page="../template/cabecario.jsp"></jsp:include>
			<!-- ###################### FIM - CABEÇARIO ########################## -->

			<!-- /.navbar-top-links -->

			<!-- ###################### INICIO - MENU ########################## -->
			<jsp:include page="../template/menu.jsp"></jsp:include>
			<!-- ###################### FIM - MENU ########################## -->

		</nav>

		<div id="page-wrapper">
		<!-- ###################### AQUI INICIA-SE A MONTAGEM DA TELA ########################## -->
		<!-- Utiliza-se o conceito de linha(row) e coluna(col = ??) -->
			
			<div class="row">
				<div class="col-xs-12">
					<h3>
						<i class="glyphicon glyphicon-education"></i>
						Sejam Bem vindos ao StudentSystem
					</h3>
				</div>
			</div>
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<jsp:include page="../template/imports/importsjs.jsp"></jsp:include>

</body>

</html>
