package br.edu.positivo.sistemaweb.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.edu.positivo.sistemaweb.entity.Cliente;
import br.edu.positivo.sistemaweb.service.ClienteService;

@SuppressWarnings("deprecation")
@ManagedBean(name="mbeanLogin")
@RequestScoped
public class MBeanLogin {

	private String email;
	private String senha;
	
	@EJB
	private ClienteService service;
	
	public String login() {
		//realizar a chamada para o service e procurar o cliente por login/senha
		
		Cliente cliente = new Cliente();
		cliente.setLogin(email);
		cliente.setNome(senha);
		
		if (service.validar(cliente)) {
			//redirecionar para última página
			ExternalContext externalContext = FacesContext.
					getCurrentInstance().getExternalContext();
			((HttpServletRequest)externalContext.getRequest()).
				getSession().setAttribute("cliente", cliente);
		}
						
		return "index.jsf";
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

}
