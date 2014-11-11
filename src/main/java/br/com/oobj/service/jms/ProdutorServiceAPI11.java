package br.com.oobj.service.jms;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.oobj.arquitetura.ProdutorServiceFacade;
import br.com.oobj.main.teste.Cliente;
import br.com.oobj.utilitarios.UtilMonitoramento;

import com.thoughtworks.xstream.XStream;

@Stateless
public class ProdutorServiceAPI11 implements ProdutorServiceFacade {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 2912881478670669593L;

	/** Constante LOG. */
	private static final Log LOG = LogFactory.getLog(ProdutorServiceAPI11.class);

	/** Atributo utilMonitoramento. */
	@Inject
	private UtilMonitoramento utilMonitoramento;

	/** Atributo connectionFactory. */
	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	/** Atributo destination. */
	@Resource(mappedName = "jms/topic/oobjTopico")
	private Destination destination;

	/** Atributo connection. */
	private Connection connection;

	/** Atributo session. */
	private Session session;

	/** Atributo messageProducer. */
	private MessageProducer messageProducer;

	/** Atributo stream. */
	final XStream stream = new XStream();

	/** Atributo cliente. */
	private Cliente cliente;

	/**
	 * Método responsável por inicializar o setup de configuração para produção de mensagens.
	 *
	 * @author marcosbuganeme
	 *
	 */
	@PostConstruct
	public void init() {

		try {

			this.connection = this.connectionFactory.createConnection();

			this.session = this.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			this.messageProducer = this.session.createProducer(this.destination);

		} catch (final JMSException e) {

			ProdutorServiceAPI11.LOG.error("Erro ao construir a setup inicial da API JMS 1.1", e);

			throw new RuntimeException("Mensagem do erro ::: " + e.getMessage() + " Causa do erro ::: " + e.getCause());
		}
	}

	/**
	 * Método responsável por finalizar a conexão aberta.
	 *
	 * @author marcosbuganeme
	 *
	 */
	@PreDestroy
	public void destroy() {

		if (this.connection != null) {

			try {

				this.connection.close();

			} catch (final JMSException e) {

				ProdutorServiceAPI11.LOG.error("Erro ao fechar a conexão JMS");

				throw new RuntimeException();
			}
		}
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.oobj.arquitetura.ProdutorServiceFacade#enviarMensagem()
	 */
	@Override
	public void enviarMensagem() {

		try {

			if (this.isExisteArquivo()) {

				for (final File arquivo : this.utilMonitoramento.getArquivosExistentes()) {
					
					this.cliente = (Cliente) this.stream.fromXML(arquivo);
				}

				this.messageProducer.send((Message) this.cliente);
			}

		} catch (final JMSException e) {

			ProdutorServiceAPI11.LOG.warn("ERRO no envio da mensagem JMS API 1.1 !!");

			ProdutorServiceAPI11.LOG.warn("Mensagem do ERRO ::: " + e.getMessage());

			ProdutorServiceAPI11.LOG.warn("Causa do ERRO ::: " + e.getCause());
		}
	}

	/**
	 * Método responsável por verifica se existe arquivos no diretório.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>True, existe arquivos no diretório</i>.
	 */
	public boolean isExisteArquivo() {

		if (this.utilMonitoramento.getArquivosExistentes() != null) {

			return true;
		}

		return false;
	}
}
