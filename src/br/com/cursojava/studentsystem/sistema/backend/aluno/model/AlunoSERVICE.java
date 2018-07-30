package br.com.cursojava.studentsystem.sistema.backend.aluno.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.cursojava.studentsystem.connection.HibernateConnection;
import br.com.cursojava.studentsystem.exceptions.ApplicationException;
import br.com.cursojava.studentsystem.interfaces.Crud;
import br.com.cursojava.studentsystem.sistema.backend.aluno.dao.AlunoDAO;
import br.com.cursojava.studentsystem.utilidades.Utilidades;

public final class AlunoSERVICE implements Crud< AlunoPO >{
	

	private final AlunoDAO DAO;

	public AlunoSERVICE(){
		/** Garante a aplica��o da associa��o entre o service eo DAO */
		DAO = new AlunoDAO();
	}

	@Override
	public void inserir( AlunoPO po ) throws ApplicationException {
		HibernateConnection hibernate = new HibernateConnection();
		try {
			/** Aplicando as Valida��es utilizando IF negatico */
			if ( po == null ) {
				throw new ApplicationException( "Par�metro n�o pode ser NULO" );
			}
			
			/** Aplicando as Valida��es utilizando IF negatico */
			if(!Utilidades.isCpfValido( po.getCpf() )){
				throw new ApplicationException( "CPF Inv�lido - " + po.getCpf() );
			}

			/** Aplicando as Valida��es utilizando IF negatico */
			if ( po.getDataNascimento() != null && new Date().before( po.getDataNascimento() ) ) {
				/* Entra aqui caso a data de nascimento esteja inv�lida*/
				throw new ApplicationException( "CPF Inv�lido - " + po.getCpf() );
			}
			/** 1� Iniciar a transa��o */
			hibernate.iniciarTransacao();
			/** 2� Faxer o tem que ser feito */
			DAO.inserir( po, hibernate );
			/** 3� confirmara transa��o( caso tudo d� certo */
			hibernate.commitTransacao();
			
		}catch( ApplicationException e ){
			/** 3� Desfazer a Transa��o (caso Algo d� errado) */
			hibernate.rollbackTransacao();
			
			throw e;
		} catch ( Exception e ) {
			/** 3� Desfazer a Transa��o (caso Algo d� errado) */
			hibernate.rollbackTransacao();
			throw new ApplicationException( "Erro desconhecido ao inserir", e );
		}
	}

	@Override
	public void alterar( AlunoPO po ) throws ApplicationException {
		HibernateConnection hibernate = new HibernateConnection();
		try {
			/** Aplicando as Valida��es utilizando IF negatico */
			if ( po == null ) {
				throw new ApplicationException( "Par�metro n�o pode ser NULO" );
			}
			
			/** Aplicando as Valida��es utilizando IF negatico */
			if(Utilidades.isCpfValido( po.getCpf() )){
				throw new ApplicationException( "CPF Inv�lido - " + po.getCpf() );
			}

			/** Aplicando as Valida��es utilizando IF negatico */
			if ( po.getDataNascimento() != null && new Date().before( po.getDataNascimento() ) ) {
				/* Entra aqui caso a data de nascimento esteja inv�lida*/
				throw new ApplicationException( "CPF Inv�lido - " + po.getCpf() );
			}
			hibernate.iniciarTransacao();
			DAO.alterar( po, hibernate );
			hibernate.commitTransacao();
		}catch( ApplicationException e ){
			hibernate.rollbackTransacao();
			throw e;
		} catch ( Exception e ) {
			hibernate.rollbackTransacao();
			throw new ApplicationException( "Erro desconhecido ao alterar", e );
		}
	}

	@Override
	public void excluir( AlunoPO po ) throws ApplicationException {
		HibernateConnection hibernate = new HibernateConnection();
		try {
			/** Aplicando as Valida��es utilizando IF negatico */
			if ( po == null ) {
				throw new ApplicationException( "Par�metro n�o pode ser NULO" );
			}
			
			if(po.getId() == null){
				throw new ApplicationException( "ID n�o pode ser NULO" );
			}
			
			hibernate.iniciarTransacao();
			DAO.excluir( po, hibernate );
		}catch( ApplicationException e ){
			hibernate.rollbackTransacao();
			throw e;
		} catch ( Exception e ) {
			hibernate.rollbackTransacao();
			throw new ApplicationException( "Erro desconhecido ao excluir", e );
		}
	}

	@Override
	public ArrayList< AlunoPO > filtrar( AlunoPO po ) throws ApplicationException {
		HibernateConnection hibernate = new HibernateConnection();
		try {
			/** Aplicando as Valida��es utilizando IF negatico */
			if ( po == null ) {
				throw new ApplicationException( "Par�metro n�o pode ser NULO" );
			}
			hibernate.iniciarTransacao();
			List< AlunoPO > encontrados = DAO.filtrar( po, hibernate );
			hibernate.commitTransacao();
			return (ArrayList< AlunoPO >) encontrados;
		}catch( ApplicationException e ){
			throw e;
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro desconhecido ao excluir", e );
		}
	}

	@Override
	public ArrayList< AlunoPO > filtrarTodos() throws ApplicationException {
		HibernateConnection hibernate = new HibernateConnection();
		try {
			/** Aplicando as Valida��es utilizando IF negatico */
		
			hibernate.iniciarTransacao();
			List< AlunoPO > encontrados = DAO.filtrarTodos( hibernate );
			hibernate.commitTransacao();
			return (ArrayList<AlunoPO>) encontrados ;
		}catch( ApplicationException e ){
			throw e;
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro desconhecido ao excluir", e );
		}

	}

	@Override
	public AlunoPO filtrarPorId( Long id ) throws ApplicationException {
		HibernateConnection hibernate = new HibernateConnection();
		try {
			/** Aplicando as Valida��es utilizando IF negatico */
			if ( id == null ) {
				throw new ApplicationException( "Par�metro n�o pode ser NULO" );
			}
			hibernate.iniciarTransacao();
			AlunoPO encontrados = DAO.filtrarPorId( id, hibernate );
			hibernate.commitTransacao();
			return encontrados;
		}catch( ApplicationException e ){
			throw e;
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro desconhecido ao excluir", e );
		}
		

	}
}
