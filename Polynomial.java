import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Polynomial {
	double [] coefficients;
	int [] exponents;

	public Polynomial() {
		coefficients = new double[1];
		coefficients[0] = 0;
		exponents = new int[1];
		exponents[0] = 0;
	}
	public Polynomial(double [] c) {
		coefficients = new double[c.length];
		exponents = new int[c.length];
		for (int i = 0; i < coefficients.length; i++)
		{
			coefficients[i] = c[i];
			exponents[i] = i;
		}
	}
	public Polynomial(double [] c, int[] e) {
		coefficients = new double[c.length];
		exponents = new int[e.length]; //c.length and e.length should be the same
		for (int i = 0; i < c.length; i++) {
			coefficients[i] = c[i];
			exponents[i] = e[i];
		}
	}
	public Polynomial(List<Double> c, List<Integer> e) {
		coefficients = new double[c.size()];
		exponents = new int[e.size()];
		for (int i = 0; i < c.size(); i++) {
			coefficients[i] = c.get(i);
			exponents[i] = e.get(i);
		}
	}

	private String dealWithNegatives(String s) {
		List<Character> o = new ArrayList<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '-') o.add(' ');
			o.add(c);
		}

		String r = new String();
		for (char c : o)
			r += c;
		return r;
	}

	public Polynomial(File f) {
		try (Scanner input = new Scanner(f)) {
			String main = input.nextLine();

			//create the lists
			List<Double> c = new ArrayList<Double>();
			List<Integer> e = new ArrayList<Integer>();

			//build the lists
			for (String strings : main.split("\\+")) {
				if (strings.contains("-"))
					strings = dealWithNegatives(strings);

				for (String s : strings.split(" ")) {
					String [] ss = s.split("x");
					c.add(Double.parseDouble(ss[0]));

					if (ss.length > 1) e.add(Integer.parseInt(ss[1]));
					else e.add(0); //constants
				}
			}

			//convert lists to arrays and build Polynomial
			coefficients = new double[c.size()];
			exponents = new int[e.size()];
			for (int i = 0; i < c.size(); i++) {
				coefficients[i] = c.get(i);
				exponents[i] = e.get(i);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Polynomial add(Polynomial p) {
		//create the lists
		List<Double> c = new ArrayList<Double>();
		List<Integer> e = new ArrayList<Integer>();

		//build the lists
		Boolean found = false;
		for (int i = 0; i < exponents.length; i++) {
			found = false;

			for (int j = 0; j < p.coefficients.length; j++) {
				if (exponents[i] == p.exponents[j]) {
					found = true;
					if (coefficients[i] + p.coefficients[j] != 0) {
						c.add(coefficients[i] + p.coefficients[j]);
						e.add(exponents[i]);
					}

				}
			}
			if (!found) {
				c.add(coefficients[i]);
				e.add(exponents[i]);
			}
		}
		for (int i = 0; i < p.coefficients.length; i++) {
			found = false;
			if (!e.contains(p.exponents[i])) {
				for (int j = 0; j < coefficients.length; j++) {
					if (p.exponents[i] == exponents[j]) {
						found = true;
						if (p.coefficients[i] + coefficients[j] != 0) {
							c.add(p.coefficients[i] + coefficients[j]);
							e.add(p.exponents[i]);
						}
					}
				}
				if (!found) {
					c.add(p.coefficients[i]);
					e.add(p.exponents[i]);
				}
			}

		}

		return new Polynomial(c, e);
	}

	public Polynomial multiply(Polynomial p) {
		//create the lists
		List<Double> c = new ArrayList<Double>();
		List<Integer> e = new ArrayList<Integer>();

		//build the lists
		for (int i = 0; i < coefficients.length; i++) {
			for (int j = 0; j < p.coefficients.length; j++) {
				if (e.contains(exponents[i] + p.exponents[j])) {
					int k = e.indexOf(exponents[i] + p.exponents[j]);
					c.set(k, coefficients[i] * p.coefficients[j] + c.get(k));
				}
				else {
					c.add(coefficients[i] * p.coefficients[j]);
					e.add(exponents[i] + p.exponents[j]);
				}
			}
		}

		return new Polynomial(c, e);
	}

	public double evaluate(double x) {
		double result = 0;
		for (int i = 0; i < coefficients.length; i++)
			result += coefficients[i] * Math.pow(x, exponents[i]);
		return result;
	}

	public Boolean hasRoot(double x) {
		return evaluate(x) == 0;
	}

	public void display() {
		for (int i = 0; i < coefficients.length; i++)
			System.out.print(coefficients[i] + "x" + exponents[i] + " ");
		System.out.print("\n");
	}
}