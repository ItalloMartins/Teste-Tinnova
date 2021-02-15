package com.tinnova.cadastroVeiculos.controller;

import com.tinnova.cadastroVeiculos.model.Veiculo;
import com.tinnova.cadastroVeiculos.repository.VeiculoRepository;
import com.tinnova.cadastroVeiculos.repository.service.VeiculoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Api(value = "Cadastro de Veículos API")
@RestController
@RequestMapping({"/veiculos"})
public class VeiculoController {

    private VeiculoRepository veiculoRepository;
    VeiculoController(VeiculoRepository veiculoRepository){
        this.veiculoRepository = veiculoRepository;
    }

    @Autowired
    private VeiculoService service;

    @ApiOperation(value="Retorna os veículos cadastrados na semana")
    @GetMapping(path = {"/ultimaSemana"})
    public List<Veiculo> findBySemana(){
        Calendar dataAtual = Calendar.getInstance();
        Calendar dataSeamana = service.dataSemana();
        return veiculoRepository.findByCreatedBetween(dataSeamana, dataAtual);
    }

    @ApiOperation(value = "Retorna apenas veículos não vendidos, true = vendido")
    @GetMapping(path = {"/vendidos"})
    public long countVeiculoNaoVendido(){
        return veiculoRepository.countByVendidoFalse();
    }

    @ApiOperation(value = "Retorna todos veículos")
    @GetMapping
    public List findAll(){
        return veiculoRepository.findAll();
    }


    @ApiOperation(value = "Retorna os detalhes de cada veículo")
    @GetMapping(path = {"/{id}"})
    Optional<Veiculo> find(@PathVariable Long id){
        return veiculoRepository.findById(id);
    }

    @ApiOperation(value = "Retorna o total de veículos por marca")
    @GetMapping(path = {"/fabricantes/{marca}"})
    public long countByMarca(@PathVariable String marca){
        return veiculoRepository.countByMarca(marca);
    }

    @ApiOperation(value = "Retorna veículo de determinado ano")
    @GetMapping(path = {"/ano/{ano"})
    public Integer countAno(@PathVariable Integer ano){

       return veiculoRepository.countByAnoBetween(2000, 2020);
    }

    @ApiOperation(value = "Cadastra veículo")
    @PostMapping
    public Veiculo create(@RequestBody Veiculo veiculoModel){
        return veiculoRepository.save(veiculoModel);
    }


    @ApiOperation(value = "Atualiza veículo")
    @PutMapping(path = {"/{id}"})
    public ResponseEntity<Veiculo> put(@PathVariable("id") long id, @RequestBody Veiculo veiculo){
        return veiculoRepository.findById(id)
                .map(record ->{
                    record.setVeiculo(veiculo.getVeiculo());
                    record.setAno(veiculo.getAno());
                    record.setDescricao(veiculo.getDescricao());
                    record.setMarca(veiculo.getMarca());
                    record.setVendido(veiculo.isVendido());
                    record.setUpdated(veiculo.getCreated());
                    Veiculo put = veiculoRepository.save(record);
                    return ResponseEntity.ok().body(put);
                }).orElse(ResponseEntity.notFound().build());
    }


    @ApiOperation(value = "Deleta veículo")
    @DeleteMapping(path = {"/{id}"})
    public void delete(@PathVariable Long id){
        veiculoRepository.deleteById(id);
    }
}
