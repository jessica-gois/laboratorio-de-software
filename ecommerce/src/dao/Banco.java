package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import model.domain.Cliente;

public class Banco {
	
	private static List<Cliente> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;

	static {
		Cliente cliente = new Cliente();
		cliente.setId(chaveSequencial++);
		cliente.setNome("Jéssica");
		cliente.setDataNascimento(new Date());
		cliente.setCpf("229.765.088-97");
		cliente.setScore(900);
		cliente.setStatus(true);
		
		Cliente cliente2 = new Cliente();
		cliente2.setId(chaveSequencial++);
		cliente2.setNome("Priscila");
		cliente2.setDataNascimento(new Date());
		cliente2.setCpf("229.650.099-96");
		cliente2.setScore(998);
		cliente2.setStatus(false);		
		
		lista.add(cliente);
		lista.add(cliente2);
	}

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
