package testesAutomatizados;

import dao.Banco;
import model.domain.Usuario;

public class LoginTeste {

	public static void main(String[] args) {
		Banco banco = new Banco();
		Usuario  usuario = banco.validaCredenciais("rodrigo@gmail.com","123");
		
		if(usuario != null) {
	           System.out.println("Usu�rio existe no sistema");
	        }else {
	        	System.out.println("Usu�rio n�o existe no sistema ");
	        }
		}			
	}

