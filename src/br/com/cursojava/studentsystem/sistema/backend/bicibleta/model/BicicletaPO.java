package br.com.cursojava.studentsystem.sistema.backend.bicibleta.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.cursojava.studentsystem.abstracts.AbstractPO;
import br.com.cursojava.studentsystem.interfaces.Crud;
import br.com.cursojava.studentsystem.utilidades.Utilidades;

@Entity
@Table(name="bicicletas", schema=Crud.SCHEMA, 
uniqueConstraints = @UniqueConstraint (columnNames = {"cor", "marca", "modalidade","preco","marcha","dataFabricacao","material"}))
public class BicicletaPO extends AbstractPO< BicicletaPO >{

	@Column(name="cor", length=80, nullable=false)
	private String cor;
	
	@Column(name="marca", length=80, nullable=false)
	private String marca;
	
	@Column(name="modalidade", length=80, nullable=false)
	private String modalidade;
	
	@Column(name="preco", length=80, nullable=false)
	private BigDecimal preco;
	
	@Column(name="marcha", length=80, nullable=false)
	private Boolean marcha;
	
	@Column(name="dataFabricacao", length=80, nullable=false)
	private Date dataFabricacao;
	
	@Column(name="material", length=80, nullable=false)
	private String material;


	public String getCor() {
		return cor;
	}

	public void setCor( String cor ) {
		this.cor = Utilidades.normalizeString( cor );
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca( String marca ) {
		this.marca = Utilidades.normalizeString( marca );
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade( String modalidade ) {
		this.modalidade = Utilidades.normalizeString( modalidade );
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco( BigDecimal preco ) {
		this.preco = preco;
	}

	public Boolean getMarcha() {
		return marcha;
	}

	public void setMarcha( Boolean marcha ) {
		this.marcha = marcha;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao( Date dataFabricacao ) {
		this.dataFabricacao = dataFabricacao;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial( String material ) {
		this.material = Utilidades.normalizeString( material );
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( cor == null ) ? 0 : cor.hashCode() );
		result = prime * result + ( ( dataFabricacao == null ) ? 0 : dataFabricacao.hashCode() );
		result = prime * result + ( ( marca == null ) ? 0 : marca.hashCode() );
		result = prime * result + ( ( marcha == null ) ? 0 : marcha.hashCode() );
		result = prime * result + ( ( material == null ) ? 0 : material.hashCode() );
		result = prime * result + ( ( modalidade == null ) ? 0 : modalidade.hashCode() );
		result = prime * result + ( ( preco == null ) ? 0 : preco.hashCode() );
		return result;
	}

	@Override
	public boolean equals( Object obj ) {
		if ( this == obj ) {
			return true;
		}
		if ( obj == null ) {
			return false;
		}
		if ( !( obj instanceof BicicletaPO ) ) {
			return false;
		}
		BicicletaPO other = (BicicletaPO) obj;
		if ( cor == null ) {
			if ( other.cor != null ) {
				return false;
			}
		} else if ( !cor.equals( other.cor ) ) {
			return false;
		}
		if ( dataFabricacao == null ) {
			if ( other.dataFabricacao != null ) {
				return false;
			}
		} else if ( !dataFabricacao.equals( other.dataFabricacao ) ) {
			return false;
		}
		if ( marca == null ) {
			if ( other.marca != null ) {
				return false;
			}
		} else if ( !marca.equals( other.marca ) ) {
			return false;
		}
		if ( marcha == null ) {
			if ( other.marcha != null ) {
				return false;
			}
		} else if ( !marcha.equals( other.marcha ) ) {
			return false;
		}
		if ( material == null ) {
			if ( other.material != null ) {
				return false;
			}
		} else if ( !material.equals( other.material ) ) {
			return false;
		}
		if ( modalidade == null ) {
			if ( other.modalidade != null ) {
				return false;
			}
		} else if ( !modalidade.equals( other.modalidade ) ) {
			return false;
		}
		if ( preco == null ) {
			if ( other.preco != null ) {
				return false;
			}
		} else if ( !preco.equals( other.preco ) ) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append( "BicicletaPO [cor=" );
		builder.append( cor );
		builder.append( ", marca=" );
		builder.append( marca );
		builder.append( ", modalidade=" );
		builder.append( modalidade );
		builder.append( ", preco=" );
		builder.append( preco );
		builder.append( ", marcha=" );
		builder.append( marcha );
		builder.append( ", dataFabricacao=" );
		builder.append( dataFabricacao );
		builder.append( ", material=" );
		builder.append( material );
		builder.append( ", getId()=" );
		builder.append( getId() );
		builder.append( "]" );
		return builder.toString();
	}

	@Override
	public int compareTo( BicicletaPO o ) {
		
		return this.compareTo( o );
	}

	
	

}
