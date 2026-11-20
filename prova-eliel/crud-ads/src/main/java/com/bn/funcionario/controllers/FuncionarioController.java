package com.bn.funcionario.controllers;

import com.bn.funcionario.models.FuncionarioModel;
import com.bn.funcionario.services.FuncionarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioServices funcionarioServices;

    @GetMapping
    public List<FuncionarioModel> findAll() {
        return funcionarioServices.findAll();
    }

    @GetMapping("/{id}")
    public FuncionarioModel buscarPorId(@PathVariable Long id) {
        return funcionarioServices.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FuncionarioModel criarFuncionario(@RequestBody FuncionarioModel funcionarioModel) {
        return funcionarioServices.criarPessoa(funcionarioModel);
    }

    @PutMapping("/{id}")
    public FuncionarioModel atualizar(@PathVariable Long id, @RequestBody FuncionarioModel funcionarioModel) {
        return funcionarioServices.atualizar(id, funcionarioModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        funcionarioServices.deletar(id);
    }
}
