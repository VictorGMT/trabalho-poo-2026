package com.oz.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Reserva {
    private final AreaComum area;
    private final String nomeMorador;
    private final String ap;
    private final LocalDate data;
    private final LocalTime inicio;
    private final LocalTime fim;

    public Reserva(AreaComum area, String nomeMorador, String ap, LocalDate data, LocalTime inicio, LocalTime fim) {
            this.area = Objects.requireNonNull(area, "area");
            this.nomeMorador = Objects.requireNonNull(nomeMorador, "nomeMorador");
            this.ap = Objects.requireNonNull(ap, "ap");
            this.data = Objects.requireNonNull(data, "data");
            this.inicio = Objects.requireNonNull(inicio, "inicio");
            this.fim = Objects.requireNonNull(fim, "fim");
            if (this.inicio.equals(this.fim)) {
                throw new IllegalArgumentException("inicio e fim nao podem ser iguais");
            }
    }

    public AreaComum getArea() {
        return area;
    }

    public String getNomeMorador() {
        return nomeMorador;
    }

    public String getAp() {
        return ap;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public LocalTime getFim() {
        return fim;
    }
}

