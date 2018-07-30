package br.com.cursojava.studentsystem.sistema.frontend.aluno;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import br.com.cursojava.studentsystem.sistema.backend.aluno.model.AlunoPO;

/**
 * Classe responsável por gerenciar todos os campos da tela.
 * Esta clasee terá um atributo para cada campo existente na tela
 * Quando o formulário do JSP é submetido, o request pega os dados dos
 * campos, envia para o struts que por sua vez preenche esta cladde FORM.
 * 
 * PS: Tudo que quiser fazeer na tela em relação a valores de campos, deve-sse
 * fazer aqui nesta clasee, pois no momento da montagem da tela, os
 * campos respeitam os valores contidos nos atributos
 * 
 * @author SRC Treinamentos
 *
 */

public class AlunoForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7195368720281200101L;
	private String id;
	private String nome;
	private String cpf;
	private String altura;
	private String ra;
	private String dataNascimento;
	private String turma;
	private String peso;
	private String sexo;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cidade;
	private String cep;
	private String uf;

	private ArrayList< AlunoPO > alunos = new ArrayList< AlunoPO >();
	
	

	public ArrayList< AlunoPO > getAlunos() {
		return alunos;
	}

	public void setAlunos( ArrayList< AlunoPO > alunos ) {
		this.alunos = alunos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public void setId( String id ) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome( String nome ) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf( String cpf ) {
		this.cpf = cpf;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura( String altura ) {
		this.altura = altura;
	}

	public String getRa() {
		return ra;
	}

	public void setRa( String ra ) {
		this.ra = ra;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento( String dataNascimento ) {
		this.dataNascimento = dataNascimento;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma( String turma ) {
		this.turma = turma;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso( String peso ) {
		this.peso = peso;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo( String sexo ) {
		this.sexo = sexo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro( String logradouro ) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero( String numero ) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro( String bairro ) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade( String cidade ) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep( String cep ) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf( String uf ) {
		this.uf = uf;
	}

	public void limparCampos() {
		setAltura( null );
		setCpf( null );
		setDataNascimento( null );
		setId( null );
		setNome( null );
		setPeso( null );
		setRa( null );
		setSexo( null );
		setTurma( null );
		setBairro( null );
		setCep( null );
		setCidade( null );
		setLogradouro( null );
		setNumero( null );
		setUf( null );
	}

}
