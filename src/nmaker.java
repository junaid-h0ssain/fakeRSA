import java.math.BigInteger;
import java.util.Random;

public class nmaker {
    Random random = new Random();

    private long p;
    private long q;
    public BigInteger n;
    private long ti;
    public long e = 65537;
    private long d ;

    public nmaker(){
        do {
            this.p = primeagain();
            this.q = primeagain();
        } while (isprime(this.p) || isprime(this.q));

        this.n= BigInteger.valueOf(this.p * this.q);

        System.out.println(this.p);
        System.out.println(this.q);
        System.out.println("the value of n : "+ this.n);
        totient();
        this.d = modInverse(this.e,this.ti);
    }

    private boolean isprime(long num){
        for(int i=2;i<Math.sqrt(num);i++){
            if(num % i == 0){
                return true;
            }
        }
        return false;
    }

    private long primeagain(){
        return  random.nextInt(1000000,1000000000);
    }

    private static long gcd(long a, long b) {
        while (b > 0)
        {
            long temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    private static long modInverse(long e, long lambdaN) {
        long[] result = extendedGCD(e, lambdaN);
        long gcd = result[0];
        long x = result[1];
        if (gcd != 1) {
            throw new ArithmeticException("Modular inverse does not exist; e and λ(n) are not coprime.");
        } else {
            // Ensure positive result
            return (x % lambdaN + lambdaN) % lambdaN;
        }
    }

    // Extended Euclidean Algorithm: returns [gcd, x, y] such that ax + by = gcd(a, b)
    private static long[] extendedGCD(long a, long b) {
        if (b == 0) {
            return new long[] {Math.toIntExact(a), 1, 0 };
        } else {
            long[] result = extendedGCD(b, a % b);
            int gcd = Math.toIntExact(result[0]);
            int x1 = Math.toIntExact(result[1]);
            long y1 = result[2];
            long x = y1;
            long y = x1 - (a / b) * y1;
            return new long[] { gcd, x, y };
        }
    }


    private static long lcm(long a, long b) {
        return ((a * b) / gcd(a, b));
    }

    private void totient(){
        this.ti = lcm(this.p-1,this.q-1);
        System.out.println(this.p);
        System.out.println(this.q);
        System.out.println(this.ti);
    }

    public BigInteger answer(BigInteger c,BigInteger m){
        c = BigInteger.TEN.modPow(BigInteger.valueOf(this.d),this.n);
        System.out.println(c);

        BigInteger a = this.n.mod(m);
        return a;
    }

}
