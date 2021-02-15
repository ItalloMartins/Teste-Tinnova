package com.tinnova.cadastroVeiculos.repository;

import com.tinnova.cadastroVeiculos.model.Veiculo;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;


@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    //Retorna quantidade de veículos em determinado ano
    Integer countByAnoBetween(Integer ano, Integer ano2);

    //Retornar quantidade de veículos não vendido
    long countByVendidoFalse();

    //Retorna por marca
    long countByMarca(String marca);

    //Retorna semana
    List<Veiculo> findByCreatedBetween(Calendar dataSemana, Calendar dataAtual);
}
