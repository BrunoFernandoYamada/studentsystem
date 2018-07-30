<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	var idade = document.getElementsByName(idade);
</script>
</head>
<body>
	<form action="resultado.jsp" method="post">
		<label>Texto</label>
		<input type="text" name="texto">

		<label>Idade</label>
		<input type="number" name="idade" min="0" max="100">
		
		<input type="submit" value="Enviar via Post">
		
	</form>
</body>
</html>