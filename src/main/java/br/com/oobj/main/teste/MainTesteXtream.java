package br.com.oobj.main.teste;

import br.com.oobj.utilitarios.UtilMonitoramento;

public class MainTesteXtream {

	public static void main(final String[] args) {

		UtilMonitoramento util = new UtilMonitoramento();
		
		util.inicializarVarredura();
	}
}
		
//		final XStream stream = new XStream();
//
//		final Cliente cliente = new Cliente("marcos olavo silva buganeme", "marcos.after@gmail.com");
//		final Pedido pedido = new Pedido(cliente, new BigDecimal(1000.00), 5);
//		final Pedido pedido2 = new Pedido(cliente, new BigDecimal(2500.00), 3);
//
//		final Collection<Pedido> colecaoPedidos = new ArrayList<Pedido>();
//
//		colecaoPedidos.add(pedido);
//		colecaoPedidos.add(pedido2);
//
//		cliente.setColecaoPedidos(colecaoPedidos);
//
//		final String contatosEmXML = stream.toXML(cliente);
//
//		System.out.println("\nContatos em XML:");
//		System.out.println(contatosEmXML);
//
//		final Cliente novoCliente = (Cliente) stream.fromXML(contatosEmXML);
//
//		System.out.println(novoCliente.getNome());
//
//		for (final Pedido ped : novoCliente.getColecaoPedidos()) {
//			System.out.println(ped.getCliente().getEmail());
//			System.out.println(ped.getQuantidade());
//			System.out.println(ped.getValorUnitario());
//		}
//	}
//}
