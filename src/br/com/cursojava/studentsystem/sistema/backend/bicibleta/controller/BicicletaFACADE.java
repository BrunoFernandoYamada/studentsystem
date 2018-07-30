package br.com.cursojava.studentsystem.sistema.backend.bicibleta.controller;

import java.util.List;

import br.com.cursojava.studentsystem.exceptions.ApplicationException;
import br.com.cursojava.studentsystem.sistema.backend.bicibleta.model.BicicletaPO;
import br.com.cursojava.studentsystem.sistema.backend.bicibleta.model.BicicletaSERVICE;

public class BicicletaFACADE{

	private BicicletaSERVICE service;

	public BicicletaFACADE(){
		service = new BicicletaSERVICE();
	}

	public void inserir( BicicletaPO po ) throws ApplicationException {
		service.inserir( po );
	}

	public void alterar( BicicletaPO po ) throws ApplicationException {
		service.alterar( po );
	}

	public void excluir( BicicletaPO po ) throws ApplicationException {
		service.excluir( po );
	}

	public List filtrar( BicicletaPO po ) throws ApplicationException {
		return service.filtrar( po );
	}

	public List filtrarTodos() throws ApplicationException {
		return service.filtrarTodos();
	}

	public BicicletaPO filtrarPorId( Long id ) throws ApplicationException {
		return service.filtrarPorId( id );
	}

}
