package br.com.cursojava.studentsystem.teste.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServelet extends HttpServlet{
	
	private static final long serialVersionUID = -6053586405205707036L;

	@Override
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		/** Pegando os dados contidos nos parametros do request */
		String texto = request.getParameter( "texto" );
		
		/** peganddo o escritor de HTML do reponse */
		PrintWriter html = response.getWriter();
		
		/** Montando a tela do resultado*/
		html.println( " <!DOCTYPE html> " );
		html.println( " <html> " );
		html.println( " 	<head> " );
		html.println( " 		<meta charset=\"ISO-8859-1\"> " );
		html.println( " 		<title>Sistema </title> " );
		html.println( " 	</head> " );
		html.println( " 	<body> " );
		html.println( " 		<h1>Texto: </h1><h3>"+texto+"</h3>" );
		html.println( " 		<input type=\"text\" name=\"texto\" value=\" '" + texto + "'\">  ");
		html.println( " 	</body> " );
		html.println( " </html> " );
	}
	
	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		/** Pegando os dados contidos nos parametros do request */
		String texto = request.getParameter( "texto" );
		
		/** peganddo o escritor de HTML do reponse */
		PrintWriter html = response.getWriter();
		
		/** Montando a tela do resultado*/
		html.println( " <!DOCTYPE html> " );
		html.println( " <html> " );
		html.println( " 	<head> " );
		html.println( " 		<meta charset=\"ISO-8859-1\"> " );
		html.println( " 		<title>Sistema </title> " );
		html.println( " 	</head> " );
		html.println( " 	<body> " );
		html.println( " 		<h1>Texto: </h1><h3>"+texto+"</h3>" );
		html.println( " 		<input type=\"text\" name=\"texto\" value=\" '" + texto + "'\">  ");
		html.println( " 	</body> " );
		html.println( " </html> " );
	}
	
}
