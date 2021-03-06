package br.com.oobj.arquitetura.bundle;

import java.util.ResourceBundle;

/**
 * <p>
 * <b>Título:</b> ResourceBundleArquitetura.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar a origem do <code>ResourceBundle</code> da aplicação.
 * </p>
 *
 * Data de criação: 21/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class ResourceBundleArquitetura extends ResourceBundleArquiteturaFactory {

	/** Constante NOME_ARQUIVO_RESOURCE_BUNDLE. */
	public static final String NOME_ARQUIVO_RESOURCE_BUNDLE = "br.com.oobj.messages";

	/** Atributo singleton. */
	private static ResourceBundleArquitetura singleton;

	/** Atributo bundle. */
	private ResourceBundle bundle;

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.coffeework.visao.bundle.ResourceBundleArquiteturaFactory#getResourceBundle()
	 */
	@Override
	public ResourceBundle getResourceBundle() {

		if (this.bundle == null) {

			this.bundle = ResourceBundle.getBundle(ResourceBundleArquitetura.NOME_ARQUIVO_RESOURCE_BUNDLE);
		}

		return this.bundle;
	}

	/**
	 * Retorna o valor do atributo <code>singleton</code>
	 *
	 * @return <code>ResourceBundleArquitetura</code>
	 */
	public static ResourceBundleArquitetura getInstance() {

		if (ResourceBundleArquitetura.singleton == null) {

			ResourceBundleArquitetura.singleton = new ResourceBundleArquitetura();
		}

		return ResourceBundleArquitetura.singleton;
	}

}
