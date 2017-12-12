package com.akademik.mahasiswa.g4.utls;

public class NilaiUtils {


    public static double bobotSKS(String nilaiHuruf){
        if(nilaiHuruf == null || nilaiHuruf.equalsIgnoreCase("I")){
            return 0;
        }else if(nilaiHuruf.equalsIgnoreCase("A")){
            return 4;
        }else if(nilaiHuruf.equalsIgnoreCase("A-")){
            return 3.7;
        }else if(nilaiHuruf.equalsIgnoreCase("B+")){
            return 3.3;
        }else if(nilaiHuruf.equalsIgnoreCase("B")){
            return 3;
        }else if((nilaiHuruf.equalsIgnoreCase("B-"))){
            return 2.7;
        }else if(nilaiHuruf.equalsIgnoreCase("C+")){
            return 2.3;
        }else if(nilaiHuruf.equalsIgnoreCase("C")){
            return 2;
        }else if(nilaiHuruf.equalsIgnoreCase("D")){
            return 1.5;
        }else if(nilaiHuruf.equalsIgnoreCase("E")){
            return 1;
        }else{
            return 0;
        }
    }

}
