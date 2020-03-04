package cn.qingjiu.yys.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import java.security.Security;

public class DesUtil {
    private static final String Algorithm = "DESede"; //定义加密算法
    public static final String CIPHER_ALGORITHM = "DESede/CBC/PKCS5Padding";
    //public static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
    public static final String IV = "00000000";

    public static byte[] desCrypto(byte[] src, String password) {
        try {

            DESedeKeySpec deskey = new DESedeKeySpec(password.getBytes());
            SecretKeyFactory skf = SecretKeyFactory.getInstance(Algorithm);
            Key key = skf.generateSecret(deskey);
            Cipher cipher1 = Cipher.getInstance(CIPHER_ALGORITHM);
            IvParameterSpec iv = new IvParameterSpec(IV.getBytes());
            cipher1.init(Cipher.ENCRYPT_MODE, key,iv);

            return cipher1.doFinal(src);//在单一方面的加密或解密

        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     * @param src
     * @param password
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] src, String password) {
        try {
            DESedeKeySpec deskey = new DESedeKeySpec(password.getBytes());
            SecretKeyFactory skf = SecretKeyFactory.getInstance(Algorithm);
            Key key = skf.generateSecret(deskey);
            Cipher cipher1 = Cipher.getInstance(CIPHER_ALGORITHM);
            IvParameterSpec iv = new IvParameterSpec(IV.getBytes());
            cipher1.init(Cipher.DECRYPT_MODE, key,iv);
            return cipher1.doFinal(src);
        } catch (java.security.NoSuchAlgorithmException e1) {
            // TODO: handle exception
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    //转换成十六进制字符串
    public static String byte2Hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
            if (n < b.length - 1)
                hs = hs + ":";
        }
        return hs.toUpperCase();
    }

    //十六进制字符串转换成整形数组
    public static byte[] hex2byte(String hex) {
        int arrayLenth = hex.length() / 2;
        byte[] inputByteArray = new byte[arrayLenth];
        for (int x = 0; x < arrayLenth; x++)
        {
            int beginIndex = x * 2;
            int  endIndex = beginIndex +2;
            int coventInt = Integer.valueOf(hex.substring(beginIndex,endIndex),16);
            inputByteArray[x] = (byte)coventInt;
        }

        return inputByteArray;

    }
    public static String util_decrypt(String encodString){
        String  password = "0123456789abcd9876543210";
        byte[] srcBytes = decrypt(hex2byte(encodString),password);
        return new String(srcBytes);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //添加新安全算法,如果用JCE就要把它添加进去
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        String password="ZmE0NWZlNDMyZDQ5NDNjNmI4ZWFiOWE0";
       //String szSrc = "37231dcf2bc2cf202f47b419c1cfb9fce1c14d2e86a93b6d1012fefff90c6ea6719a311e7c4e3e757fe98426226148d75eadbade59e6e440f8459beac47be790";
        //String szSrc = "{\"cn\":\"xiongjun\",\"sn\":\"xiongjun\",\"__tick\":1395929492055}";
        String szSrc = "{\"synjones.pay.valiteqrcode\":{\"barcode\":\"44464696695499478235\"}}";
        System.out.println("加密前的字符串:" + szSrc);
        byte[] encoded = desCrypto(szSrc.getBytes(),password);
        System.out.println("加密后的字符串:" + byte2Hex(encoded));
        //byte[] srcBytes = decrypt(hex2byte(szSrc),password);
        byte[] srcBytes = decrypt(encoded,password);
        System.out.println("解密后的字符串:" + new String(srcBytes));
        System.out.println(Base64Decoder.encode(srcBytes));
        //SignatureUtil.sign(,"ZmE0NWZlNDMyZDQ5NDNjNmI4ZWFiOWE0".getBytes(),"SHA1withRSA");

        System.out.println(password.length());
    }
}
