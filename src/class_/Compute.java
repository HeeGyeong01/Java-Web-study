package class_;

public class Compute {
    int x, y, sum, sub, mul;
    double div;

    public void setData(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void calc() {
        this.sum = x + y;
        this.sub = x - y;
        this.mul = x * y;
        this.div = (double) x / y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSum() {
        return sum;
    }

    public int getSub() {
        return sub;
    }

    public int getMul() {
        return mul;
    }

    public String getDiv() {
        return String.format("%.2f", div);
    }


}
