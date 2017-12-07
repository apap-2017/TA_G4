package com.akademik.mahasiswa.g4.utls;

import com.akademik.mahasiswa.g4.model.rest.KelasModel;

import java.util.List;

public class IPUtils {

    public static double getIPT(List<KelasModel> kelases){
        double ip = 0;
        int countSKS = 0;
        double countNilai = 0;
        for(KelasModel kelas : kelases){
            countSKS += kelas.getSks();
            countNilai += kelas.getSks() * NilaiUtils.bobotSKS(kelas.getNilaiHuruf());
        }
        if(countSKS > 0)
            ip = countNilai / countSKS;
        return ip;
    }

    public static double getIPLulus(List<KelasModel> kelases) {
        double ip = 0;
        int countSKSLulus = 0;
        int countNilaiLulus = 0;
        for(KelasModel kelas : kelases){
            if(SKSUtils.isLulus(kelas.getNilaiHuruf())){
                countSKSLulus += kelas.getSks();
                countNilaiLulus += kelas.getSks() * NilaiUtils.bobotSKS(kelas.getNilaiHuruf());
            }
        }
        if(countSKSLulus > 0){
            ip = countNilaiLulus / countSKSLulus;
        }
        return ip;
    }
}
