package br.com.caelum.loja.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = false)
public class SalvaLivroException extends RuntimeException{

}
