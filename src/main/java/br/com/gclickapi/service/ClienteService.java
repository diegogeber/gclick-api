package br.com.gclickapi.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gclickapi.model.Cliente;
import br.com.gclickapi.model.Email;
import br.com.gclickapi.repository.ClienteRepository;
import br.com.gclickapi.repository.EmailRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EmailRepository emailRepository;

	public List<Cliente> getAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteRepository.findAll();
	}
	
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id);
	}

	public Cliente update(Long id, Cliente client) {
		
		Optional<Cliente> clientOptional = clienteRepository.findById(id);
		
		if(clientOptional.isPresent()) {
			Cliente update = clientOptional.get();
			BeanUtils.copyProperties(client, update, "id");
			
			return clienteRepository.save(update);
		}else {
			return null;
		}
	}

	public Email addEmail(Long id, Email email) {
		
		Cliente client = clienteRepository.findById(id).isPresent() ?
					clienteRepository.findById(id).get() : null;
		
		email.setCliente(client);
		
		return emailRepository.save(email);
	}

	public void removeMail(Long idMail) {
		
		emailRepository.deleteById(idMail);
	}

	public List<Email> findEmailsByClient(Long id) {
		
		return emailRepository.findByClienteId(id);
	}
	
}
