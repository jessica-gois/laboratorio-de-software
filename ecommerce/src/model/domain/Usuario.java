package model.domain;

public class Usuario extends EntidadeDominio{

    private String email;
    private String senha;
    private String confirmacaoSenha;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getConfirmacaoSenha() {
        return senha;
    }

    public void setConfirmacaoSenha(String senha) {
        this.senha = senha;
    }

    public boolean autentica(String email, String senha) {
        if(!this.email.equals(email)) {
            return false;
        }

        if(!this.senha.equals(senha)) {
            return false;
        }

        return true;
    }
    
    public boolean autenticaSenha(String senhaInformada, String confirmacaoSenha) {
    	if(senhaInformada == null || confirmacaoSenha == null) {
    		return false;
    	}
    	
    	if(senhaInformada == "" || confirmacaoSenha=="") {
    		return false;
    	}
    	
    	if(!senhaInformada.equals(confirmacaoSenha)) {
    		return false;
    	}
    	
    	if(!senhaInformada.equals(this.getSenha())) {
    		return false;
    	}
    	
    	return true;
    	
    }
   
}
