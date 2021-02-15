package com.tinnova.cadastroVeiculos.repository.service;

import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class VeiculoService {

    public Calendar dataSemana(){
        Calendar dataSemana = Calendar.getInstance();
        dataSemana.add(Calendar.DAY_OF_MONTH, -7);
        return dataSemana;
    }
}
