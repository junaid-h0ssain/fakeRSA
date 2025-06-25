public class decrypter extends encrypter{

    public decrypter(long cipher){
        System.out.println("Decrypted message : "+ decrypt(cipher));
    }
    public long decrypt(long c){
        return modPow(c,d,n);
    }
}
