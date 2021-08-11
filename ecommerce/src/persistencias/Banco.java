package persistencias;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import entidades.Cliente;

public class Banco {
	
	private static List<Cliente> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;


	public void adiciona(Cliente cliente) {
		cliente.setId(Banco.chaveSequencial++);
		Banco.lista.add(cliente);
	}
	
	public List<Cliente> getClientes(){
		return Banco.lista;
	}

	public void removeCliente(Integer id) {
		
		Iterator<Cliente> it = lista.iterator();
		
		while(it.hasNext()) {
			Cliente emp = it.next();
			
			if(emp.getId() == id) {
				it.remove();
			}
		}
	}

	public Cliente buscaClientePeloId(Integer id) {
		for (Cliente cliente : lista) {
			if(cliente.getId() == id) {
				return cliente;
			}
		}
		return null;
	}

}
