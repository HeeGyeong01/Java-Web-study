package class__;

public class Fruit {
    private String pum;
    private int jan, feb, mar, total;
    private static int sumJan, sumFeb, sumMar;

    public Fruit(String pum, int jan, int feb, int mar) {
        this.pum = pum;
        this.jan = jan;
        this.feb = feb;
        this.mar = mar;
    }

    public void calcTot(){
        this.total = jan + feb + mar;
        Fruit.sumJan += jan;
        Fruit.sumFeb += feb;
        Fruit.sumMar += mar;
    }

    public void display(){
        System.out.printf("%s%6d%6d%6d%6d\n", pum, jan, feb, mar, total);

    }

    public static void output(){
        System.out.printf("%s\t%6d%6d%6d", "합계", sumJan, sumFeb, sumMar);

    }

}
