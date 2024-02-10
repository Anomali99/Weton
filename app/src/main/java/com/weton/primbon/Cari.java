/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.weton.primbon;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author fatiq
 */
public class Cari {

    private static Array1 ar1 = new Array1();
    private static Array2 ar2 = new Array2();
    private static Array3 ar3 = new Array3();

    public static String[] neptu(Date d) {
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        String[] dat = date.format(d).split("-");
        String tgl = String.valueOf(Integer.parseInt(dat[0]));
        String bulan = getBulan(Integer.parseInt(dat[1]));
        String tahun = dat[2];
        Array1 tb1 = ar1;
        Array2 tb2 = new Array2(ar2, getAbad(tahun));
        Array3 tb3 = new Array3(ar3,tahun,tb2.getIndexBulan(bulan, tahun));
        return new String[]{tb1.getHari(tb3.getIndexTanggal(tgl)),tb1.getPasar(tb3.getIndexTanggal(tgl))};
    }

    private static String getBulan(int i) {
        switch (i) {
            case 1:
                return "Jan";
            case 2:
                return "Peb";
            case 3:
                return "Mar";
            case 4:
                return "Apr";
            case 5:
                return "Mei";
            case 6:
                return "Jun";
            case 7:
                return "Jul";
            case 8:
                return "Agt";
            case 9:
                return "Sep";
            case 10:
                return "Okt";
            case 11:
                return "Nop";
            case 12:
                return "Des";
            default:
                return null;
        }
    }

    private static int getAbad(String tahun) {
        int i = Integer.parseInt(tahun) % 2000;
        int key = -1;
        if (i >= 1 && i <= 100) {
            key = ar1.getIndexAbad("A");
        } else if (i >= 101 && i <= 200) {
            key = ar1.getIndexAbad("B");
        } else if (i >= 201 && i <= 300) {
            key = ar1.getIndexAbad("C");
        } else if (i >= 301 && i <= 400) {
            key = ar1.getIndexAbad("D");
        } else if (i >= 401 && i <= 500) {
            key = ar1.getIndexAbad("E");
        } else if (i >= 501 && i <= 600) {
            key = ar1.getIndexAbad("F");
        } else if (i >= 601 && i <= 700) {
            key = ar1.getIndexAbad("G");
        } else if (i >= 701 && i <= 800) {
            key = ar1.getIndexAbad("H");
        } else if (i >= 801 && i <= 900) {
            key = ar1.getIndexAbad("I");
        } else if (i >= 901 && i <= 1000) {
            key = ar1.getIndexAbad("J");
        } else if (i >= 1001 && i <= 1100) {
            key = ar1.getIndexAbad("K");
        } else if (i >= 1101 && i <= 1200) {
            key = ar1.getIndexAbad("L");
        } else if (i >= 1201 && i <= 1300) {
            key = ar1.getIndexAbad("M");
        } else if (i >= 1301 && i <= 1400) {
            key = ar1.getIndexAbad("N");
        } else if (i >= 1401 && i <= 1500) {
            key = ar1.getIndexAbad("O");
        } else if (i >= 1501 && i <= 1600) {
            key = ar1.getIndexAbad("P");
        } else if (i >= 1601 && i <= 1700) {
            key = ar1.getIndexAbad("Q");
        } else if (i >= 1701 && i <= 1800) {
            key = ar1.getIndexAbad("R");
        } else if (i >= 1801 && i <= 1900) {
            key = ar1.getIndexAbad("S");
        } else if ((i >= 1901 && i <= 1999)|| i ==0) {
            key = ar1.getIndexAbad("T");
        }
        return key;
    }
    
//    public static void main(String[] args) {
//        try {
//            SimpleDateFormat tgl = new SimpleDateFormat("dd-MM-yyyy");
//            String[] s = neptu(tgl.parse("07-03-2004"));
//            int[] i = Primbon.neptu(s);
//            System.out.println(s[0]+" ("+i[0]+"), "+s[1]+" ("+i[1]+") \t["+(i[0]+i[1])+"]");
//            String[] s1 = neptu(tgl.parse("11-08-2003"));
//            int[] i1 = Primbon.neptu(s1);
//            System.out.println(s1[0]+" ("+i1[0]+"), "+s1[1]+" ("+i1[1]+") \t["+(i1[0]+i1[1])+"]");
//            int j = i[0]+i[1]+i1[0]+i1[1];
//            String[] h = Primbon.jodoh(j);
//            System.out.println(h[0]+" \t\t\t["+j+"]");
//            System.out.println(h[1]);
//        } catch (ParseException ex) {
//            Logger.getLogger(Cari.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
