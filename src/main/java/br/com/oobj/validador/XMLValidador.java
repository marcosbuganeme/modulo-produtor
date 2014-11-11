package br.com.oobj.validador;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

/**
 * <p>
 * <b>Título:</b> XMLValidador.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por validar o tipo de arquivo enviado pelo ator do sistema.
 * </p>
 *
 * Data de criação: 23/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@FacesConverter("br.com.oobj.validarTipoArquivo")
public class XMLValidador implements Validator {

	/** Constante ARQUIVO_INVALIDO. */
	private static final String ARQUIVO_INVALIDO = "Este arquivo não é um .xml";

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see javax.faces.validator.Validator#validate(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public void validate(final FacesContext context, final UIComponent component, final Object value) throws ValidatorException {

		final Part arquivo = (Part) value;

		if (arquivo != null && !"application/xml".equals(arquivo.getContentType())) {

			final FacesMessage fm = new FacesMessage(XMLValidador.ARQUIVO_INVALIDO);

			throw new ValidatorException(fm);
		}
	}

}
