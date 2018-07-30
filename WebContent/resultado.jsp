<%@page import="br.com.cursojava.studentsystem.sistema.backend.aluno.controller.AlunoFACADE"%>
<%@page import="br.com.cursojava.studentsystem.sistema.backend.aluno.model.AlunoPO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado</title>
</head>
<body>
	<label>Texto</label>
	<input type="text" name="texto" value="${param.texto }">
	
	<core:if test="${param.idade >= 18}">
		<h2>Maior de idade</h2>
	</core:if>
	<core:if test="${param.idade < 18}">
		<h2>Menor de idade</h2>
	</core:if>
	
	<%try{
		
		AlunoPO po = new AlunoPO();
		po.setNome( request.getParameter( "texto" ) );
		
		out.println(po.getNome(  ));
		
		AlunoFACADE facade = new AlunoFACADE();
		facade.inserir( po );
		
	}catch(Exception e){
		out.println(e.getMessage(  ));
	}
	%>
</body>
</html>