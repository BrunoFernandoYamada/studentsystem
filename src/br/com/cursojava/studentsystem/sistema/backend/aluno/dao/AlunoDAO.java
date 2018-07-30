package br.com.cursojava.studentsystem.sistema.backend.aluno.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.cursojava.studentsystem.connection.HibernateConnection;
import br.com.cursojava.studentsystem.exceptions.ApplicationException;
import br.com.cursojava.studentsystem.sistema.backend.aluno.model.AlunoPO;

public final class AlunoDAO{

	public void inserir( AlunoPO po, HibernateConnection hibernate ) throws ApplicationException {
		try{
			po.setId( hibernate.inserir( po ).getId());
		}catch(ApplicationException e){
			throw e;
		}catch(Exception e){
			throw new ApplicationException( "Erro desconhecido ao inserir", e );
		}	
	}

	public void alterar( AlunoPO po, HibernateConnection hibernate  ) throws ApplicationException {
		
		try{
			hibernate.alterar( po );
		}catch(ApplicationException e){
			throw e;
		}catch(Exception e){
			throw new ApplicationException( "Erro desconhecido ao alterar", e );
		}	
	}

	public void excluir( AlunoPO po, HibernateConnection hibernate  ) throws ApplicationException {
		try{
			hibernate.excluir( po );
		}catch(ApplicationException e){
			throw e;
		}catch(Exception e){
			throw new ApplicationException( "Erro desconhecido ao excluir", e );
		}	
			
	}


	public List< AlunoPO > filtrarTodos( HibernateConnection hibernate ) throws ApplicationException {
		try{
			return hibernate.filtrarTodos( AlunoPO.class );
		}catch(ApplicationException e){
			throw e;
		}catch(Exception e){
			throw new ApplicationException( "Erro desconhecido ao filtrar todos", e );
		}	
	}

	public AlunoPO filtrarPorId( Long id, HibernateConnection hibernate) throws ApplicationException {
		try{
			return (AlunoPO) hibernate.fitrarPorId( AlunoPO.class, id );
		}catch(ApplicationException e){
			throw e;
		}catch(Exception e){
			throw new ApplicationException( "Erro desconhecido ao filtrar po ID", e );
		}	
	
	}
	
	public List< AlunoPO > filtrar( AlunoPO po, HibernateConnection hibernate  ) throws ApplicationException {
		try{
			
			Criteria criteria = hibernate.getSessaoCorrente().createCriteria( AlunoPO.class );
			criteria.setResultTransformer( Criteria.DISTINCT_ROOT_ENTITY );
			/*Montando as Restrições dinâmicas*/
			if(po.getAltura() != null){
				criteria.add( Restrictions.eq( "altura", po.getAltura() ) );
			}
			if(po.getCpf() != null){
				criteria.add( Restrictions.eq( "cpf", po.getCpf() ) );
			}
			if(po.getDataNascimento() != null){
				criteria.add( Restrictions.eq( "dataNascimento", po.getDataNascimento()) );
			}
			if(po.getEndereco() != null){
				criteria.add( Restrictions.like( "endereco", po.getEndereco(), MatchMode.START ) );
			}
			if(po.getId() != null){
				criteria.add( Restrictions.idEq(po.getId()) );
			}
			if(po.getNome() != null){
				criteria.add( Restrictions.like( "nome", po.getNome(), MatchMode.START) );
			}
			if(po.getPeso()!= null){
				criteria.add( Restrictions.eq( "peso", po.getPeso()) );
			}
			if(po.getRa() != null){
				criteria.add( Restrictions.eq( "ra", po.getRa()) );
			}
			if(po.getSexo() != null){
				criteria.add( Restrictions.eq( "sexo", po.getSexo()) );
			}
			if(po.getTurma()!= null){
				criteria.add( Restrictions.like( "turma", po.getTurma(), MatchMode.START) );
			}
			
			criteria.addOrder( Order.asc( "nome" ) );
			
			return criteria.list();
			
			
		}catch(Exception e){
			throw new ApplicationException( "Erro desconhecido ao filtrar", e );
		}	
	
	}
	
	public List filtrarPorIntervaloDataNascimento(Date dataInicial, Date dataFinal, HibernateConnection hibernate) throws ApplicationException{
		try{
			/** Criando uma HQL*/ 
			final StringBuffer HQL = new StringBuffer();
			HQL.append( " Select aluno From AlunoPO aluno " );
			HQL.append( " Where " );
			HQL.append( " aluno.datanascimento between :dataInicialParam and :dataFinalParam" );
			
			/** Criando um Objeto do tipo query*/
			Query query = hibernate.getSessaoCorrente().createQuery( HQL.toString() );
			/** Prenchendo os parametrod da HQL acima*/
		query.setParameter( "dataInicialParam", dataInicial );
		query.setParameter( "dataInicialParam", dataFinal );
		
		/** Executando a query*/
		return query.list();
		
		}catch(Exception e){
			throw new ApplicationException( "Erro desconhecido ao filtrar po ID", e );
		}	
	}
	
	

}
