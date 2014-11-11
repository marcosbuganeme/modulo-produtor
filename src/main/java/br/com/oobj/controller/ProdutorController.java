package br.com.oobj.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.oobj.arquitetura.ProdutorServiceFacade;
import br.com.oobj.arquitetura.controller.Controlador;
import br.com.oobj.arquitetura.qualificador.ApiJMS2;
import br.com.oobj.utilitarios.UtilMonitoramento;
import br.com.oobj.utilitarios.UtilitarioJSF;

/**
 * <p>
 * <b>Título:</b> ProdutorController.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por pelas regra de tela do ECDU - Produzir Mensagens JMS.
 * </p>
 *
 * Data de criação: 21/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@Named
@ViewScoped
public class ProdutorController extends Controlador {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 6542226933611702931L;

	/** Constante LOG. */
	private static final Log LOG = LogFactory.getLog(ProdutorController.class);

	/** Constante ARQUIVO_ENVIAR_SUCESSO. */
	private static final String ARQUIVO_ENVIAR_SUCESSO = "arquivo.enviar.sucesso";

	/** Constante ARQUIVO_ENVIAR_FALHA. */
	private static final String ARQUIVO_ENVIAR_FALHA = "arquivo.enviar.falha";

	/** Atributo service. */
	@ApiJMS2
	@Inject
	private ProdutorServiceFacade serviceFacade;

	/** Atributo arquivo. */
	private Part arquivo;

	/**
	 * Método responsável por realizar o upload de arquivos.
	 *
	 * @author marcosbuganeme
	 *
	 */
	public void fazerUpload() {

		final String nomeArquivoSaida = UtilMonitoramento.DIRETORIO_SCANEADO + this.arquivo.getSubmittedFileName();

		try (InputStream is = this.arquivo.getInputStream(); OutputStream out = new FileOutputStream(nomeArquivoSaida)) {

			int read = 0;

			final byte[] bytes = new byte[1024];

			while (( read = is.read(bytes) ) != -1) {

				out.write(bytes, 0, read);
			}

			UtilitarioJSF.addMensagemInfo(this.getMessage(ProdutorController.ARQUIVO_ENVIAR_SUCESSO));

		} catch (final IOException e) {

			ProdutorController.LOG.error("Motivo do erro ::: " + e.getMessage());

			UtilitarioJSF.addMensagemError(this.getMessage(ProdutorController.ARQUIVO_ENVIAR_FALHA));
		}
	}

	/**
	 * Retorna o valor do atributo <code>arquivo</code>
	 *
	 * @return <code>Part</code>
	 */
	public Part getArquivo() {

		return this.arquivo;
	}

	/**
	 * Define o valor do atributo <code>arquivo</code>.
	 *
	 * @param arquivo
	 */
	public void setArquivo(final Part arquivo) {

		this.arquivo = arquivo;
	}

}
