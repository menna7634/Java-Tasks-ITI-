
public class Complex<T extends Number> {

    private T real;
    private T imaginary;

    public Complex(T real, T imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public T getReal() {
        return real;
    }

    public T getImaginary() {
        return imaginary;
    }


    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }
}