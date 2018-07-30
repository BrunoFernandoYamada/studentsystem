package br.com.cursojava.studentsystem.sistema.frontend.aluno;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import br.com.cursojava.studentsystem.exceptions.ApplicationException;
import br.com.cursojava.studentsystem.sistema.backend.aluno.controller.AlunoFACADE;
import br.com.cursojava.studentsystem.sistema.backend.aluno.model.AlunoPO;
import br.com.cursojava.studentsystem.utilidades.Messages;
import br.com.cursojava.studentsystem.utilidades.Utilidades;

/**
 * Classe responsável poar Gerenciar as Ações de tela;
 * Todo método da ACTION possui os mesmos 4 parâmetros;
 * Todo Método da ACTION deve retornar uma tela destino mapeada na
 * TAG <forward> do struts-config.
 * 
 * @author SRC Treinamentos
 *
 */

public class AlunoAction extends DispatchAction{

	/**
	 * Método responsável por abrir a tela de cadastro de aluno.
	 * 
	 * Todo médodo da ACTION que será acessivel da tela terá
	 * o mesmo RETORNO(ActionForward), mesmos PARAMETROS(ActionMapping mapping,
	 * ActionForm form, HttpServletRequest request,
	 * HttpServletResponse response) e mesmo RETORNO(mapping.findForward( "nome_do_forward_aqui" ))
	 *
	 * @param ActionMapping mapping - Variavél que possibilita o ACESSO
	 *        á TAG <action-mappings> do struts-config.xml
	 * @param ActionForm form - Variavel que contem todos os dados vindos da tela setados em seus ATRIBUTOS
	 * @param HttpServletRequest request - Permite recuperar dados da tela sem que seja por intermedio do Struts
	 * @param HttpServletResponse response - Permite manipular a tela sem que seja por intermedio do Struts
	 * @return ActionForward - Forward referente a tela que deverá ser aberta apos a execução do Metodo. O valor passado como
	 *         parametro esta definido na propriedade NAME da TAG <forward> da TAG <action-mappings> do arquivo struts-config.xml.
	 *
	 * @author Gabriel Damiani Carvalheiro <gabriel.carvalheiro@gmail.com.br>
	 * @since 16 de jan de 2017 22:39:22
	 * @version 1.0
	 */

	public ActionForward abrirTela( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {

		AlunoForm meuForm = (AlunoForm) form;
		meuForm.limparCampos();

		/** O Mapping vai até o struts-config.xml procurar um forward com o nome passado como parametro */
		return mapping.findForward( "alunoView" );
	}

	public ActionForward inserir( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {

		try {
			AlunoForm meuForm = (AlunoForm) form;

			AlunoFACADE facade = new AlunoFACADE();
			
			facade.inserir( montarPO( meuForm ) );
			
			meuForm.limparCampos();
			
			this.addMessages( request, Messages.createMessages( "sucesso" ) );

		} catch ( ApplicationException e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", e.getMessage() ) );
		} catch ( ParseException e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", e.getMessage() ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessagesErrors( "erro", e.getMessage() ) );
		}
		/** O Mapping vai até o struts-config.xml procurar um forward com o nome passado como parametro */
		return mapping.findForward( "alunoView" );
	}

	private AlunoPO montarPO( AlunoForm meuForm ) throws ParseException {
		AlunoPO po = new AlunoPO();

		if ( meuForm.getId() != null && !meuForm.getId().isEmpty() ) {
			po.setId( Long.valueOf( meuForm.getId() ) );
		} else {
			po.setId( null );
		}

		if ( meuForm.getAltura() != null && !meuForm.getAltura().isEmpty() ) {
			po.setAltura( Utilidades.parseBigDecimal( meuForm.getAltura() ) );
		} else {
			po.setAltura( null );
		}

		if ( meuForm.getPeso() != null && !meuForm.getPeso().isEmpty() ) {
			po.setPeso( Utilidades.parseBigDecimal( meuForm.getPeso() ) );
		} else {
			po.setPeso( null );
		}

		if ( meuForm.getCpf() != null && !meuForm.getCpf().isEmpty() ) {
			po.setCpf( meuForm.getCpf() );
		} else {
			po.setCpf( null );
		}

		if ( meuForm.getDataNascimento() != null && !meuForm.getDataNascimento().isEmpty() ) {
			po.setDataNascimento( Utilidades.parseDate( meuForm.getDataNascimento() ) );
		} else {
			po.setDataNascimento( null );
		}

		if ( meuForm.getNome() != null && !meuForm.getNome().isEmpty() ) {
			po.setNome( meuForm.getNome() );
		} else {
			po.setNome( null );
		}

		if ( meuForm.getRa() != null && !meuForm.getRa().isEmpty() ) {
			po.setRa( meuForm.getRa() );
		} else {
			po.setRa( null );
		}

		if ( meuForm.getSexo() != null && !meuForm.getSexo().isEmpty() ) {
			po.setSexo( meuForm.getSexo() );
		} else {
			po.setSexo( null );
		}

		if ( meuForm.getTurma() != null && !meuForm.getTurma().isEmpty() ) {
			po.setTurma( meuForm.getTurma() );
		} else {
			po.setTurma( null );
		}

		po.setEndereco( meuForm.getLogradouro(), meuForm.getNumero(), meuForm.getBairro(), meuForm.getCidade(), meuForm.getCep(), meuForm.getUf() );

		return po;
	}

}
