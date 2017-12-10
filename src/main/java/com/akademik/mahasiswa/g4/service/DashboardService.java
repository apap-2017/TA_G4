package com.akademik.mahasiswa.g4.service;

import com.akademik.mahasiswa.g4.mapper.MahasiswaMapper;
import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.akademik.mahasiswa.g4.model.db.RiwayatPerkuliahanModel;
import com.akademik.mahasiswa.g4.model.rest.KelasModel;
import com.akademik.mahasiswa.g4.model.view.DashboardModel;
import com.akademik.mahasiswa.g4.model.view.StatistikNilaiModel;
import com.akademik.mahasiswa.g4.utls.IPUtils;
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

        DashboardModel dashboard = new DashboardModel();
        dashboard.setMahasiswa(mahasiswaMapper.getMahasiswa(npm));

        double countIPLulus = 0;
        double countSemester = 0;

        List<StatistikNilaiModel> statistikNilais = new ArrayList<>();
        List<RiwayatPerkuliahanModel> allRiwayatMahasiswa = riwayatService.getAllRiwayatMahasiswa(npm);
        for(RiwayatPerkuliahanModel riwayatMahasiswa : allRiwayatMahasiswa){

            List<KelasModel> kelases = riwayatMahasiswa.getKelases();
            StatistikNilaiModel statistikNilai = new StatistikNilaiModel(
                    riwayatMahasiswa.getTahunAjar(),
                    riwayatMahasiswa.getTerm(),
                    kelases.size(),
                    SKSUtils.getJumlahSKS(kelases),
                    SKSUtils.getJumlahSKSLulus(kelases),
                    IPUtils.getIPT(kelases));
            statistikNilais.add(statistikNilai);

            //untuk ipk
            countIPLulus += IPUtils.getIPLulus(kelases);
            countSemester++;

        }

        dashboard.setStatistikNilais(statistikNilais);

        double ipk = 0;
        if(countSemester > 0)
            ipk = countIPLulus / countSemester;
        dashboard.setIpk(ipk);

        dashboard.setStatistikNilais(statistikNilais);

//        TODO ganti dengan yg dibawah ini returnnya
//        return dashboard;
        return getDashboardDummy();
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
