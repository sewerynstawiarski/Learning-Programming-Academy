public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }
    public void add(double real, double imaginary) {
      //  return new ComplexNumber((this.real + real), (this.imaginary + imaginary));
        this.real += real;
        this.imaginary += imaginary;
    }
    public void add(ComplexNumber number) {
       // return new ComplexNumber((this.real + number.getReal()), (this.imaginary + number.getImaginary()));
        this.real += number.getReal();
        this.imaginary += number.getImaginary();
    }
    public void subtract (double real, double imaginary) {
      //  return new ComplexNumber((this.real - real) , (this.imaginary - imaginary));
        this.real -= real;
        this.imaginary -= imaginary;
    }
    public void subtract (ComplexNumber number) {
      //  return new ComplexNumber((this.real -  number.getReal()), (this.imaginary - number.getImaginary()));
        this.real -= number.getReal();
        this.imaginary -= number.getImaginary();
    }
}
