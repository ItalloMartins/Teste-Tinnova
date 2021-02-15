package com.tinnova.cadastroVeiculos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.Date;

@Entity
@Getter
@Setter
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Campo não pode ser nulo")
    private String veiculo;

    @NotNull(message = "Campo não pode ser nulo")
    private String marca;

    @Min(value = 1900)
    @Max(value = 2022)
    @NotNull(message = "Campo não pode ser nulo")
    private Integer ano;

    @NotNull(message = "Campo não pode ser nulo")
    private String descricao;

    private boolean vendido;

    private Calendar created = Calendar.getInstance();

    private Calendar updated;

}
