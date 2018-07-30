package br.com.cursojava.studentsystem.sistema.backend.bicibleta.controller.teste;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.junit.Test;

import br.com.cursojava.studentsystem.exceptions.ApplicationException;
import br.com.cursojava.studentsystem.sistema.backend.bicibleta.controller.BicicletaFACADE;
import br.com.cursojava.studentsystem.sistema.backend.bicibleta.model.BicicletaPO;

public class TestaBackend{

	@Test
	public void executar() {
		try {
			BicicletaPO po = new BicicletaPO();
			po.setCor( "Azul" );
			po.setDataFabricacao( new Date() );
			po.setId( Long.valueOf( "1" ) );
			po.setMarca( "Shimano" );
			po.setMarcha( true );
			po.setMaterial( "Alumínio" );
			po.setModalidade( "Montain" );
			po.setPreco( new BigDecimal( "1590.50" ) );

			BicicletaFACADE facade = new BicicletaFACADE();
			facade.inserir( po );

			po.setCor( "Rosa" );
			facade.alterar( po );

			facade.excluir( po );

			BicicletaPO encontrado = facade.filtrarPorId( po.getId() );
			System.out.println( "Filtrado por Id: " + encontrado );

			List encontrados = facade.filtrarTodos();
			System.out.println( "Todos que foram filtrados: " + encontrados );

			encontrados = facade.filtrar( po );
			System.out.println( "Filtrado po objeto: " + encontrados );
			
		} catch ( ApplicationException e ) {
			e.printStackTrace();
			JOptionPane.showMessageDialog( null, e.getMessage() );
			
		} catch ( Exception e ) {
			e.printStackTrace();
			JOptionPane.showMessageDialog( null, e.getMessage() );
		
			
		}
		

	}

}
