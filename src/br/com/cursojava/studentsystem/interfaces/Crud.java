package br.com.cursojava.studentsystem.interfaces;

import java.util.ArrayList;

import br.com.cursojava.studentsystem.exceptions.ApplicationException;

public interface Crud< T > {

	/** Todo atributo é public static final na interface */
	String SCHEMA = "student_system_t32n";

	void inserir( T po ) throws ApplicationException;

	void alterar( T po ) throws ApplicationException;

	void excluir( T po ) throws ApplicationException;

	ArrayList< T > filtrar( T po ) throws ApplicationException;

	ArrayList< T > filtrarTodos() throws ApplicationException;

	T filtrarPorId( Long id ) throws ApplicationException;

}
