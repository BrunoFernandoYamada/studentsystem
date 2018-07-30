package br.com.cursojava.studentsystem.connection.teste;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.junit.Test;

import br.com.cursojava.studentsystem.connection.HibernateConnection;
import br.com.cursojava.studentsystem.exceptions.ApplicationException;
import br.com.cursojava.studentsystem.sistema.backend.aluno.model.AlunoPO;

public class TestaConexao{

	@Test
	public void executar(){
		HibernateConnection hibernate = new HibernateConnection();
		
		try{
			/** O Basico pra o uso do Componente HibenateConnection �: */
			/** 1� Iniciar a transa��o */
			/** 2� Faxer o tem que ser feito */
			/** 3� confirmara transa��o( caso tudo d� certo */
			/** 3� Desfazer a Transa��o (caso Algo d� errado) */
			
			/** 1� Iniciar transa��o */
			 	hibernate.iniciarTransacao();
			 
			/** 2� Faxer o tem que ser feito */
			 	List encontrados = hibernate.filtrarTodos( AlunoPO.class );
			 	System.out.println( encontrados );
			 	
			 	AlunoPO aluno = new AlunoPO( );
			 	aluno.setNome("Bruno Yamada" );
			 	aluno.setCpf( "293.987.345-34");
			 	aluno.setTurma( "Turma xxxi Noturno de Seg a Sex" );
				aluno.setAltura( new BigDecimal( "1.83" ) );
				aluno.setDataNascimento( new Date() );
				aluno.setEndereco( "Rua Lauro Zimmerman Filho", "210", "Itamarati", "Ourinhos", "19001030", "SP" );
				aluno.setPeso( new BigDecimal( "65.2" ) );
				aluno.setRa( "12345678" );
				aluno.setSexo( "Masculino" );
				
				aluno = (AlunoPO) hibernate.inserir( aluno );
				
				encontrados = hibernate.filtrarTodos( AlunoPO.class );
			 	System.out.println( encontrados );
				
				aluno.setTurma( "Sem turma" );
				hibernate.alterar( aluno );
				
				encontrados = hibernate.filtrarTodos( AlunoPO.class );
			 	System.out.println( encontrados );
			 	
			 	AlunoPO encontradoPorId = (AlunoPO) hibernate.fitrarPorId( AlunoPO.class, aluno.getId() );
			 	System.out.println( encontradoPorId );
			 	
			 	hibernate.excluir( aluno );
			 	
			 	encontrados = hibernate.filtrarTodos( AlunoPO.class );
			 	System.out.println( encontrados );
			 	
			 	
			/** 3� confirmara transa��o( caso tudo d� certo */
				hibernate.commitTransacao();
				
				/** 3� Desfazer a Transa��o (caso Algo d� errado) */
				hibernate.rollbackTransacao();
				
		}catch(ApplicationException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
