package com.akademik.mahasiswa.g4.service;

import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.akademik.mahasiswa.g4.model.view.DashboardModel;
import com.akademik.mahasiswa.g4.model.view.StatistikNilaiModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService {

    public DashboardModel getDashboardMahasiswa(String npm){
        //TODO
        return getDashboardDummy();
    }

    //TODO remove this dummy
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
