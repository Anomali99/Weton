/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.weton.primbon;

/**
 *
 * @author fatiq
 */
public class Array3 {

    private String[] tanggal = new String[35];
    private String[] tahun1 = new String[35];
    private String[] tahun2 = new String[35];
    private String[] tahun3 = new String[35];

    public Array3() {
        for (int i = 0; i < 31; i++) {
            tanggal[i] = String.valueOf(i + 1);
        }

        String[] tahun1 = {"63", "79", "95", "72", "88", "81", "97", "74", "90", "67", "83", "99", "76", "92", "85", "-", "78", "94", "71", "87", "64", "80", "96", "89", "", "82", "98", "75", "91", "68", "84", "0", "93", "-", "86"};
        String[] tahun2 = {"24", "40", "56", "49", "65", "42", "58", "35", "51", "28", "44", "60", "53", "69", "46", "62", "39", "55", "32", "48", "41", "57", "73", "50", "66", "43", "59", "36", "52", "45", "61", "77", "54", "70", "74"};
        String[] tahun3 = {"1", "17", "33", "10", "26", "3", "19", "-", "12", "5", "21", "37", "14", "30", "7", "23", "-", "16", "9", "25", "2", "18", "34", "11", "27", "4", "20", "13", "29", "6", "22", "38", "15", "31", "8"};
        this.tahun1 = tahun1;
        this.tahun2 = tahun2;
        this.tahun3 = tahun3;
    }

    public Array3(Array3 ar, String th, int key) {
        String q = th.substring(2);
        String s = String.valueOf(Integer.parseInt(q));
        int i = -1;
        for (int j = 0; j < 35; j++) {
            if (s.equals(ar.getTahun1()[j])) {
                i = j;
                break;
            }
        }
        if (i == -1) {
            for (int j = 0; j < 35; j++) {
                if (s.equals(ar.getTahun2()[j])) {
                    i = j;
                    break;
                }
            }
            if (i == -1) {
                for (int j = 0; j < 35; j++) {
                    if (s.equals(ar.getTahun3()[j])) {
                        i = j;
                        break;
                    }
                }
            }
        }

        for (int j = 0; j < 35; j++) {
            if (i == 35) {
                i = 0;
            }
            if (key == 35) {
                key = 0;
            }
            tanggal[key] = ar.getTanggal()[i];
            tahun1[key] = ar.getTahun1()[i];
            tahun2[key] = ar.getTahun2()[i];
            tahun3[key] = ar.getTahun3()[i];
            key++;
            i++;
        }
    }

    /**
     * @return the tanggal
     */
    public String[] getTanggal() {
        return tanggal;
    }

    /**
     * @return the tahun1
     */
    public String[] getTahun1() {
        return tahun1;
    }

    /**
     * @return the tahun2
     */
    public String[] getTahun2() {
        return tahun2;
    }

    /**
     * @return the tahun3
     */
    public String[] getTahun3() {
        return tahun3;
    }

    public int getIndexTanggal(String tgl) {
        int j = 0;
        for (String tg : tanggal) {
            if (tgl.equals(tg)) {
                break;
            }
            j++;
        }
        return j;
    }

}
