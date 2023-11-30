package projetoloja;

public class Product {
	private String name;
	private double cost;
	
	public Product(String name,double cost) {
		this.name = name;
		this.cost = cost;
		
	}
	public String getname(){
		return name;
	}
	public double getcost() {
		return cost;
	}
}
