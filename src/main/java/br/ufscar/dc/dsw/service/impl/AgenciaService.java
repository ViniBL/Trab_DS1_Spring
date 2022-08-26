package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.IEditoraDAO;
import br.ufscar.dc.dsw.domain.Agencia;
import br.ufscar.dc.dsw.service.spec.IEditoraService;

@Service
@Transactional(readOnly = false)
public class EditoraService implements IEditoraService {

	@Autowired
	IEditoraDAO dao;
	
	public void salvar(Agencia editora) {
		dao.save(editora);
	}

	public void excluir(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Agencia buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Agencia> buscarTodos() {
		return dao.findAll();
	}
	
	@Transactional(readOnly = true)
	public boolean editoraTemLivros(Long id) {
		return !dao.findById(id.longValue()).getLivros().isEmpty(); 
	}
}
