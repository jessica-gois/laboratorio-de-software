	const msgCampoObrigatorio = "Campo obrigatório"

		$(document).ready(function() {
			$("#formCadastroCliente").validate({
				rules : {
					email : {
						required : true,
						email : true
					},
					senha : {
						required : true,
						minlength : 8
					},
					confirmacaoSenha : {
						required : true,
						equalTo : "#senha"
					},
					nome : {
						required : true
					},
					sobrenome : {
						required : true
					},
					genero : {
						required : true
					},
					dddResidencial : {
						required : true
					},
					numeroTelResidencial : {
						required : true
					},
					dataNascimento : {
						required : true
					},
					cpf : {
						required : true
					},
					tipoLogradouro : {
						required : true
					},
					logradouro : {
						required : true
					},
					tipoResidencia : {
						required : true
					},
					numeroEndereco : {
						required : true
					},
					bairro : {
						required : true
					},
					cep : {
						required : true
					},
					estado : {
						required : true
					},
					cidade : {
						required : true
					},
					descricaoEndereco : {
						required : true
					}
				},
				messages : {
					email : {
						required : "Por favor, informe seu e-mail",
						email : "Por favor, informe um e-mail válido"
					},
					senha : {
						required : "Por favor, informe sua senha",
						minlength : "A senha precisa ter no mínimo 8 dígitos"
					},
					confirmacaoSenha : {
						required : "Por favor, confirme sua senha",
						equalTo : "A senha e a confirmação não conferem"
					},
					nome : {
						required : msgCampoObrigatorio
					},
					sobrenome : {
						required : msgCampoObrigatorio
					},
					genero : {
						required : msgCampoObrigatorio
					},
					dddResidencial : {
						required : msgCampoObrigatorio
					},
					numeroTelResidencial : {
						required : msgCampoObrigatorio
					},
					dataNascimento : {
						required : msgCampoObrigatorio
					},
					cpf : {
						required : msgCampoObrigatorio
					},
					tipoLogradouro : {
						required : msgCampoObrigatorio
					},
					logradouro : {
						required : msgCampoObrigatorio
					},
					tipoResidencia : {
						required : msgCampoObrigatorio
					},
					numeroEndereco : {
						required : msgCampoObrigatorio
					},
					bairro : {
						required : msgCampoObrigatorio
					},
					cep : {
						required : msgCampoObrigatorio
					},
					estado : {
						required : msgCampoObrigatorio
					},
					cidade : {
						required : msgCampoObrigatorio
					},
					descricaoEndereco : {
						required : msgCampoObrigatorio
					}
					
				}
			});
		});