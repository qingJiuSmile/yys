package cn.qingjiu.yys.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public class SHA256 {
   private static Logger logger = LoggerFactory.getLogger(SHA256.class);
  /*  public static void main(String args[]){
        String signString="Thank you!";
        String type="SHA-1";
        String result=sign(signString,type);
        System.out.println("采用"+type+"加密之后的串为："+result);
        type="MD5";
        result=sign(signString,type);
        System.out.println("采用"+type+"加密之后的串为："+result);
        type="SHA-256";
        result=sign(signString,type);
        System.out.println("采用"+type+"加密之后的串为："+result);
        type="SHA-384";
        result=sign(signString,type);
        System.out.println("采用"+type+"加密之后的串为："+result);
    }*/
    //签名
    public static String signSHA256(SortedMap<Object,Object> parameters, String appSecret){
        StringBuffer sb = new StringBuffer();
        StringBuffer sbkey = new StringBuffer();
        Set es = parameters.entrySet();  //所有参与传参的参数按照accsii排序（升序）
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            Object v = entry.getValue();
            //空值不传递，不参与签名组串
            if(null != v && !"".equals(v)) {
                sb.append(k + "=" + v + "&");
                sbkey.append(k + "=" + v + "&");
            }
        }
        //System.out.println("字符串:"+sb.toString());
        String sbStr = sbkey.toString().substring(0,sbkey.length()-1);
        sbStr += appSecret;
        System.out.println("字符串:"+sbStr);
        //SHA256加密
        String sign = encrypt(sbStr,"SHA-256");
        return sign;
    }
    public static String encrypt(String strSrc, String encName) {
        MessageDigest md = null;
        String strDes = null;
        byte[] bt = strSrc.getBytes();
        try {
            md = MessageDigest.getInstance(encName);
            md.update(bt);
            strDes = bytes2Hex(md.digest()); // to HexString
        } catch (NoSuchAlgorithmException e) {
            System.out.println("签名失败！");
            logger.error("签名失败");
            return null;
        }
        return strDes;
    }
    public static String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }
}
