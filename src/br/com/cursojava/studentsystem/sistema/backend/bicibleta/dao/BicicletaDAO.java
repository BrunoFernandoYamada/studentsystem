package br.com.cursojava.studentsystem.sistema.backend.bicibleta.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.cursojava.studentsystem.connection.HibernateConnection;
import br.com.cursojava.studentsystem.exceptions.ApplicationException;
import br.com.cursojava.studentsystem.sistema.backend.aluno.model.AlunoPO;
import br.com.cursojava.studentsystem.sistema.backend.bicibleta.model.BicicletaPO;

public class BicicletaDAO{

	public void inserir( BicicletaPO po, HibernateConnection hibernate ) throws ApplicationException {
		try{
			po.setId( hibernate.inserir( po ).getId());
		}catch(ApplicationException e){
			throw e;
		}catch(Exception e){
			throw new ApplicationException( "Erro desconhecido ao inserir", e );
		}	
	}

	public void alterar( BicicletaPO po, HibernateConnection hibernate ) throws ApplicationException {
		try{
			hibernate.alterar( po );
		}catch(ApplicationException e){
			throw e;
		}catch(Exception e){
			throw new ApplicationException( "Erro desconhecido ao alterar", e );
		}	
	}

	public void excluir( BicicletaPO po, HibernateConnection hibernate ) throws ApplicationException {
		try{
			hibernate.excluir( po );
		}catch(ApplicationException e){
			throw e;
		}catch(Exception e){
			throw new ApplicationException( "Erro desconhecido ao excluir", e );
		}	
	}
	
	public List<BicicletaPO> filtrarTodos(HibernateConnection hibernate) throws ApplicationException {
		try{
			return hibernate.filtrarTodos( AlunoPO.class );
		}catch(ApplicationException e){
			throw e;
		}catch(Exception e){
			throw new ApplicationException( "Erro desconhecido ao filtrar todos", e );
		}	
	}


	public BicicletaPO filtrarPorId( Long id, HibernateConnection hibernate ) throws ApplicationException {
		try{
			return (BicicletaPO) hibernate.fitrarPorId( BicicletaPO.class, id );
		}catch(ApplicationException e){
			throw e;
		}catch(Exception e){
			throw new ApplicationException( "Erro desconhecido ao filtrar po ID", e );
		}	
	}
	

	public List<BicicletaPO> filtrar( BicicletaPO po, HibernateConnection hibernate ) throws ApplicationException {
try{
			
			Criteria criteria = hibernate.getSessaoCorrente().createCriteria( BicicletaPO.class );
			criteria.setResultTransformer( Criteria.DISTINCT_ROOT_ENTITY );
			/*Montando as Restrições dinâmicas*/
			if(po.getMarcha() != null){
				criteria.add( Restrictions.eq( "marcha", po.getMarcha() ) );
			}
			if(po.getCor() != null){
				criteria.add( Restrictions.like( "cor", po.getCor(), MatchMode.START  ) );
			}
			if(po.getDataFabricacao() != null){
				criteria.add( Restrictions.eq( "dataFabricacao", po.getDataFabricacao()) );
			}
			if(po.getId() != null){
				criteria.add( Restrictions.idEq(po.getId()) );
			}
			if(po.getMarca() != null){
				criteria.add( Restrictions.like( "marca", po.getMarca(), MatchMode.START) );
			}
			if(po.getMaterial()!= null){
				criteria.add( Restrictions.like( "material", po.getMaterial(), MatchMode.START) );
			}
			if(po.getModalidade() != null){
				criteria.add( Restrictions.like( "modalidade", po.getModalidade(), MatchMode.START) );
			}
			if(po.getPreco() != null){
				criteria.add( Restrictions.eq( "preco", po.getPreco()) );
			}
			
			criteria.addOrder( Order.asc( "marca" ) );
			
			return criteria.list();
			
			
		}catch(Exception e){
			throw new ApplicationException( "Erro desconhecido ao filtrar", e );
		}	
	
	}

}
