package com.fastacademy.jpa;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/FastAcademy")
class FuncionarioController {

  private final RepositorioFuncionario repositorio;

  FuncionarioController(RepositorioFuncionario repository) {
    this.repositorio = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/funcionarios")
  List<Funcionario> all() {
    return repositorio.findAll();
  }
  // end::get-aggregate-root[]

  
  /* JSON Exemplo
   * {
    "nome": "Nome do Funcionário",
    "funcao": "Função do Funcionário"
 }   */

  @PostMapping("/funcionarios")
  Funcionario novoFuncionario(@RequestBody Funcionario novoFuncionario) {
    return repositorio.save(novoFuncionario);
  }

  // Single item
  
  @GetMapping("/funcionarios/{id}")
  Funcionario one(@PathVariable Long id) {
    
    return repositorio.findById(id)
      .orElseThrow(() -> new ExecessaoFuncionarioNaoEncontrado(id));
  }

  @PutMapping("/funcionarios/{id}")
  Funcionario alteraFuncionario(@RequestBody Funcionario novoFuncionario, @PathVariable Long id) {
    
    return repositorio.findById(id)
      .map(funcionario -> {
        funcionario.setNome(novoFuncionario.getNome());
        funcionario.setFuncao(novoFuncionario.getFuncao());
        return repositorio.save(funcionario);
      })
      .orElseGet(() -> {
        novoFuncionario.setId(id);
        return repositorio.save(novoFuncionario);
      });
  }

  @DeleteMapping("/funcionarios/{id}")
  void excluirFuncionario(@PathVariable Long id) {
    repositorio.deleteById(id);
  }
}
