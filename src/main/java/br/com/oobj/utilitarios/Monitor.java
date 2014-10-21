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
public class Monitor implements Runnable {

	/** Constante LOG. */
	private static final Log LOG = LogFactory.getLog(Monitor.class);

	/** Constante DEZ_SEGUNDOS. */
	private static final int DEZ_SEGUNDOS = 10 * 1000;

	/** Constante DIRETORIO. */
	private static final String DIRETORIO_SCANEADO = "C:\\oobj";

	/** Constante EXTENSAO_ARQUIVO. */
	private static final String EXTENSAO_ARQUIVO = ".xml";

	/** Atributo threadMonitor. */
	private Thread threadMonitor;

	/** Atributo diretorio. */
	private String diretorio;

	/**
	 * Método responsável por iniciar a varredura no diretório.
	 *
	 * @author marcosbuganeme
	 *
	 */
	public void inicializarVarredura() {

		this.setDiretorio(Monitor.DIRETORIO_SCANEADO);

		this.threadMonitor = new Thread(this);

		this.threadMonitor.start();
	}

	/**
	 * Método responsável por ficar monitorando uma pasta pré definida, buscando por arquivos cuja extensão seja .xml
	 *
	 * @author marcosbuganeme
	 *
	 * @param diretorioMonitorado
	 */
	private void monitorarPasta(final String diretorioMonitorado) {

		final File diretorio = new File(diretorioMonitorado);

		final File arquivos[] = diretorio.listFiles(new FileFilter() {

			@Override
			public boolean accept(final File pathname) {

				return pathname.getName().toLowerCase().endsWith(Monitor.EXTENSAO_ARQUIVO);
			}
		});

		for (int i = 0; i < arquivos.length; i++) {

			final File file = arquivos[i];

			this.imprimeNomeArquivoConsole(file.getName());
		}
	}

	/**
	 * Método responsável por imprimir o nome do arquivo na console, caso este exista.
	 *
	 * @author marcosbuganeme
	 *
	 * @param nomeArquivo
	 *            - nome do arquivo que será impresso na console.
	 */
	private void imprimeNomeArquivoConsole(final String nomeArquivo) {

		Monitor.LOG.info("Arquivo encontrado. Nome ::: " + nomeArquivo);
	}

	@Override
	public void run() {

		final Thread currentThread = Thread.currentThread();

		while (this.threadMonitor == currentThread) {

			this.monitorarPasta(this.getDiretorio());

			try {

				Thread.sleep(Monitor.DEZ_SEGUNDOS);

			} catch (final InterruptedException e) {

				Monitor.LOG.error("ERROR NA CLASSE " + this.getClass().getSimpleName() + " ::: " + e.getCause());
			}
		}
	}

	/**
	 * Retorna o valor do atributo <code>diretorio</code>
	 *
	 * @return <code>String</code>
	 */
	private String getDiretorio() {

		return this.diretorio;
	}

	/**
	 * Define o valor do atributo <code>diretorio</code>.
	 *
	 * @param diretorio
	 */
	private void setDiretorio(final String diretorio) {

		this.diretorio = diretorio;
	}

}
