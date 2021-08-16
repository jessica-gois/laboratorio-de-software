package testesAutomatizados;

import org.junit.jupiter.api.Test;

import dao.Banco;
import org.junit.*;
import model.domain.Usuario;

public class LoginTeste {

	@Test
	public void validaCredenciais() {
		Banco banco = new Banco();
		Usuario  usuario = banco.validaCredenciais("rodrigo@gmail.com","123");
		Assert.assertEquals(banco.validaCredenciais("rodrigo@gmail.com", "123"), usuario);
	}
}
