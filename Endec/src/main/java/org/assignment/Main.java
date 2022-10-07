package org.assignment;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)  {

        try{

            String printValue = "";
            EnDeCode edec = new EnDeCode();


            System.out.println("Enter Offset Character");
            // Enter data using BufferReader
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            // Reading data using readLine
            String name = reader.readLine();
            edec.setOffset(name.charAt(0));

            printValue = edec.encode("HELLO WORLD!");

            System.out.println("The Encoded Value is :");
            System.out.println(printValue);

            printValue = edec.decode(printValue);
            System.out.println("The Decoded Value is :");
            System.out.println(printValue);

        }catch (Exception e){

            System.out.println("Something went wrong.");
        }



    }
}