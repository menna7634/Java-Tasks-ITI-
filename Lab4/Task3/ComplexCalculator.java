
public class ComplexCalculator {

    
    public static <T extends Number> Complex<Double> add(Complex<T> c1, Complex<T> c2) {
        
        double newReal = c1.getReal().doubleValue() + c2.getReal().doubleValue();
        double newImaginary = c1.getImaginary().doubleValue() + c2.getImaginary().doubleValue();
        return new Complex<>(newReal, newImaginary);
    }


    public static <T extends Number> Complex<Double> subtract(Complex<T> c1, Complex<T> c2) {
        
        double newReal = c1.getReal().doubleValue() - c2.getReal().doubleValue();
        double newImaginary = c1.getImaginary().doubleValue() - c2.getImaginary().doubleValue();
        return new Complex<>(newReal, newImaginary);
    }
    
    
    public static void main(String[] args) {
        
        Complex<Integer> a = new Complex<>(5, 3);    
        Complex<Integer> b = new Complex<>(2, 4);    

        System.out.println("Complex A: " + a);
        System.out.println("Complex B: " + b);
        
        Complex<Double> sum = ComplexCalculator.add(a, b);
        System.out.println("Sum (A + B): " + sum); 
        
        Complex<Double> difference = ComplexCalculator.subtract(a, b);
        System.out.println("Difference (A - B): " + difference); 
        Complex<Double> c = new Complex<>(1.5, 2.5);
        Complex<Double> d = new Complex<>(0.5, 1.5);
        
        Complex<Double> sumDouble = ComplexCalculator.add(c, d);
        System.out.println("Sum (C + D): " + sumDouble); 
    }
}