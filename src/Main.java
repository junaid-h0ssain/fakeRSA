import java.math.BigInteger;
public class Main {
    public static void main(String[] args) {
        nmaker n = new nmaker();

        int m = 69;
        BigInteger cipher = BigInteger.valueOf((long) Math.pow(m,n.e));
//        System.out.println(n.getD());
        System.out.println(cipher);
        System.out.println( n.answer(cipher, BigInteger.valueOf(m)));



    }
}