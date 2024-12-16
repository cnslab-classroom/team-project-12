package _encryption;

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Character_replacement {
    //암호화, 복호화 매핑을 위한 맵
	private static final Map<Character, String> encryptionMap = new HashMap<>();
    private static final Map<String, Character> decryptionMap = new HashMap<>();

    static {
        //암호화 매핑(원래 문자 -> 암호)
        encryptionMap.put('a', "p1");
        encryptionMap.put('b', "r7");
        encryptionMap.put('c', "e");
        encryptionMap.put('d', "q3");
        encryptionMap.put('e', "5a");
        encryptionMap.put('f', "v12");
        encryptionMap.put('g', "g2");
        encryptionMap.put('h', "p2");
        encryptionMap.put('i', "t");
        encryptionMap.put('j', "we");
        encryptionMap.put('k', "c");
        encryptionMap.put('l', "no");
        encryptionMap.put('m', "z");
        encryptionMap.put('n', "d5");
        encryptionMap.put('o', "h");
        encryptionMap.put('p', "yu");
        encryptionMap.put('q', "qr");
        encryptionMap.put('r', "l");
        encryptionMap.put('s', "tw");
        encryptionMap.put('t', "m4");
        encryptionMap.put('u', "ur");
        encryptionMap.put('v', "bk");
        encryptionMap.put('w', "jt");
        encryptionMap.put('x', "ew");
        encryptionMap.put('y', "vr");
        encryptionMap.put('z', "uv");

        //복호화 매핑(암호 -> 원래 문자)
        //encryptionMap의 키-값을 역으로 사용
        for (Map.Entry<Character, String> entry : encryptionMap.entrySet()) 
        {
            decryptionMap.put(entry.getValue(), entry.getKey());
        }
    }

    //암호화 메서드
    public static String encrypt(String input) //input -> 암호화할 문자열
    {
        StringBuilder encrypted = new StringBuilder();
        
        //암호화할 문자열의 문자들을 하나씩 처리하도록 함.
        for (char c : input.toCharArray()) 
        {
            boolean isUpperCase = Character.isUpperCase(c);
            
            char lowerChar = Character.toLowerCase(c);

            if (encryptionMap.containsKey(lowerChar)) 
            {
            	//대문자면 앞에 U 붙여서 암호화 함
                if (isUpperCase) 
                {
                    encrypted.append("U");
                }
                encrypted.append(encryptionMap.get(lowerChar));
            } 
            else if (Character.isDigit(c)) 
            {
                encrypted.append("N").append(c); //숫자는 앞에 N 붙여서 표현함
            } 
            else 
            {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    //복호화 메서드
    public static String decrypt(String input) //암호화 된 문자열
    {
        StringBuilder decrypted = new StringBuilder();
        
        int i = 0;
        
        //암호화된 문자열을 한글짜씩 처리할 수 있도록 함.
        while (i < input.length()) 
        {
            boolean isUpperCase = false;
            
            //U 있으면 대문자로 변환
            if (input.charAt(i) == 'U') 
            {
                isUpperCase = true;
                i++;
            }

            if (i < input.length() && input.charAt(i) == 'N') 
            {
                i++;
                
                //복호화 해야하는 문자들 읽어들이고 매칭 값 찾기
                if (i < input.length() && Character.isDigit(input.charAt(i))) 
                {
                    decrypted.append(input.charAt(i));
                    i++;
                }
            } 
            else 
            {
                StringBuilder token = new StringBuilder();
                
                while (i < input.length() && (Character.isLetter(input.charAt(i)) || Character.isDigit(input.charAt(i)))) 
                {
                    token.append(input.charAt(i));
                    i++;
                    
                    if (decryptionMap.containsKey(token.toString())) 
                    {
                        break;
                    }
                }
                
                //복호화된 암호를 대문자로 변환하거나 그대로 추가하기
                if (decryptionMap.containsKey(token.toString())) 
                {
                    char decryptedChar = decryptionMap.get(token.toString());
                    
                    decrypted.append(isUpperCase ? Character.toUpperCase(decryptedChar) : decryptedChar);
                } 
                else 
                {
                    decrypted.append(token);
                }
            }
        }
        
        return decrypted.toString();
    }

}