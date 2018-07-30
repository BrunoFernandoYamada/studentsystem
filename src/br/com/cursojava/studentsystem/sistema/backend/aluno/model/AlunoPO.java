package br.com.cursojava.studentsystem.sistema.backend.aluno.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import br.com.cursojava.studentsystem.abstracts.AbstractPO;
import br.com.cursojava.studentsystem.interfaces.Crud;
import br.com.cursojava.studentsystem.utilidades.Utilidades;

/** PO = Persistence Object */
@Entity
@Table(name="alunos", schema=Crud.SCHEMA, 
uniqueConstraints = @UniqueConstraint (columnNames = {"nome", "cpf", "ra"}) )
public class AlunoPO extends AbstractPO< AlunoPO > {

	
	@Column(name="nome", length=80, nullable=false)
	private String nome;
	
	@Column(name="cpf", length=14, nullable=false)
	private String cpf;
	
	@Column(name="altura", nullable=true, precision=3, scale=2)
	private BigDecimal altura;
	
	@Lob
	@Column(name="endereco", nullable=false, length=500)
	private String endereco;

	@Column(name="ra", nullable=false, length=8)
	private String ra;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dataNascimento", length=10, nullable=false)
	private Date dataNascimento;
	
	@Column(name="turma", length=80, nullable=false)
	private String turma;
	
	@Column(name="peso", nullable=true, precision=5, scale=2)
	private BigDecimal peso;
	
	@Column(name="sexo", nullable=false, length = 9)
	private String sexo;

	/** Exigencia do hibernate */
	public AlunoPO(){

	}

	public AlunoPO( Long id ){
		setId( id );
	}

	public AlunoPO( String nome, String cpf, String turma ){
		setNome( nome );
		setCpf( cpf );
		setTurma( turma );
	}

	

	public void setNome( String nome ) {
		this.nome = Utilidades.normalizeString( nome );
	}

	public String getNome() {
		return this.nome;
	}

	public void setCpf( String cpf ) {
		this.cpf = Utilidades.normalizeString( cpf );
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setAltura( BigDecimal altura ) {
		this.altura = altura;
	}

	public BigDecimal getAltura() {
		return this.altura;
	}

	public void setEndereco( String logradouro, String numero, String bairro, String cidade, String cep, String uf ) {
		this.endereco = ( Utilidades.normalizeString( logradouro ) + ", " + Utilidades.normalizeString( numero ) + " " + Utilidades.normalizeString( bairro ) + " " + Utilidades.normalizeString( cep ) + " " + Utilidades.normalizeString( cidade ) + "/" + Utilidades.normalizeString( uf ) );
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setRa( String ra ) {
		this.ra = Utilidades.normalizeString( ra );
	}

	public String getRa() {
		return this.ra;
	}

	public void setDataNascimento( Date dataNascimento ) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setTurma( String turma ) {
		this.turma = Utilidades.normalizeString( turma );
	}

	public String getTurma() {
		return this.turma;
	}

	public void setPeso( BigDecimal peso ) {
		this.peso = peso;
	}

	public BigDecimal getPeso() {
		return this.peso;
	}

	public void setSexo( String sexo ) {
		this.sexo = Utilidades.normalizeString( sexo );
	}

	public String getSexo() {
		return this.sexo;
	}

	/**
	 * Polimorfico
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( cpf == null ) ? 0 : cpf.hashCode() );
		result = prime * result + ( ( nome == null ) ? 0 : nome.hashCode() );
		result = prime * result + ( ( ra == null ) ? 0 : ra.hashCode() );
		return result;
	}

	/**
	 * Polimorfico
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals( Object obj ) {
		if ( this == obj ) {
			return true;
		}
		if ( obj == null ) {
			return false;
		}
		if ( !( obj instanceof AlunoPO ) ) {
			return false;
		}
		AlunoPO other = (AlunoPO) obj;
		if ( cpf == null ) {
			if ( other.cpf != null ) {
				return false;
			}
		} else if ( !cpf.equals( other.cpf ) ) {
			return false;
		}
		if ( nome == null ) {
			if ( other.nome != null ) {
				return false;
			}
		} else if ( !nome.equals( other.nome ) ) {
			return false;
		}
		if ( ra == null ) {
			if ( other.ra != null ) {
				return false;
			}
		} else if ( !ra.equals( other.ra ) ) {
			return false;
		}
		return true;

	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append( "AlunoPO [nome=" );
		builder.append( nome );
		builder.append( ", cpf=" );
		builder.append( cpf );
		builder.append( ", altura=" );
		builder.append( altura );
		builder.append( ", endereco=" );
		builder.append( endereco );
		builder.append( ", ra=" );
		builder.append( ra );
		builder.append( ", dataNascimento=" );
		builder.append( dataNascimento );
		builder.append( ", turma=" );
		builder.append( turma );
		builder.append( ", peso=" );
		builder.append( peso );
		builder.append( ", sexo=" );
		builder.append( sexo );
		builder.append( ", getId()=" );
		builder.append( getId() );
		builder.append( "]" );
		return builder.toString();
	}

	/**
	  * Método responsável por conter a regra de comparação da Classe AlunoPO.
	  * Este método é usado sempre que quisermos ordernar uma lista de AlunoPO
	  * ou comparar uma AlunoPO com outro AlunoPO.
	  * Os retornos deste método significam o seguinte:
	  * # >1 - Quando o Objeto principal for MAIOR que o do parametro.
	  * # 0 - Quando o Objeto principal for IGUAL ao do parametro.
	  * # <1 - Quando o Objeto principal for MENOR que o do parametro.
	  * Polimorfico
	  * 
	  * @see java.lang.Comparable#compareTo(java.lang.Object)
	  */

	@Override
	public int compareTo( AlunoPO o ) {
		// TODO Auto-generated method stub
		return this.getNome().compareToIgnoreCase( o.getNome() );
	}

}
