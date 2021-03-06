package br.com.oobj.utilitarios;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 * <p>
 * <b>Título:</b> UtilitarioJSF.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por prover funções utilitárias para manipulação dos dados da camada de visão com o frameWork JSF.
 * </p>
 *
 * Data de criação: 23/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public final class UtilitarioJSF implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -7078284550447961938L;

	/**
	 * Método responsável por exibir uma mensagem de acordo com a severidade repassada.
	 *
	 * @author marcosbuganeme
	 *
	 * @param mensagem
	 *            - corpo da mensagem que será exibida na tela.
	 * 
	 * @param severidade
	 *            - gravidade da mensagem que será exibida.
	 */
	private static void exibirMensagemJSF(final String mensagem, final Severity severidade) {

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severidade, mensagem, mensagem));
	}

	/**
	 * Método responsável por adicionar uma mensagem do tipo INFO na tela do usuário.
	 *
	 * @author marcosbuganeme
	 *
	 * @param mensagem
	 *            - INFO que será exibida na tela do usuário.
	 */
	public static void addMensagemInfo(final String mensagem) {

		UtilitarioJSF.exibirMensagemJSF(mensagem, FacesMessage.SEVERITY_INFO);
	}

	/**
	 * Método responsável por adicionar uma mensagem do tipo ERROR na tela do usuário.
	 *
	 * @author marcosbuganeme
	 *
	 * @param mensagem
	 *            - ERROR que será exibida na tela do usuário.
	 */
	public static void addMensagemError(final String mensagem) {

		UtilitarioJSF.exibirMensagemJSF(mensagem, FacesMessage.SEVERITY_ERROR);
	}

}
