package com.akademik.mahasiswa.g4.utls;

import com.akademik.mahasiswa.g4.model.rest.KelasModel;

import java.util.List;

public class IPUtils {

    public static double getIP(List<KelasModel> kelases){
        double ip = 0;
        int countSKS = 0;
        int countNilai = 0;
        for(KelasModel kelas : kelases){
            countSKS += kelas.getSks();
            countNilai += kelas.getSks() * kelas.getNilaiAkhir();
        }
        if(countSKS != 0)
            ip = countNilai / (countSKS * 1.0);
        return ip;
    }

}
