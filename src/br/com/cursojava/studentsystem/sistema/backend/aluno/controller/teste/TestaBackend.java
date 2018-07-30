package br.com.cursojava.studentsystem.sistema.backend.aluno.controller.teste;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.junit.Test;

import br.com.cursojava.studentsystem.exceptions.ApplicationException;
import br.com.cursojava.studentsystem.sistema.backend.aluno.controller.AlunoFACADE;
import br.com.cursojava.studentsystem.sistema.backend.aluno.model.AlunoPO;

public class TestaBackend{

	@Test
	public void executar() {
		try {

			AlunoPO po = new AlunoPO( "Bruno Yamada", "293.987.345-34", "Turma XXXI Noturno de Seg a Sex" );
			po.setAltura( new BigDecimal( "1.83" ) );
			po.setDataNascimento( new Date() );
			po.setEndereco( "Rua Lauro Zimmerman Filho", "210", "Itamarati", "Ourinhos", "19001030", "SP" );
			po.setId( Long.valueOf( "1" ) );
			po.setPeso( new BigDecimal( "65.2" ) );
			po.setRa( "12345678" );
			po.setSexo( "Masculino" );

			/** Persistindo e Filtrando Aluno */
			AlunoFACADE facade = new AlunoFACADE();
			facade.inserir( po );

			po.setNome( "MAria da Graça" );
			facade.alterar( po );

			facade.excluir( po );

			AlunoPO encontrado = (AlunoPO) facade.filtrarPorId(po.getId() );
			System.out.println( "Por ID: " + encontrado );

			List encontrados = facade.filtrarTodos();
			System.out.println( "Todos: " + encontrados );

			encontrados = facade.filtrar( po );
			System.out.println( "Filtrar: " + encontrados );
			
		}catch ( ApplicationException e ) {
			e.printStackTrace();
			JOptionPane.showMessageDialog( null, e.getMessage() );
			
		} catch ( Exception e ) {
			e.printStackTrace();
			JOptionPane.showMessageDialog( null, e.getMessage() );
		
			
		}

	}

}
