package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Agencia;

public interface IAgenciaService {

	Agencia buscarPorId(Long id);

	List<Agencia> buscarTodos();

	void salvar(Agencia editora);

	void excluir(Long id);
	
	boolean editoraTemPacotes(Long id);
}
