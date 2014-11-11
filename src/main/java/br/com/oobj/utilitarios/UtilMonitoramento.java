package br.com.oobj.utilitarios;

import java.io.File;
import java.io.FileFilter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 * <b>Título:</b> Monitor.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Utilitário responsável por monitorar uma determinado diretório em busca de arquivos pré definidos.
 * </p>
 *
 * Data de criação: 21/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class UtilMonitoramento implements Runnable {

	/** Constante LOG. */
	private static final Log LOG = LogFactory.getLog(UtilMonitoramento.class);

	/** Constante DEZ_SEGUNDOS. */
	private static final int DEZ_SEGUNDOS = 10 * 1000;

	/** Constante DIRETORIO. */
	public static final String DIRETORIO_SCANEADO = "C:\\oobj";

	/** Constante EXTENSAO_ARQUIVO. */
	private static final String EXTENSAO_ARQUIVO = ".xml";

	/** Atributo threadMonitoramento. */
	private Thread threadMonitoramento;

	/** Atributo arquivosExistentes. */
	private File[] arquivosExistentes;

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		while (this.threadMonitoramento == Thread.currentThread()) {

			this.arquivosExistentes = this.monitorarPasta(UtilMonitoramento.DIRETORIO_SCANEADO);

			try {

				Thread.sleep(UtilMonitoramento.DEZ_SEGUNDOS);

			} catch (final InterruptedException e) {

				UtilMonitoramento.LOG.error("ERROR NA CLASSE " + this.getClass().getSimpleName() + " ::: " + e.getCause());
			}
		}
	}

	/**
	 * Método responsável por iniciar a varredura no diretório.
	 *
	 * @author marcosbuganeme
	 *
	 */
	public void inicializarVarredura() {

		this.threadMonitoramento = new Thread(this);

		this.threadMonitoramento.start();
	}

	/**
	 * Método responsável por ficar monitorando uma pasta pré definida, buscando por arquivos cuja extensão seja .xml
	 *
	 * @author marcosbuganeme
	 *
	 * @param diretorioMonitorado
	 */
	public File[] monitorarPasta(final String diretorioMonitorado) {

		final File diretorio = new File(diretorioMonitorado);

		final File arquivos[] = diretorio.listFiles(new FileFilter() {

			@Override
			public boolean accept(final File pathname) {

				return pathname.getName().toLowerCase().endsWith(UtilMonitoramento.EXTENSAO_ARQUIVO);
			}
		});

		for (int i = 0; i < arquivos.length; i++) {

			final File file = arquivos[i];

			UtilMonitoramento.LOG.info("Arquivo encontrado. Nome ::: " + file.getName());
		}

		return arquivos;
	}

	/**
	 * Retorna o valor do atributo <code>arquivosExistentes</code>
	 *
	 * @return <code>File[]</code>
	 */
	public File[] getArquivosExistentes() {

		return this.arquivosExistentes;
	}

}
