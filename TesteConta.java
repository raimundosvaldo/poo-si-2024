package pacote1;

public class TesteConta {
	
	public static void main(String[] args) {
		
		Cliente cl1 = new Cliente("123", "Osvaldo");
		Cliente cl2 = new Cliente("567", "Angelo");
		
		Conta c1 = new Conta(1, cl1, 200.0, 123);
		Conta c2 = new Conta(2, cl2, 150.0, 345);
		
		System.out.println(c1.verificaSaldo(123));
		c1.creditaValor(1000, "Deposito");
		System.out.println(c1.verificaSaldo(123));
		c1.debitaValor(850, 123, "Pix");
		System.out.println(c1.verificaSaldo(123));
		
		System.out.println(c1);
		
		Cliente p = new Cliente("123", "noemda pessoa");
		System.out.println(p.toString());
		
	}

}
