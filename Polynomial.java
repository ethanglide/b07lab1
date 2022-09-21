public class Polynomial {	
	double [] coefficients;

	public Polynomial() {
		coefficients = new double[1];
		coefficients[0] = 0;
	}
	public Polynomial(double [] c) {
		coefficients = new double[c.length];
		for (int i = 0; i < coefficients.length; i++)
			coefficients[i] = c[i];
	}

	public Polynomial add(Polynomial p) {
		Polynomial out;
		if (coefficients.length < p.coefficients.length) {
			out = new Polynomial(new double[p.coefficients.length]);
			
			int i = 0;
			while (i < coefficients.length) {
				out.coefficients[i] = coefficients[i] + p.coefficients[i];
				i++;
			}
			while (i < p.coefficients.length) {
				out.coefficients[i] = p.coefficients[i];
				i++;
			}
		}
		else {
			out = new Polynomial(new double[coefficients.length]);

			int i = 0;
			while (i < p.coefficients.length) {
				out.coefficients[i] = coefficients[i] + p.coefficients[i];
				i++;
			}
			while (i < coefficients.length) {
				out.coefficients[i] = coefficients[i];
				i++;
			}
		}
		
		return out;
	}

	public double evaluate(double x) {
		double result = 0;
		for (int i = 0; i < coefficients.length; i++)
			result += coefficients[i] * Math.pow(x, i);
		return result;
	}

	public Boolean hasRoot(double x) {
		return evaluate(x) == 0;
	}
}