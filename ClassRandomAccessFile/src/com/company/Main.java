package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        // Kreiranje datoteke sa slucajnim pristupom
        RandomAccessFile inout = new RandomAccessFile("nasadatoteka.txt","rw");

        // brisanje datoteke radi unistenje starog sadrzaja
        //inout.setLength();
        // Zapisivanje novih celih brojeva u datoteku
        for(int i =0; i<200; i++){
            inout.write(i);
        }

        // prikazivanje sadasnje duzine datoteke
        System.out.println("Current file length is" + inout.length());

        // dobijanje prvog broja
        inout.seek(0);
        System.out.println("The first number is " + inout.readInt());

        //Dobijanje drugog broja
        inout.seek(1*4); // pointer se pomera na drugi broj
        System.out.println("The second number is: " + inout.readInt());

        // dobijanje desetog broja
        inout.seek(9*4);
        System.out.println("The then number is: " + inout.readInt());

        // promena 11 broja
        inout.write(555);
        // Dodavanje novog broja
        inout.seek(inout.length()); // Pomeranje pointera na kraj datoteke
        inout.writeInt(999);

        // Prikazivanje nove dužine
        System.out.println("The new length is " + inout.length());

        // Dobijanje novoh 11. broja
        inout.seek(10 * 4); // Pomeranje pointera do sledećeg broja
        System.out.println("The eleventh number is " + inout.readInt());

        inout.close();




    }
}
