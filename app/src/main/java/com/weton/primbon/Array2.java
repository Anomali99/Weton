/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.weton.primbon;

/**
 *
 * @author fatiq
 */
public class Array2 {

    private String[] bulanB = new String[35];
    private String[] bulanK = new String[35];

    public Array2() {
        bulanB[0] = "Jan";
        bulanB[2] = "Agt";
        bulanB[6] = "Jul";
        bulanB[11] = "Jun";
        bulanB[15] = "Mei";
        bulanB[19] = "Des";
        bulanB[20] = "Apr";
        bulanB[24] = "Mar Nop";
        bulanB[28] = "Okt";
        bulanB[31] = "Peb";
        bulanB[33] = "Sep";
        bulanK[0] = "Jan";
        bulanK[3] = "Agt";
        bulanK[7] = "Jul";
        bulanK[12] = "Jun";
        bulanK[16] = "Mei";
        bulanK[20] = "Des";
        bulanK[21] = "Apr";
        bulanK[25] = "Mar Nop";
        bulanK[29] = "Okt";
        bulanK[31] = "Peb";
        bulanK[34] = "Sep";
    }

    public Array2(Array2 ar, int index) {
        for (int i = 0; i < 35; i++) {
            if (index == 35) {
                index = 0;
            }
            bulanB[index] = ar.getBulanB(i);
            bulanK[index] = ar.getBulanK(i);
            index++;
        }
    }

    /**
     * @return the bulanB
     */
    public String[] getBulanB() {
        return bulanB;
    }

    /**
     * @return the bulanK
     */
    public String[] getBulanK() {
        return bulanK;
    }

    public String getBulanB(int i) {
        return bulanB[i];
    }

    public String getBulanK(int i) {
        return bulanK[i];
    }

    public int getIndexBulanB(String s) {
        int j = 0;
        boolean b = false;
        for (String k : bulanB) {
            if (k != null) {
                for (String t : k.split(" ")) {
                    if (s.equals(t)) {
                        b = true;
                    }
                }
            }
            if (b) {
                break;
            } else {
                j++;
            }
        }
        return j;
    }

    public int getIndexBulanK(String s) {
        int j = 0;
        boolean b = false;
        for (String k : bulanK) {
            if (k != null) {
                for (String t : k.split(" ")) {
                    if (s.equals(t)) {
                        b = true;
                    }
                }
            }
            if (b) {
                break;
            } else {
                j++;
            }
        }
        return j;
    }

    public int getIndexBulan(String bln, String th) {
        int i = -1;
        int t = Integer.parseInt(th);
        if (t % 4 == 0 || (t % 400 == 0 && t % 100 == 0)) {
            i = getIndexBulanK(bln);
        } else {
            i = getIndexBulanB(bln);
        }
        return i;
    }

}
