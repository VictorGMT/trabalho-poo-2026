package com.oz.domain;

import com.oz.domain.exception.RegraNegocioException;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class RegraFuncionamento {
    private final DayOfWeek dia;
    private final boolean permitido;
    private final LocalTime horarioLimite;

    public RegraFuncionamento(DayOfWeek dia, boolean permitido, LocalTime horarioLimite) {
        this.dia = Objects.requireNonNull(dia, "dia");
        this.permitido = permitido;
        this.horarioLimite = horarioLimite;
        if (permitido && horarioLimite == null) {
            throw new IllegalArgumentException("É preciso ter um horário limite e informar se é permitido");
        }
    }

    public DayOfWeek getDia() {
        return dia;
    }

    public boolean isPermitido() {
        return permitido;
    }

    public LocalTime getHorarioLimite() {
        return horarioLimite;
    }

    public void validarReserva(Reserva reserva) throws RegraNegocioException {
        Objects.requireNonNull(reserva, "reserva");
        if (reserva.getData() == null || reserva.getInicio() == null || reserva.getFim() == null) {
            throw new RegraNegocioException("Reserva precisa ter data, inicio e fim");
        }

        DayOfWeek diaReserva = reserva.getData().getDayOfWeek();

        LocalTime limiteTime;
        boolean meioDeSemana = diaReserva == DayOfWeek.TUESDAY && permitido || diaReserva == DayOfWeek.WEDNESDAY && permitido || diaReserva == DayOfWeek.THURSDAY && permitido;

        boolean fimDeSemana = diaReserva == DayOfWeek.FRIDAY && permitido || diaReserva == DayOfWeek.SATURDAY && permitido || diaReserva == DayOfWeek.SUNDAY && permitido;

        if (meioDeSemana) {
            limiteTime = LocalTime.of(getHorarioLimite().getHour(), getHorarioLimite().getMinute());
        } else if (fimDeSemana) {
            limiteTime = LocalTime.of(getHorarioLimite().getHour(), getHorarioLimite().getMinute());
        } else {
            throw new RegraNegocioException("Dia invalido para reserva");
        }

        LocalDateTime inicio = LocalDateTime.of(reserva.getData(), reserva.getInicio());
        LocalDateTime fim = LocalDateTime.of(reserva.getData(), reserva.getFim());


        if (fim.isEqual(inicio)) {
            throw new RegraNegocioException("Fim deve ser depois do inicio");
        }
        if (fim.isBefore(inicio)) {
            fim = fim.plusDays(1);
        }

        LocalDateTime limite = LocalDateTime.of(reserva.getData(), limiteTime);
        if (limiteTime.isBefore(LocalTime.NOON) && reserva.getInicio().isAfter(limiteTime)) {
            limite = limite.plusDays(1);
        }

        if (fim.isAfter(limite)) {
            if (meioDeSemana) {
                throw new RegraNegocioException("o limite de meio de semana e ate 23:00");
            }
            throw new RegraNegocioException("o limite de fim de semana e ate 01:00");
        }

    }
}
