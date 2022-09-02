package br.ufscar.dc.dsw.service.impl;

import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.IPacote_adquiridoDAO;
import br.ufscar.dc.dsw.domain.Pacote_adquirido;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.service.spec.IPacote_adquiridoService;

@Service
@Transactional(readOnly = false)
public class Pacote_adquiridoService implements IPacote_adquiridoService {

	@Autowired
	IPacote_adquiridoDAO dao;
	
	public void salvar(Pacote_adquirido compra) {
		dao.save(compra);
	}

	public boolean cancelarPacote(Pacote_adquirido pa){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataPartida = pa.getPacote().getData_partida();
		LocalDate dataAtual = LocalDate.now();
		LocalDate dp = LocalDate.parse(dataPartida, formatter);
		dp = dp.plusDays(5);
		if(dp.isAfter(dataAtual)){
			return false;
		 }else{
			dao.cancelaPacote(pa.getId());
			return true;
		 }
	}

	@Transactional(readOnly = true)
	public Pacote_adquirido buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Pacote_adquirido> buscarTodosPorUsuario(Usuario u) {
		return dao.findAllByUsuario(u);
	}
}
