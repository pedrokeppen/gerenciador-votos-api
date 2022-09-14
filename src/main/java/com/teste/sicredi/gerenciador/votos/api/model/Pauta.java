package com.teste.sicredi.gerenciador.votos.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table(name = "TB_PAUTA")
@Entity
@AllArgsConstructor
public class Pauta {
	
	private Pauta() {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_PAUTA")
	private Long id;
	
	@Column(name = "TITULO", nullable = false)
	private String titulo;
	
	@Column(name = "DSC_PAUTA", nullable = false)
	private String descricao;
}
