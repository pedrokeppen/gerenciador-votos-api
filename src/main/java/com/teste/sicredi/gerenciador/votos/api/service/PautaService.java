package com.teste.sicredi.gerenciador.votos.api.service;

import java.util.List;

import com.teste.sicredi.gerenciador.votos.api.dto.PautaDTO;
import com.teste.sicredi.gerenciador.votos.api.model.Pauta;

public interface PautaService {

	Pauta salvar(PautaDTO dto);
	
	List<Pauta> listarTodas();
}
