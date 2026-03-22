package com.oz.domain;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Objects;

public class RegraFuncionamento {
    private final Long areaId;
    private final DayOfWeek dia;
    private final boolean permitido;
    private final LocalTime horarioLimite;

    public RegraFuncionamento(Long areaId, DayOfWeek dia, boolean permitido, LocalTime horarioLimite) {
        this.areaId = areaId;
        this.dia = Objects.requireNonNull(dia, "dia");
        this.permitido = permitido;
        this.horarioLimite = horarioLimite;
        if (permitido && horarioLimite == null) {
            throw new IllegalArgumentException("É preciso ter um horário limite e informar se é permitido");
        }
    }

    public Long getAreaId() {
        return areaId;
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
}
