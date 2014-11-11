package br.com.oobj.main.teste;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * <b>Título:</b> Pedido.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b>
 * </p>
 *
 * Data de criação: 21/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class Pedido implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 156761298267512312L;

	/** Atributo cliente. */
	private Cliente cliente;

	/** Atributo valorUnitario. */
	private BigDecimal valorUnitario;

	/** Atributo quantidade. */
	private int quantidade;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public Pedido() {

	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param cliente
	 * 
	 * @param valorUnitario
	 * 
	 * @param quantidade
	 */
	public Pedido( final Cliente cliente, final BigDecimal valorUnitario, final int quantidade ) {

		this.cliente = cliente;

		this.valorUnitario = valorUnitario;

		this.quantidade = quantidade;
	}

	/**
	 * Retorna o valor do atributo <code>cliente</code>
	 *
	 * @return <code>Cliente</code>
	 */
	public Cliente getCliente() {

		return this.cliente;
	}

	/**
	 * Define o valor do atributo <code>cliente</code>.
	 *
	 * @param cliente
	 */
	public void setCliente(final Cliente cliente) {

		this.cliente = cliente;
	}

	/**
	 * Retorna o valor do atributo <code>valorUnitario</code>
	 *
	 * @return <code>BigDecimal</code>
	 */
	public BigDecimal getValorUnitario() {

		return this.valorUnitario;
	}

	/**
	 * Define o valor do atributo <code>valorUnitario</code>.
	 *
	 * @param valorUnitario
	 */
	public void setValorUnitario(final BigDecimal valorUnitario) {

		this.valorUnitario = valorUnitario;
	}

	/**
	 * Retorna o valor do atributo <code>quantidade</code>
	 *
	 * @return <code>int</code>
	 */
	public int getQuantidade() {

		return this.quantidade;
	}

	/**
	 * Define o valor do atributo <code>quantidade</code>.
	 *
	 * @param quantidade
	 */
	public void setQuantidade(final int quantidade) {

		this.quantidade = quantidade;
	}

}
