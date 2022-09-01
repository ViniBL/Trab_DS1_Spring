package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Pacote_adquirido;
import br.ufscar.dc.dsw.domain.Usuario;

public interface IPacote_adquiridoService {

	Pacote_adquirido buscarPorId(Long id);

	List<Pacote_adquirido> buscarTodosPorUsuario(Usuario u);
	
	void salvar(Pacote_adquirido pa);
}
