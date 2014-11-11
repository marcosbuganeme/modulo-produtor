package br.com.oobj.arquitetura;

import java.io.Serializable;

/**
 * <p>
 * <b>Título:</b> ProdutorDeMensagem.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface responsável pela arquitetura de produção de mensagens.
 * </p>
 *
 * Data de criação: 23/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public interface ProdutorServiceFacade extends Serializable {

	/**
	 * Método responsável por enviar uma mensagem para ser consumida.
	 *
	 * @author marcosbuganeme
	 * 
	 */
	void enviarMensagem();
}
