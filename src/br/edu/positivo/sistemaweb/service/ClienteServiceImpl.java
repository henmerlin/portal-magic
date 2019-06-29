package br.edu.positivo.sistemaweb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.edu.positivo.sistemaweb.entity.Cliente;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED) 
public class ClienteServiceImpl extends BasicService<Cliente> implements ClienteService {


	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listar() {
		return em.createQuery("select c from Cliente c")
				.getResultList();
	}

@Override
public boolean validar(Cliente cliente) {
	Cliente validated = (Cliente) em.createQuery("select c from Cliente c WHERE c.login = :login AND c.senha = : senha")
			.setParameter("login", cliente.getLogin())
			.setParameter("senha", cliente.getSenha())
			.getSingleResult();
	
	return validated != null;
}
	
	
}
