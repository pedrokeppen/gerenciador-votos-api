package com.teste.sicredi.gerenciador.votos.api.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.teste.sicredi.gerenciador.votos.api.dto.ResultadoVotacaoDTO;
import com.teste.sicredi.gerenciador.votos.api.dto.VotacaoDTO;
import com.teste.sicredi.gerenciador.votos.api.dto.VotoDTO;
import com.teste.sicredi.gerenciador.votos.api.enums.StatusVotacao;
import com.teste.sicredi.gerenciador.votos.api.enums.VotoEnum;
import com.teste.sicredi.gerenciador.votos.api.exceptiohandler.exceptions.NotFoundException;
import com.teste.sicredi.gerenciador.votos.api.exceptiohandler.exceptions.UnauthorizedException;
import com.teste.sicredi.gerenciador.votos.api.model.Pauta;
import com.teste.sicredi.gerenciador.votos.api.model.Votacao;
import com.teste.sicredi.gerenciador.votos.api.model.Voto;
import com.teste.sicredi.gerenciador.votos.api.repository.VotacaoRepository;
import com.teste.sicredi.gerenciador.votos.api.repository.VotoRepository;
import com.teste.sicredi.gerenciador.votos.api.service.PautaService;
import com.teste.sicredi.gerenciador.votos.api.service.VotacaoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VotacaoServiceImpl implements VotacaoService {
	
	private final VotacaoRepository repository;
	private final VotoRepository votoRepository;
	private final PautaService pautaService;
	
	public Votacao abrir(VotacaoDTO dto) {
		
		verificarVotacaoAbertaPorPauta(dto);

		Pauta pauta = this.pautaService.findById(dto.getPauta().getId());
		
		LocalDateTime dataFim = null;
		
		if(dto.getDuracaoMinutos() != null && dto.getDuracaoMinutos() > 0L) {
			dataFim = LocalDateTime.now().plusMinutes(dto.getDuracaoMinutos());
		}else {
			dataFim = LocalDateTime.now().plusMinutes(1);
		}
		
		Votacao votacao = Votacao.builder()
				.pauta(pauta)
				.dataInicio(LocalDateTime.now())
				.dataFim(dataFim)
				.status(StatusVotacao.ABERTA)
				.build();
		
		return this.repository.save(votacao);			

	}

	private void verificarVotacaoAbertaPorPauta(VotacaoDTO dto) {
		Optional<Votacao> votacao = this.repository.findVotacaoByPautaId(dto.getPauta().getId());
		
		if(votacao.isPresent() && votacao.get().getStatus().equals(StatusVotacao.ABERTA)) {
			throw new UnauthorizedException("Essa pauta já está em uma votação aberta!");
		}
	}

	@Override
	public boolean isVotacaoValidaAberta(Votacao votacao) {
		
		if(votacao.getDataFim().isBefore(LocalDateTime.now()) || votacao.getDataFim().isEqual(LocalDateTime.now())) {
			votacao.setStatus(StatusVotacao.ENCERRADA);
			this.repository.save(votacao);
			return false;
		}
		
		return true;
	}

	@Override
	public Votacao findById(Long idVotacao) {
		
		Optional<Votacao> votacaoOp = this.repository.findById(idVotacao);
		
		if(!votacaoOp.isPresent()) {
			throw new NotFoundException("Nenhuma votação encontrada!");
		}
		
		return votacaoOp.get();
	}

	@Override
	public Voto votar(VotoDTO dto) {
		
		Votacao votacao = findById(dto.getVotacao().getId());
		
		if(!isVotacaoValidaAberta(votacao)) {
			throw new UnauthorizedException("Votação Encerrada!");
		}
		
		verificarVotoJaRealizado(dto, votacao);
		
		Voto voto = Voto.builder()
				.cpf(dto.getCpf())
				.votacao(votacao)
				.voto(dto.getVoto().name())
				.build();
		
		return this.votoRepository.save(voto);
	}

	private void verificarVotoJaRealizado(VotoDTO dto, Votacao votacao) {
		Optional<Voto> votoOp = this.votoRepository.findByCpf(dto.getCpf());
		
		if(votoOp.isPresent()) {
			if(votoOp.get().getVotacao().getId() == votacao.getId()) {
				throw new UnauthorizedException("O mesmo usuário nao pode votar duas vezes!");
			}
		}
	}

	@Override
	public ResultadoVotacaoDTO exibirResultadoVotacao(Long idVotacao) {
		
		Votacao votacao = findById(idVotacao);
		
		int votosSim = this.votoRepository.countVotosByType(idVotacao, VotoEnum.Sim.name());
		int votosNao = this.votoRepository.countVotosByType(idVotacao, VotoEnum.Não.name());
		
		ResultadoVotacaoDTO dto = ResultadoVotacaoDTO.builder()
				.dataInicio(votacao.getDataInicio())
				.dataFim(votacao.getDataFim())
				.idVotacao(idVotacao)
				.idPauta(votacao.getPauta().getId())
				.qtdNao(votosNao)
				.qtdSim(votosSim)
				.tituloPauta(votacao.getPauta().getTitulo())
				.statusVotacao(votacao.getStatus().name())
				.build();
		
		return dto;
	}

	
	
	

}
