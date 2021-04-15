package br.com.gclickapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gclickapi.model.Cliente;
import br.com.gclickapi.model.Email;
import br.com.gclickapi.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	public List<Cliente> getAll() {
		return service.getAll();
	}
	
	@PostMapping
	public Cliente save(@RequestBody Cliente client) {
		return service.save(client);
	}
	
	@GetMapping(path = "/{id}")
	public Cliente findById(@PathVariable(name = "id") Long id) {
		return service.findById(id).get();
	}
	
	@PutMapping(path = "/{id}")
	public Cliente update(@PathVariable(name = "id") Long id,
						  @RequestBody Cliente client) {
		return service.update(id, client );
	}
	
	@PostMapping(path = "/{id}/email")
	public Email addMail(@PathVariable(name = "id") Long id, @RequestBody Email mail) {
		return service.addEmail(id ,mail );
	}
	
	@DeleteMapping(path = "email/{idMail}")
	public void removeEmail( @PathVariable(name = "idMail") Long idMail) {
		service.removeMail(idMail);
	}
	
	@GetMapping(path = "/{id}/email")
	public List<Email> findEmailByClient(@PathVariable(name = "id") Long id){
		return service.findEmailsByClient(id);
	}
}
