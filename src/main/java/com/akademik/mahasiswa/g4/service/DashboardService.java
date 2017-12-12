package com.akademik.mahasiswa.g4.service;

import com.akademik.mahasiswa.g4.mapper.MahasiswaMapper;
import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.akademik.mahasiswa.g4.model.db.RiwayatPerkuliahanModel;
import com.akademik.mahasiswa.g4.model.rest.KelasModel;
import com.akademik.mahasiswa.g4.model.view.DashboardModel;
import com.akademik.mahasiswa.g4.model.view.StatistikNilaiModel;
import com.akademik.mahasiswa.g4.utls.IPUtils;
import com.akademik.mahasiswa.g4.utls.NilaiUtils;
import com.akademik.mahasiswa.g4.utls.SKSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private MahasiswaMapper mahasiswaMapper;
    @Autowired
    private RiwayatService riwayatService;

    public DashboardModel getDashboardMahasiswa(String npm){
//        //TODO ganti dengan yg dibawah ini returnnya
//        if(true)
//            return getDashboardDummy();

        DashboardModel dashboard = new DashboardModel();

        int totalSKSLulus = 0;
        int totalSKSDiperoleh = 0;
        List<KelasModel> allKelasesYgDiambilMhs = new ArrayList<>();

        //set statistik
        List<StatistikNilaiModel> statistikNilais = new ArrayList<>();
        List<RiwayatPerkuliahanModel> allRiwayatMahasiswa = riwayatService.getAllRiwayatMahasiswa(npm);
        for(RiwayatPerkuliahanModel riwayatMahasiswa : allRiwayatMahasiswa){

            List<KelasModel> kelases = riwayatMahasiswa.getKelases();
            int sksLulus = SKSUtils.getJumlahSKSLulus(kelases);
            int sksDiperoleh = SKSUtils.getJumlahSKS(kelases);
            totalSKSLulus += sksLulus;
            totalSKSDiperoleh += sksDiperoleh;
            StatistikNilaiModel statistikNilai = new StatistikNilaiModel(
                    riwayatMahasiswa.getTahunAjar(),
                    riwayatMahasiswa.getTerm(),
                    kelases.size(),
                    sksDiperoleh,
                    sksLulus,
                    IPUtils.getIPT(kelases));
            statistikNilais.add(statistikNilai);

            allKelasesYgDiambilMhs.addAll(kelases);

        }
        dashboard.setStatistikNilais(statistikNilais);

        //set ipk
        dashboard.setIpk(
                totalSKSLulus > 0
                        ? NilaiUtils.totalNilaiLulus(allKelasesYgDiambilMhs) / totalSKSLulus
                        : 0);

        //set dashboard mahasiswa
        dashboard.setMahasiswa(mahasiswaMapper.getMahasiswa(npm));
        dashboard.getMahasiswa().setSksLulus(totalSKSLulus);
        dashboard.getMahasiswa().setSksDiperoleh(totalSKSDiperoleh);

        return dashboard;
    }

    //TODO remove this id back end already
    private DashboardModel getDashboardDummy() {
        DashboardModel dummyDashboardModel = new DashboardModel();
        MahasiswaDBModel mahasiswa = new MahasiswaDBModel();
        mahasiswa.setNpm("150712345");
        mahasiswa.setNama("Haru Soka");
        mahasiswa.setAngkatan("2019");
        mahasiswa.setNamaUniv("Universitas I");
        mahasiswa.setNamaFakultas("Fakultas Perusahaan");
        mahasiswa.setNamaProdi("Teknik Data");
        mahasiswa.setSksDiperoleh(169);
        mahasiswa.setSksLulus(144);
        dummyDashboardModel.setMahasiswa(mahasiswa);
        dummyDashboardModel.setStatusAkademik("LULUS");
        dummyDashboardModel.setIpk(3.98);
        List<StatistikNilaiModel> statistikNilais = new ArrayList<>();
        statistikNilais.add(new StatistikNilaiModel("2016-17", 1, 4, 20, 20, 4));
        statistikNilais.add(new StatistikNilaiModel("2016-17", 2, 5, 24, 19, 4));
        statistikNilais.add(new StatistikNilaiModel("2016-17", 1, 7, 20, 15, 3.67));
        statistikNilais.add(new StatistikNilaiModel("2016-17", 2, 7, 20, 20, 3.9));
        statistikNilais.add(new StatistikNilaiModel("2016-17", 3, 3, 9, 4, 4));
        statistikNilais.add(new StatistikNilaiModel("2016-17", 1, 7, 20, 20, 4));
        statistikNilais.add(new StatistikNilaiModel("2016-17", 2, 8, 24, 20, 4));
        statistikNilais.add(new StatistikNilaiModel("2016-17", 1, 6, 20, 15, 3.8));
        statistikNilais.add(new StatistikNilaiModel("2016-17", 2, 3, 16, 11, 4));
        dummyDashboardModel.setStatistikNilais(statistikNilais);
        return dummyDashboardModel;
    }

}
