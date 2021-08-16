package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import model.domain.Cliente;
import model.domain.Usuario;

public class Banco {
	
	private static List<Cliente> lista = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static List<Cliente> listaClientes = new ArrayList<>();
	
	private static Integer chaveSequencial = 1;

	static {
		Cliente cliente = new Cliente();
		cliente.setId(chaveSequencial++);
		cliente.setNome("Rodrigo Rocha");
		cliente.setDataNascimento(new Date());
		cliente.setCpf("229.765.088-97");
		cliente.setScore(900);
		cliente.setStatus(true);
		cliente.setEmail("rodrigo@gmail.com");
		cliente.setSenha("123");
		Usuario u1 = new Usuario();
		u1.setEmail("rodrigo@gmail.com");
		u1.setSenha("123");
		lista.add(cliente);	
		listaUsuarios.add(u1);		
		
//		Cliente cliente2 = new Cliente();
//		cliente2.setId(chaveSequencial++);
//		cliente2.setNome("Priscila");
//		cliente2.setDataNascimento(new Date());
//		cliente2.setCpf("229.650.099-96");
//		cliente2.setScore(998);
//		cliente2.setStatus(false);			
//		Usuario u2 = new Usuario();
//		u2.setEmail("priscila@gmail.com");
//		u2.setSenha("*Fatec123");
//		lista.add(cliente2);
//		listaUsuarios.add(u2);
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


	public Usuario validaCredenciais(String email, String senha) {
		for (Usuario usuario : listaUsuarios) {
			if (usuario.autentica(email, senha)) {
				return usuario;
			}
		}
		return null;
	}
	
}
