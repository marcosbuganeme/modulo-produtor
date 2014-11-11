package br.com.oobj.service.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Message;
import javax.jms.Topic;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import br.com.oobj.arquitetura.ProdutorServiceFacade;

/**
 * <p>
 * <b>Título:</b> Produtor.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar o envio de mensagem via arquitetura JMS.
 * </p>
 *
 * Data de criação: 23/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
@Stateless
public class ProdutorServiceAPI20 implements ProdutorServiceFacade {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1469878638686521209L;

	/** Atributo jmsContext. */
	@Inject
	private JMSContext jmsContext;

	/** Atributo topico. */
	@Resource(lookup = "jms/topic/oobjTopico")
	private Topic topico;

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.oobj.arquitetura.ProdutorServiceFacade#enviarMensagem()
	 */
	@Path("/oobj/produtor")
	@GET
	@Override
	public void enviarMensagem() {

		this.jmsContext.createProducer().send(this.topico, (Message) new Object());
	}
}
