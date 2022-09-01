package main.java.br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Destino;
import br.ufscar.dc.dsw.domain.Usuario;

@SuppressWarnings("unchecked")
public interface IDestinoDAO extends CrudRepository<Destino, Long>{

	Destino findById(long id);

	List<Destino> findAllByUsuario(Usuario u);
	
	Destino save(Destino Destino);
}