package com.company;

import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //skrivFil();
        skrivBinærFil();
        læsBinærFil();
        nummerArray();

    }
    public static void nummerArray() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            File myObj = new File("C:\\Users\\Tim\\IdeaProjects\\MyTestProgram\\src\\com\\company\\MinFil");
            Scanner in = new Scanner(System.in);
            int i = 0;
            System.out.println("Indtast 10 tal: ");
            Scanner s = new Scanner(myObj);
            while (s.hasNextLine()) {
                arrayList.add(s.nextLine());
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(arrayList.get(i) + " ");
            }
            System.out.println(arrayList);
        } catch (FileNotFoundException e) {
            System.out.println("an error has occured.");
            e.printStackTrace();
        }
    }
        /*public static void readFromFile(){
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            File myObj = new File("C:\\Users\\Tim\\IdeaProjects\\MyTestProgram\\src\\com\\company\\MinFil");
            Scanner s = new Scanner(myObj);
            while (s.hasNextLine()){
                arrayList.add(s.nextLine());
            }
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.println(arrayList.get(i) + " ");
            }
        try {
            File myObj = new File("C:\\Users\\Tim\\IdeaProjects\\MyTestProgram\\src\\com\\company\\MinFil");
            Scanner myReader = new Scanner(myObj);
            System.out.println(myReader);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
            Scanner s = new Scanner(new File("filepath"));
            while (s.hasNextLine()){
                list.add(s.nextLine());
            }
            s.close();
        }
        catch (FileNotFoundException e){
            System.out.println("an error has occured.");
            e.printStackTrace();
        }

    }*/
    public static void skrivFil() {
        try{
            PrintWriter ud = new PrintWriter("MinNyFil");
            int i=1;
            String navn="Pernille";
            float tal=(float) 10.5;
            ud.format("%d %s %f",i,navn,tal);
            ud.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static void skrivBinærFil(){

        try {
            DataOutputStream output = new DataOutputStream(new FileOutputStream("temp.dat"));
            int i=1;
            String navn="Pernille";
            float tal=(float) 10.5;
            output.writeInt(i);
            output.writeUTF(navn);
            output.writeFloat(tal);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void læsBinærFil(){
        try{
            DataInputStream indput = new DataInputStream(new FileInputStream("temp.dat"));
            int i;
            String navn;
            float tal;
            i=indput.readInt();
            navn=indput.readUTF();
            tal=indput.readFloat();
            indput.close();
            System.out.format("%d %s %.2f", i, navn, tal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
