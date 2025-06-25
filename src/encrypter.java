import java.math.BigInteger;
import java.util.Random;

public class encrypter {
    protected long p, q, n, ti, d;
    long e = 7;

    Random rand = new Random();

    public encrypter(){
        p = 26893;//randomPrime();
        q = 26633;//randomPrime();
        n = p * q;
        ti = (p-1) * (q -1);
        System.out.println("p = "+p);
        System.out.println("q = "+q);
        System.out.println("n = "+n);
        System.out.println("ti = "+ti);
        d = modInverse(e,ti);
        System.out.println("d = "+d);
    }

    long randomPrime(){
        long num = rand.nextLong(2,100000);
        while(primeFinder(num)){
            num = rand.nextLong(2,100000);
        }
        return num;
    }

    boolean primeFinder(long n){
        for(int i = 2;i<Math.sqrt(n);i++){
            if(n % i == 0){
                return true;
            }
        }
        return false;
    }

    private static long modInverse(long e, long lambdaN) {
        long[] result = extendedGCD(e, lambdaN);
        long gcd = result[0];
        long x = result[1];
        if (gcd != 1) {
            System.out.println("Modular inverse does not exist; e and λ(n) are not coprime.");
            return (x % lambdaN + lambdaN) % lambdaN;
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

    public long modPow(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % mod;
            exp = exp >> 1;
            base = (base * base) % mod;
        }
        return result;
    }


    public long encrypt(long m){
        return modPow(m,e,n);
    }
}
