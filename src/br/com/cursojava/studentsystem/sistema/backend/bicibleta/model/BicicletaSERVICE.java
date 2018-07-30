package br.com.cursojava.studentsystem.sistema.backend.bicibleta.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.cursojava.studentsystem.connection.HibernateConnection;
import br.com.cursojava.studentsystem.exceptions.ApplicationException;
import br.com.cursojava.studentsystem.sistema.backend.aluno.model.AlunoPO;
import br.com.cursojava.studentsystem.sistema.backend.bicibleta.dao.BicicletaDAO;

public class BicicletaSERVICE{

	private final BicicletaDAO DAO;

	public BicicletaSERVICE(){
		DAO = new BicicletaDAO();
	}

	public void inserir( BicicletaPO po ) throws ApplicationException {
		HibernateConnection hibernate = new HibernateConnection();

		try {
			/** Aplicando as Validações utilizando IF negatico */
			if ( new Date().before( po.getDataFabricacao() ) ) {
				/* Entra aqui caso a data de nascimento esteja inválida*/
				throw new ApplicationException( "Data inválida - " + po.getDataFabricacao() );
			}
			hibernate.iniciarTransacao();
			DAO.inserir( po, hibernate );
			hibernate.commitTransacao();
		} catch ( ApplicationException e ) {
			hibernate.rollbackTransacao();
			throw e;
		}catch ( Exception e ) {
			hibernate.rollbackTransacao();
			throw new ApplicationException( "Erro desconhecido ao inserir", e );
		}

	}

	public void alterar( BicicletaPO po ) throws ApplicationException {

		HibernateConnection hibernate = new HibernateConnection();

		try {
			/** Aplicando as Validações utilizando IF negatico */
			if ( new Date().before( po.getDataFabricacao() ) ) {
				/* Entra aqui caso a data de nascimento esteja inválida*/
				throw new ApplicationException( "Data inválida - " + po.getDataFabricacao() );
			}
			hibernate.iniciarTransacao();
			DAO.alterar( po, hibernate );
			hibernate.commitTransacao();
		} catch ( ApplicationException e ) {
			hibernate.rollbackTransacao();
			throw e;
		}catch ( Exception e ) {
			hibernate.rollbackTransacao();
			throw new ApplicationException( "Erro desconhecido ao inserir", e );
		}
	}

	public void excluir( BicicletaPO po ) throws ApplicationException {

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

	public ArrayList< BicicletaPO > filtrar( BicicletaPO po ) throws ApplicationException {
		HibernateConnection hibernate = new HibernateConnection();
		try {
			/** Aplicando as Validações utilizando IF negatico */
			if ( po == null ) {
				throw new ApplicationException( "Parâmetro não pode ser NULO" );
			}
			hibernate.iniciarTransacao();
			List< BicicletaPO > encontrados = DAO.filtrar( po, hibernate );
			hibernate.commitTransacao();
			return (ArrayList< BicicletaPO >) encontrados;
		}catch( ApplicationException e ){
			throw e;
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro desconhecido ao excluir", e );
		}
	}

	public ArrayList< BicicletaPO > filtrarTodos() throws ApplicationException {
		HibernateConnection hibernate = new HibernateConnection();
		try {
		
			hibernate.iniciarTransacao();
			List< BicicletaPO > encontrados = DAO.filtrarTodos( hibernate );
			hibernate.commitTransacao();
			return (ArrayList<BicicletaPO>) encontrados ;
		}catch( ApplicationException e ){
			throw e;
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro desconhecido ao excluir", e );
		}
	}

	public BicicletaPO filtrarPorId( Long id ) throws ApplicationException {
		HibernateConnection hibernate = new HibernateConnection();
		try {
			/** Aplicando as Validações utilizando IF negatico */
			if ( id == null ) {
				throw new ApplicationException( "Parâmetro não pode ser NULO" );
			}
			hibernate.iniciarTransacao();
			BicicletaPO encontrados = DAO.filtrarPorId( id, hibernate );
			hibernate.commitTransacao();
			return encontrados;
		}catch( ApplicationException e ){
			throw e;
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro desconhecido ao excluir", e );
		}
		
	}

}
