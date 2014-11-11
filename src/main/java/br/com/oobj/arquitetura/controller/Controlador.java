package br.com.oobj.arquitetura.controller;

import java.io.Serializable;
import java.util.ResourceBundle;

import br.com.oobj.arquitetura.bundle.ResourceBundleArquitetura;
import br.com.oobj.arquitetura.bundle.ResourceBundleArquiteturaFactory;

/**
 * <p>
 * <b>Título:</b> Controlador.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe abstrata responsável por prover algumas funções de controle de fluxo de dados.
 * </p>
 *
 * Data de criação: 21/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public abstract class Controlador implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 2142603910987460447L;

	/**
	 * Método responsável por inicializar os dados do controlador.
	 *
	 * @author marcosbuganeme
	 *
	 */
	public void iniciarDados() {

		
	}

	/**
	 * Método responsável por retornar a mensagem vinculada a chave passada como parâmetro.
	 * 
	 * @author marcosbuganeme
	 * 
	 * @param keyMessage
	 *            - Chave da mensagem.
	 * 
	 * @return <i>mensagem a ser exibida na tela</i>.
	 */
	public String getMessage(final String keyMessage) {

		return this.getBundle().getString(keyMessage);
	}

	/**
	 * Retorna o valor do atributo bundle.
	 * 
	 * @return <code>ResourceBundle</code> Arquivo de mensagens da arquitetura.
	 */
	protected ResourceBundle getBundle() {

		return ResourceBundleArquiteturaFactory.getBundle(this.getResourceBundleFactory());
	}

	/**
	 * Obtem o ResourceBundleFactory para o controlador
	 * 
	 * @return ResourceBundleFactory para o controlador
	 * 
	 * @see ResourceBundleArquiteturaFactory
	 */
	public Class<? extends ResourceBundleArquiteturaFactory> getResourceBundleFactory() {

		return ResourceBundleArquitetura.class;
	}
}
