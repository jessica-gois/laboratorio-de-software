 $(document).ready(function() {
	  $("#formConfirmacaoSenha").validate({
	    rules: {
	      senha : {
	        required: true
	      },
	      confirmacaoSenha: {
	        required: true,
	        equalTo : "#senha"
	      }
	    },
	    messages : {
	      senha: {
	        required: "Por favor, informe sua senha"
	      },
	      confirmacaoSenha: {
	        required: "Por favor, confirme sua senha",
	        equalTo : "A senha e a confirmação não conferem"
	      }
	    }
	  });
	});