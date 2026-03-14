package com.oz.db.repository;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import com.oz.domain.RegraFuncionamento;

public interface RegraRepository {
	// Busca a regra específica para validar uma reserva
	Optional<RegraFuncionamento> buscarRegra(Long areaId, DayOfWeek diaSemana);

	// Lista todas as regras de uma área para o zelador editar
	List<RegraFuncionamento> listarRegrasPorArea(Long areaId);

	void atualizarRegra(RegraFuncionamento regra);
}
