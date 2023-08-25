package app;

import java.util.List;

import dao.XDAO;
import model.X;

public class Aplicacao {
	
	public static void main(String[] args) throws Exception {
		
		XDAO xDAO = new XDAO();
		
		System.out.println("\n\n==== Inserir x === ");
		X x= new X(2, "pablo");
		if(xDAO.insert(x) == true) {
			System.out.println("Inserção com sucesso -> " + x.toString());
		}

		System.out.println("\n\n==== Atualizar nome (id (" + x.getId() + ") === ");
		x.setNome("pablo");
		xDAO.update(x);		

		System.out.println("\n\n==== Mostrar x ordenado por id === ");
		List<X> xs = xDAO.getOrderById();
		for (X xx: xs) {
			System.out.println(xx.toString());
		}
		
		System.out.println("\n\n==== Excluir x (id " + x.getId() + ") === ");
		xDAO.delete(x.getId());
		
		System.out.println("\n\n==== Mostrar x ordenado por nome === ");
		xs = xDAO.getOrderByNome();
		for (X xx: xs) {
			System.out.println(xx.toString());
		}
	}
}