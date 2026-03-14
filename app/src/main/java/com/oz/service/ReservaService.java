package com.oz.service;

import java.time.LocalDate;
import java.util.List;
import com.oz.domain.Reserva;
import com.oz.domain.exception.RegraNegocioException;

public interface ReservaService {
	/**
	 * @throws RegraNegocioException caso a reserva fira alguma regra de horário ou dia.
	 */
	void agendar(Reserva reserva) throws RegraNegocioException;

	List<Reserva> listarReservasPorData(LocalDate data);

	void cancelarReserva(Long id);
}
