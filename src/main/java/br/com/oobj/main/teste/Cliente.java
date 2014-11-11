package br.com.oobj.main.teste;

import java.io.Serializable;
import java.util.Collection;

/**
 * <p>
 * <b>Título:</b> Cliente.java
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
public class Cliente implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -6527518278160015011L;

	/** Atributo nome. */
	private String nome;

	/** Atributo email. */
	private String email;

	/** Atributo colecaoPedidos. */
	private Collection<Pedido> colecaoPedidos;

	public Cliente() {

	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param nome
	 * 
	 * @param email
	 */
	public Cliente( final String nome, final String email ) {

		this.nome = nome;

		this.email = email;
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param nome
	 * 
	 * @param email
	 * 
	 * @param colecaoPedidos
	 */
	public Cliente( final String nome, final String email, final Collection<Pedido> colecaoPedidos ) {

		this.nome = nome;

		this.email = email;

		this.colecaoPedidos = colecaoPedidos;
	}

	/**
	 * Retorna o valor do atributo <code>nome</code>
	 *
	 * @return <code>String</code>
	 */
	public String getNome() {

		return this.nome;
	}

	/**
	 * Define o valor do atributo <code>nome</code>.
	 *
	 * @param nome
	 */
	public void setNome(final String nome) {

		this.nome = nome;
	}

	/**
	 * Retorna o valor do atributo <code>email</code>
	 *
	 * @return <code>String</code>
	 */
	public String getEmail() {

		return this.email;
	}

	/**
	 * Define o valor do atributo <code>email</code>.
	 *
	 * @param email
	 */
	public void setEmail(final String email) {

		this.email = email;
	}

	/**
	 * Retorna o valor do atributo <code>colecaoPedidos</code>
	 *
	 * @return <code>Collection<Pedido></code>
	 */
	public Collection<Pedido> getColecaoPedidos() {

		return this.colecaoPedidos;
	}

	/**
	 * Define o valor do atributo <code>colecaoPedidos</code>.
	 *
	 * @param colecaoPedidos
	 */
	public void setColecaoPedidos(final Collection<Pedido> colecaoPedidos) {

		this.colecaoPedidos = colecaoPedidos;
	}

}
