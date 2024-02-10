/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.weton.primbon;

/**
 *
 * @author fatiq
 */
public class Array1 {

    private String[] hari = new String[35];
    private String[] pasar = new String[35];
    private String[] abad = new String[35];

    public Array1() {
        for (int i = 0; i < hari.length; i++) {
            hari[i++] = "Senin";
            hari[i++] = "Selasa";
            hari[i++] = "Rabu";
            hari[i++] = "Kamis";
            hari[i++] = "Jum'at";
            hari[i++] = "Sabtu";
            hari[i] = "Minggu";
        }

        for (int i = 0; i < pasar.length; i++) {
            pasar[i++] = "Pahing";
            pasar[i++] = "Pon";
            pasar[i++] = "Wage";
            pasar[i++] = "Kliwon";
            pasar[i] = "Legi";
        }

        abad[0] = "A";
        abad[1] = "L";
        abad[3] = "C";
        abad[5] = "N";
        abad[7] = "E";
        abad[8] = "P";
        abad[10] = "G";
        abad[12] = "R";
        abad[14] = "I";
        abad[15] = "T";
        abad[17] = "K";
        abad[19] = "B";
        abad[21] = "M";
        abad[22] = "D";
        abad[24] = "O";
        abad[26] = "F";
        abad[28] = "Q";
        abad[29] = "H";
        abad[31] = "S";
        abad[33] = "J";
    }

    /**
     * @return the hari
     */
    public String[] getHari() {
        return hari;
    }

    /**
     * @return the pasar
     */
    public String[] getPasar() {
        return pasar;
    }

    /**
     * @return the abad
     */
    public String[] getAbad() {
        return abad;
    }

    public String getHari(int i) {
        return hari[i];
    }

    public String getPasar(int i) {
        return pasar[i];
    }

    public String getAbad(int i) {
        return abad[i];
    }

    public int getIndexAbad(String s) {
        int j = 0;
        for (String k : abad) {
            if (s.equals(k)) {
                break;
            }
            j++;
        }
        return j;
    }

}
