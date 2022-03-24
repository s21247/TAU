public class Prism {
    private int a;
    private int b;
    private int c;

    public Prism(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Prism() {
    }

    public int volume (int a, int b, int c) throws ArithmeticException{
        if(a < 0 || b < 0 || c<0)
            throw new ArithmeticException();
        return a*b*c;
    }

    public int field(int a,int b,int c) throws ArithmeticException{
        if(a < 0 || b < 0 || c<0)
            throw new ArithmeticException();
        return 2*(a*b) + 2*(a*c) + 2*(b*c);
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
