package br.com.gclickapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.gclickapi.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente,Long >{

}
