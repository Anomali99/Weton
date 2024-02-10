/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.weton.primbon;

/**
 *
 * @author fatiq
 */
public class Primbon {
    public static int[] neptu(String[] s){
        int[] n = new int[2];
        switch(s[0]){
            case "Senin"    : n[0] = 4; break;
            case "Selasa"   : n[0] = 3; break;
            case "Rabu"     : n[0] = 7; break;
            case "Kamis"    : n[0] = 8; break;
            case "Jum'at"   : n[0] = 6; break;
            case "Sabtu"    : n[0] = 9; break;
            case "Minggu"   : n[0] = 5; break;
        }
        switch(s[1]){
            case "Pahing"   : n[1] = 9; break;
            case "Pon"      : n[1] = 7; break;
            case "Wage"     : n[1] = 4; break;
            case "Kliwon"   : n[1] = 8; break;
            case "Legi"     : n[1] = 5; break;
        }
        return n;
    }
    
    public static String[] jodoh(int i){
        String[] s = new String[2];
        switch(i%8){
            case 1:
                s[0] = "Pegat";
                s[1] = "Yen tibo PEGAT bakal nemu masalah, mboh kui songko segi ekonomi, kekuasa'an, selingkuh sing akhir-akhire iso  pegatan.";
                break;
            case 2:
                s[0] = "Ratu";
                s[1] = "Yen tibo RATU iki jodoh banget. Di ajeni karo tonggo teparo lan wongliyo. Akeh wong iri karo keharmonisane.";
                break;
            case 3:
                s[0] = "Jodoh";
                s[1] = "Yen tibo JODOH cocok siji karo sijine. Iso podo-podo nrimo keluwehan lan kekurangan. Omah-omah lancar teko tuwo.";
                break;
            case 4:
                s[0] = "Topo";
                s[1] = "Yen tibo TOPO iki awal-awale susah nanging tembe mburi penak. Awal-awale kerep kenek masalah emboh kui songko segi ekonomi utowo liyane. Nanging yen wes duwe anak lan wes suwe anggone omah-omah bakal mulyo uripe.";
                break;
            case 5:
                s[0] = "Tinari";
                s[1] = "Yen tibo TINARI iki bakal nemu seneng. Penak anggone golek rejeki lan ora sampek urip kekurangan. Penak-penake tembung karep nemu bojo anggone omah-omah";
                break;
            case 6:
                s[0] = "Padu";
                s[1] = "Yen tibo PADU iki bakal sering tukaran. Nanging sejana saben ndino tukaran tapi ora sampek pegatan.";
                break;
            case 7:
                s[0] = "Sujanan";
                s[1] = "Yen tibo SUJANAN iki kerep tukaran lan akeh-akeh masalah selingkuh.";
                break;
            case 0:
                s[0] = "Pesthi";
                s[1] = "Yen tibo PESTHI iki omah-omahe bakal rukun, tentrem, adem ayem sampek tuwo. Senajan eneng masalah opo ae ora bakal ngrusak keharmonisane.";
                break;
        }
        return s;
    }

    public static String pasaran(int i){
        switch (i%4){
            case 0 : return "Macan (Harimau)";
            case 1 : return "Kul (Keong)";
            case 2 : return "Jaran (Kuda)";
            case 3 : return "Ketek (Monyet)";
            default: return null;
        }
    }

    public static String jodoh(int[] i, int[] j){
        String s = null;
        int k = i[0] + i[1] + j[0] + j[1];
        switch (k%5){
            case 0 :
                s = "Pati";
                break;
            case 1 :
                s = "Sandang";
                break;
            case 2 :
                s = "Papan";
                break;
            case 3 :
                s = "Pangan";
                break;
            case 4 :
                s = "Sekarat";
                break;
            default:
                s = null;
                break;
        }
        return s;
    }
}
