package model.domain;

public class Usuario extends EntidadeDominio{

    private String email;
    private String senha;
    private Boolean status;

    public Usuario(String email, String senha) {
    	this.email = email;
    	this.senha = senha;    	
    }
    
    public Usuario(String email, String senha, Boolean status) {
    	this.email = email;
    	this.senha = senha;    	
    	this.status = status;
    }
    
    public Usuario(Integer id,String email, String senha) {
    	super();
    	this.setId(id);
    	this.email = email;
    	this.senha = senha;    	
    }
    
    public Usuario(){    	
    }
    
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
    
    public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
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
