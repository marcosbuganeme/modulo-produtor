package br.com.oobj.arquitetura.bundle;

import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 * <b>Título:</b> ResourceBundleArquiteturaFactory.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe abstrata responsável por prover uma fábrica de criação para <code>ResourceBundle</code>, dizendo para o bundle de onde serão obtidas as mensagens.
 * </p>
 *
 * Data de criação: 21/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public abstract class ResourceBundleArquiteturaFactory {

	/** Constante LOG. */
	private static Log LOG = LogFactory.getLog(ResourceBundleArquiteturaFactory.class);

	/**
	 * Método responsável por criar o <code>ResourceBundle</code> para a aplicação.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i><code>ResourceBundle</code> da aplicação</i>.
	 */
	public abstract ResourceBundle getResourceBundle();

	/**
	 * Método responsável por obter <code>ResourceBundle</code> da aplicação apartir do factory parametrizado.
	 *
	 * @author marcosbuganeme
	 *
	 * @param factoryClass
	 *            - classe que irá prover o <code>ResourceBundle</code>.
	 * 
	 * @return <i><code>ResourceBundle</code> para a aplicação</i>.
	 */
	public static ResourceBundle getBundle(final Class<? extends ResourceBundleArquiteturaFactory> factoryClass) throws ResourceBundleFactoryException {

		try {

			return factoryClass.newInstance().getResourceBundle();

		} catch (final Throwable exception) {

			if (exception instanceof ResourceBundleFactoryException) {

				ResourceBundleArquiteturaFactory.LOG.error("Erro na instanciação do resourceBundle :: " + exception.getMessage(), exception);
			}

			ResourceBundleArquiteturaFactory.LOG.error("Erro na classe ResourceBundleArquiteturaFactory :: " + exception.getMessage(), exception);
		}

		return null;
	}

}
