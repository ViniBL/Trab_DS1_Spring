package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufscar.dc.dsw.domain.Pacote_adquirido;
import br.ufscar.dc.dsw.domain.Usuario;

@SuppressWarnings("unchecked")
public interface IPacote_adquiridoDAO extends CrudRepository<Pacote_adquirido, Long>{

	Pacote_adquirido findById(long id);

	List<Pacote_adquirido> findAllByUsuario(Usuario u);
	
	Pacote_adquirido save(Pacote_adquirido Pacote_adquirido);

	@Query("UPDATE Pacote_adquirido SET status = 'CANCELADO' WHERE id = :id")
	public void cancelaPacote(@Param("id") Long id);
}