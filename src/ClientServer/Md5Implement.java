package ClientServer;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Implement {
    String password="bill";
    MessageDigest md;
    public void run() {
        {
            try {
                md = MessageDigest.getInstance("MD5");
                md.update(password.getBytes());
                byte[] digest = md.digest();
                String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
                System.out.println(myHash);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Md5Implement m5 =new Md5Implement();
        m5.run();
    }
}
