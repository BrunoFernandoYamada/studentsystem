package br.com.cursojava.studentsystem.abstracts;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @MappedSuperclass 
 * Mapeia esta classe como apenas uma classe Herança, onde todos 
 * seus atributos serão implemetados nas tabelas que representam as clases FILHAS
 * @author SRC Treinamentos
 *
 * @param <T>
 */
@MappedSuperclass
public abstract class AbstractPO<T> implements Comparable< T >{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	public void setId( Long id ) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}
	
	@Override
	public abstract int hashCode();

	@Override
	public abstract boolean equals( Object obj );

	@Override
	public abstract String toString();

}
