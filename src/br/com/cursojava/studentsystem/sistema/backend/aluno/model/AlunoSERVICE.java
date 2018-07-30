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
		/** Garante a aplicação da associação entre o service eo DAO */
		DAO = new AlunoDAO();
	}

	@Override
	public void inserir( AlunoPO po ) throws ApplicationException {
		HibernateConnection hibernate = new HibernateConnection();
		try {
			/** Aplicando as Validações utilizando IF negatico */
			if ( po == null ) {
				throw new ApplicationException( "Parâmetro não pode ser NULO" );
			}
			
			/** Aplicando as Validações utilizando IF negatico */
			if(!Utilidades.isCpfValido( po.getCpf() )){
				throw new ApplicationException( "CPF Inválido - " + po.getCpf() );
			}

			/** Aplicando as Validações utilizando IF negatico */
			if ( po.getDataNascimento() != null && new Date().before( po.getDataNascimento() ) ) {
				/* Entra aqui caso a data de nascimento esteja inválida*/
				throw new ApplicationException( "CPF Inválido - " + po.getCpf() );
			}
			/** 1º Iniciar a transação */
			hibernate.iniciarTransacao();
			/** 2º Faxer o tem que ser feito */
			DAO.inserir( po, hibernate );
			/** 3º confirmara transação( caso tudo dê certo */
			hibernate.commitTransacao();
			
		}catch( ApplicationException e ){
			/** 3º Desfazer a Transação (caso Algo dê errado) */
			hibernate.rollbackTransacao();
			
			throw e;
		} catch ( Exception e ) {
			/** 3º Desfazer a Transação (caso Algo dê errado) */
			hibernate.rollbackTransacao();
			throw new ApplicationException( "Erro desconhecido ao inserir", e );
		}
	}

	@Override
	public void alterar( AlunoPO po ) throws ApplicationException {
		HibernateConnection hibernate = new HibernateConnection();
		try {
			/** Aplicando as Validações utilizando IF negatico */
			if ( po == null ) {
				throw new ApplicationException( "Parâmetro não pode ser NULO" );
			}
			
			/** Aplicando as Validações utilizando IF negatico */
			if(Utilidades.isCpfValido( po.getCpf() )){
				throw new ApplicationException( "CPF Inválido - " + po.getCpf() );
			}

			/** Aplicando as Validações utilizando IF negatico */
			if ( po.getDataNascimento() != null && new Date().before( po.getDataNascimento() ) ) {
				/* Entra aqui caso a data de nascimento esteja inválida*/
				throw new ApplicationException( "CPF Inválido - " + po.getCpf() );
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
			/** Aplicando as Validações utilizando IF negatico */
			if ( po == null ) {
				throw new ApplicationException( "Parâmetro não pode ser NULO" );
			}
			
			if(po.getId() == null){
				throw new ApplicationException( "ID não pode ser NULO" );
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
			/** Aplicando as Validações utilizando IF negatico */
			if ( po == null ) {
				throw new ApplicationException( "Parâmetro não pode ser NULO" );
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
			/** Aplicando as Validações utilizando IF negatico */
		
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
			/** Aplicando as Validações utilizando IF negatico */
			if ( id == null ) {
				throw new ApplicationException( "Parâmetro não pode ser NULO" );
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
