package br.com.oobj.utilitarios;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import com.thoughtworks.xstream.XStream;

public class PrincipalXtream {

	public static void main(final String[] args) {

		final XStream stream = new XStream();

		final Cliente cliente = new Cliente("marcos olavo silva buganeme", "marcos.after@gmail.com");
		final Pedido pedido = new Pedido(cliente, new BigDecimal(1000.00), 5);
		final Pedido pedido2 = new Pedido(cliente, new BigDecimal(2500.00), 3);

		final Collection<Pedido> colecaoPedidos = new ArrayList<Pedido>();

		colecaoPedidos.add(pedido);
		colecaoPedidos.add(pedido2);

		cliente.setColecaoPedidos(colecaoPedidos);

		final String contatosEmXML = stream.toXML(cliente);

		System.out.println("\nContatos em XML:");
		System.out.println(contatosEmXML);

		final Cliente novoCliente = (Cliente) stream.fromXML(contatosEmXML);

		System.out.println(novoCliente.getNome());

		for (final Pedido ped : novoCliente.getColecaoPedidos()) {
			System.out.println(ped.getCliente().getEmail());
			System.out.println(ped.getQuantidade());
			System.out.println(ped.getValorUnitario());
		}
	}
}
