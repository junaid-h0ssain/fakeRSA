import java.lang.reflect.Member;

public class Main {
    public static void main(String[] args) {
        encrypter lock = new encrypter();
        long m = 1234;

        System.out.println("Encrypted message : " + lock.encrypt(m));

        decrypter key = new decrypter(lock.encrypt(m));
    }
}