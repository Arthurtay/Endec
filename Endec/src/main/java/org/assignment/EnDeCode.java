package org.assignment;

import java.util.HashMap;
import java.util.Map;

public class EnDeCode implements Edec {

    private Map<Integer, Character> codeList;
    private Map<Character,Integer> reverseCodeList;
    private char offsetChar;

    public EnDeCode(){

        Map<Integer, Character> hash_map = new HashMap<Integer,Character>();
        Map<Character,Integer> reserve_hash_map = new HashMap<Character,Integer>();

        for (int i = 0; i <= 25; i++) {
            hash_map.put(i, (char) ('A' + i));
        }

        int temp = 0;
        for (int i = 26; i <= 35; i++) {
            hash_map.put(i,(char)(temp +'0'));
            temp++;
        }

        hash_map.put(36 ,'(');
        hash_map.put(37 ,')');
        hash_map.put(38 ,'*');
        hash_map.put(39 ,'+');
        hash_map.put(40 ,',');
        hash_map.put(41 ,'-');
        hash_map.put(42 ,'.');
        hash_map.put(43 ,'/');

        for (Map.Entry<Integer,Character> entry : hash_map.entrySet()) {
            int key = entry.getKey();
            char value = entry.getValue();
            reserve_hash_map.put( value, key );
        }

        this.codeList = hash_map;
        this.reverseCodeList = reserve_hash_map;

    }


    @Override
    public String encode(String plainText) {

        int offsetNum = 0;
        String encode =  "";
        encode += offsetChar;

        char text[] =  plainText.toCharArray();

        //based on offset character get number to offset
        offsetNum =   reverseCodeList.get(offsetChar);



        for (char character: text ) {
            int key = 0;
            if(reverseCodeList.get(character) != null){
                key =  reverseCodeList.get(character) - offsetNum   ;
                if(key < 0){

                    key = key + 44;

                }
                encode +=  codeList.get(key);
            }
            else{
                encode +=  character;
            }

        }
        return encode;

    }

    @Override
    public String decode(String encodedText) {
        int offsetNum = 0;
        String plainText =  "";


        offsetNum =   reverseCodeList.get(encodedText.charAt(0));
        char text[] = encodedText.substring(1).toCharArray();

        //based on offset character get number to offset



        for (char character: text ) {
            int key = 0;
            if(reverseCodeList.get(character) != null){
                key =  reverseCodeList.get(character) + offsetNum  ;
                if(key > 43){
                    key = key - 44;
                }

                plainText +=  codeList.get(key);
            }
            else{
                plainText +=  character;
            }

        }
        return plainText;
    }

    public Character getOffset() {
        return offsetChar;
    }

    public void setOffset(Character offsetChar) {
        if(reverseCodeList.get(offsetChar) != null) {
            this.offsetChar = offsetChar;
        }else{
            this.offsetChar = 'A';
            System.out.println("Invalid offset Character, default Shift Table A will be applied ");
        }
    }
}
