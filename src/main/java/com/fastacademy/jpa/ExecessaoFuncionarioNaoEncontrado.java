package com.fastacademy.jpa;

class ExecessaoFuncionarioNaoEncontrado extends RuntimeException {

	private static final long serialVersionUID = 1L;

	ExecessaoFuncionarioNaoEncontrado(Long id) {
	    super("Não foi possível encontrar o funcionário: " + id);
	}
}
