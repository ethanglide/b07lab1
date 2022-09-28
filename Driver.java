import java.io.File;
public class Driver {
	public static void main(String [] args) {
		/*Polynomial p = new Polynomial();
		System.out.println(p.evaluate(3));
		double [] c1 = {6,0,0,5};
		Polynomial p1 = new Polynomial(c1);
		double [] c2 = {0,-2,0,0,-9};
		Polynomial p2 = new Polynomial(c2);
		Polynomial s = p1.add(p2);

		s.display();

		System.out.println("s(0.1) = " + s.evaluate(0.1));
		if(s.hasRoot(1))
			System.out.println("1 is a root of s");
		else
			System.out.println("1 is not a root of s");*/

		// double [] c1 = {2, 4, 1, 3, 3};
		// int [] e1 = {3, 2, 4, 0, 5};
		// Polynomial p1 = new Polynomial(c1, e1);
		// p1.display();

		// double [] c2 = {5, 3, -1};
		// int [] e2 = {0, 3, 4};
		// Polynomial p2 = new Polynomial(c2, e2);
		// p2.display();

		// p1.add(p2).display();
		// p2.add(p1).display();
		// System.out.println(p1.add(p2).evaluate(2) + "\n");

		// double [] c1 = {1, 1};
		// int [] e1 = {1, 0};
		// Polynomial p1 = new Polynomial(c1, e1);

		// double [] c2 = {1, -2, 1};
		// int [] e2 = {3, 2, 1};
		// Polynomial p2 = new Polynomial(c2, e2);

		// p1.multiply(p2).display();

		Polynomial p3 = new Polynomial(new File("input.txt"));
		p3.display();
	}
}