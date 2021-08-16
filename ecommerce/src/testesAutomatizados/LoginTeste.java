package testesAutomatizados;

import dao.Banco;
import model.domain.Usuario;

public class LoginTeste {

	public static void main(String[] args) {
		Banco banco = new Banco();
		Usuario  usuario = banco.validaCredenciais("rodrigo@gmail.com","123");
		
		if(usuario != null) {
	           System.out.println("Usuário existe no sistema");
	        }else {
	        	System.out.println("Usuário não existe no sistema ");
	        }
		}			
	}

