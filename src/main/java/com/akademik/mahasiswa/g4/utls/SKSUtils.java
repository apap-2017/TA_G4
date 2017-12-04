package com.akademik.mahasiswa.g4.utls;

import com.akademik.mahasiswa.g4.model.rest.KelasModel;

import java.util.List;

public class SKSUtils {

    public static int getMaxSKSByIP(double lastIP) {
        int sks = 24;
        if(lastIP < 3.5){
            sks = 21;
        }else if(lastIP < 3){
            sks = 18;
        }else if(lastIP < 2){
            sks = 15;
        }else if(lastIP < 1){
            sks = 12;
        }
        return sks;
    }

    public static int getJumlahSKS(List<KelasModel> kelases){
        int sks = 0;
        for(KelasModel kelas : kelases){
            sks += kelas.getSks();
        }
        return sks;
    }

}
