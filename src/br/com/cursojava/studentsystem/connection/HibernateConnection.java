package br.com.cursojava.studentsystem.connection;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import br.com.cursojava.studentsystem.abstracts.AbstractPO;
import br.com.cursojava.studentsystem.exceptions.ApplicationException;
import br.com.cursojava.studentsystem.interfaces.Crud;

public final class HibernateConnection {

	/** UTILIZAÇÃO DO HIBERNATE 4.X */
	private static final SessionFactory SESSION_FACTORY;
	private Session sessaoCorrente;
	private Transaction transacao;

	/**
	 * Bloco estático responsável por carregar um objeto "Configuration" com os
	 * dados configurados na TAG (<hibernate-configuration>) do arquivo
	 * hibernate.cfg.xml PS: Bloco estático garante que seu conteúdo será
	 * executado pelo meno uma(1) vez ao instanciar a classe onde foi escrito.
	 */
	static {
		Configuration configuration = new Configuration().configure( "hibernate.cfg.xml" );
		configuration.setProperty( "hibernate.connection.url", "jdbc:mysql://localhost/" + Crud.SCHEMA + "?createDatabaseIfNotExist=true" );

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings( configuration.getProperties() ).buildServiceRegistry();
		SESSION_FACTORY = configuration.buildSessionFactory( serviceRegistry );
	}

	public Session getSessaoCorrente() throws ApplicationException {
		if(sessaoCorrente == null){
			throw new ApplicationException( "A transação não foi inicializada!" );
		}
		return sessaoCorrente;
	}

	private void abrirSessao() {
		sessaoCorrente = SESSION_FACTORY.openSession();
	}

	private void fecharSessao() {
		if ( sessaoCorrente == null ) {
			return;
		}
		sessaoCorrente.close();
		sessaoCorrente = null;
	}

	/**
	 * Informa que uma transação(persistencia) será feita no banco de dados.
	 * todas as transações devem ser confirmadas(commit) ou desfeitas(rollback)
	 */
	public void iniciarTransacao() {
		abrirSessao();
		transacao = sessaoCorrente.beginTransaction();
	}

	public void commitTransacao() {
		if ( transacao == null ) {
			return;
		}
		transacao.commit();
		fecharSessao();
		transacao = null;
	}

	public void rollbackTransacao() {
		if ( transacao == null ) {
			return;
		}
		transacao.rollback();
		fecharSessao();
		transacao = null;
	}

	/** Metodos de Persistencia */

	@SuppressWarnings( "unchecked" )
	public AbstractPO inserir( AbstractPO obj ) throws ApplicationException {
		try {
			
			return (AbstractPO) getSessaoCorrente().merge( obj );
		} catch ( Throwable t ) {
			throw new ApplicationException( "Erro inesperado", t );
		}
	}

	@SuppressWarnings( "unchecked" )
	public void alterar( AbstractPO obj ) throws ApplicationException {
		try {
			
			getSessaoCorrente().merge( obj );
		} catch ( Throwable t ) {
			throw new ApplicationException( "Erro inesperado", t );
		}
	}

	public void excluir( AbstractPO obj ) throws ApplicationException {
		try {
			getSessaoCorrente().delete( obj );
		} catch ( Throwable t ) {
			throw new ApplicationException( "Erro inesperado", t );
		}
	}

	/** Metodos de consulta 
	 * @throws ApplicationException */
	@SuppressWarnings( "unchecked" )
	public AbstractPO fitrarPorId( Class clazz, Long id ) throws ApplicationException {
		try {
			
			Criteria criteria = getSessaoCorrente().createCriteria( clazz );

			/**
			 * Caso a select retorne 2 tuplas identicas, ele transformará em 1 só.
			 * Ele força tambem o resultado da select virar do tipo da Classe passada.
			 */
			criteria.setResultTransformer( Criteria.DISTINCT_ROOT_ENTITY );
			
			criteria.add( Restrictions.idEq( id ) );
			
			return (AbstractPO) criteria.uniqueResult();
			
		} catch ( Throwable t ) {
			throw new ApplicationException( "Erro inesperado", t );
		}
	}
	
	public List filtrarTodos(Class clazz) throws ApplicationException{
		try {
			
			Criteria criteria = getSessaoCorrente().createCriteria( clazz );

			/**
			 * Caso a select retorne 2 tuplas identicas, ele transformará em 1 só.
			 * Ele força tambem o resultado da select virar do tipo da Classe passada.
			 */
			criteria.setResultTransformer( Criteria.DISTINCT_ROOT_ENTITY );
	
			return criteria.list();
			
		} catch ( Throwable t ) {
			throw new ApplicationException( "Erro inesperado", t );
		}
	}

}
