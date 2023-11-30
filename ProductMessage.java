package projetoloja;

public class ProductMessage extends Product{

	public ProductMessage(String name, double cost) {
		super(name, cost);
	}
	public void MessageAlert() {
		System.out.println("\nProduto Encontrado no nosso banco de dados!!");
		System.out.println("Product:"+getname());
		System.out.println("Cost:"+getcost()+ "R$\n");
	}
	

}
