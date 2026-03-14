package com.oz.db.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import com.oz.domain.Reserva;

public interface ReservaRepository {
	void salvar(Reserva reserva);

	// Útil para preencher a tabela/lista na interface gráfica
	List<Reserva> buscarPorData(LocalDate data);

	// Método chave para o Service validar se a área está ocupada
	boolean existeConflito(Long areaId, LocalDate data, LocalTime inicio, LocalTime fim);

	void excluir(Long id);
}
