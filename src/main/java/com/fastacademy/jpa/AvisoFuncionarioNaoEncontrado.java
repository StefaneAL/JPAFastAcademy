
package com.fastacademy.jpa;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class AvisoFuncionarioNaoEncontrado {

  @ResponseBody
  @ExceptionHandler(ExecessaoFuncionarioNaoEncontrado.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String employeeNotFoundHandler(ExecessaoFuncionarioNaoEncontrado ex) {
    return ex.getMessage();
  }
}
