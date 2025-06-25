import java.util.Random;

public class encrypter {
    long p, q, n, ti, d;
    long e = 65537;

    Random rand = new Random();

    public encrypter(){
        System.out.println(randomPrime());
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
}
