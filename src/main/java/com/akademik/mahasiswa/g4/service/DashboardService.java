package com.akademik.mahasiswa.g4.service;

import com.akademik.mahasiswa.g4.dao.KurikulumDAO;
import com.akademik.mahasiswa.g4.dao.PenilaianDAO;
import com.akademik.mahasiswa.g4.dao.SekretariatDAO;
import com.akademik.mahasiswa.g4.dao.UnivDAO;
import com.akademik.mahasiswa.g4.mapper.KelasMapper;
import com.akademik.mahasiswa.g4.mapper.MahasiswaMapper;
import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.akademik.mahasiswa.g4.model.db.RiwayatPerkuliahanModel;
import com.akademik.mahasiswa.g4.model.rest.*;
import com.akademik.mahasiswa.g4.model.view.DashboardModel;
import com.akademik.mahasiswa.g4.model.view.StatistikNilaiModel;
import com.akademik.mahasiswa.g4.utls.IPUtils;
import com.akademik.mahasiswa.g4.utls.NilaiUtils;
import com.akademik.mahasiswa.g4.utls.SKSUtils;
import com.akademik.mahasiswa.g4.utls.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private MahasiswaMapper mahasiswaMapper;

    @Autowired
    private UnivService univService;

    @Autowired
    private RiwayatService riwayatService;
    @Autowired
    private KurikulumDAO kurikulumDAO;

    @Autowired
    private UnivDAO univDAO;

    @Autowired
    private PenilaianDAO penilaianDAO;

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

        UnivResponseModel univ = univDAO.getUniv(dashboard.getMahasiswa().getIdUniv());
        String namaUniv = univ.getResult().getUniversitas().getNamaUniv();

        FakultasResponseModel fakultas = univDAO.getFakultas(dashboard.getMahasiswa().getIdUniv(),
                dashboard.getMahasiswa().getIdFakultas());
        String namaFakultas = fakultas.getResult().getFakultas().getNamaFakultas();

        ProdiResponseModel prodi = univDAO.getProdi(dashboard.getMahasiswa().getIdUniv(),
                dashboard.getMahasiswa().getIdFakultas(),
                dashboard.getMahasiswa().getIdProdi());
        String namaProdi = prodi.getResult().getProdi().getNamaProdi();


        dashboard.getMahasiswa().setNamaUniv(namaUniv);
        dashboard.getMahasiswa().setNamaFakultas(namaFakultas);
        dashboard.getMahasiswa().setNamaProdi(namaProdi);

        //set yudisium
        KurikulumModel kurikulumModel = kurikulumDAO.getKurikulum(dashboard.getMahasiswa());
        int countWajib = 0;
        int countNotWajib = 0;
        List<SemuaNilaiResponseModel.NilaiResultModel.NilaiTermModel> nilaiTermModels = penilaianDAO.getNilaiMahasiswa(npm);
        for(SemuaNilaiResponseModel.NilaiResultModel.NilaiTermModel nilaiTermModel : nilaiTermModels){
            for(NilaiKuliahModel nilaiKuliahModel : nilaiTermModel.getNilaiKuliahs()){
                String nilaiHuruf = nilaiKuliahModel.getNilaiHuruf();
                if(NilaiUtils.isLulus(nilaiHuruf)) {
                    System.out.println(">>>>>>>> kodeMK : " + nilaiKuliahModel.getKelas().getMatakuliah().getKodeMK() +", isWajib: "
                            +nilaiKuliahModel.getKelas().getMatakuliah().isWajib());
                    if (nilaiKuliahModel.getKelas().getMatakuliah().isWajib())
                        countWajib++;
                    else
                        countNotWajib++;
                }
            }
        }
        System.out.println(">>>>> countwajib : " + countWajib);
        System.out.println(">>>>> countnonwajib : " + countNotWajib);
        System.out.println(">>>>> jumlah sks wajib : " + kurikulumModel.getJumlahSKSWajib());
        System.out.println(">>>>> jumlah sks pilihan : " + kurikulumModel.getJumlahSKSPilihan());
        System.out.println(">>>>> jumlah sks batas lulus : " + kurikulumModel.getBatasSKSLulus());
        if(countWajib >= kurikulumModel.getJumlahSKSWajib()
                && (countNotWajib + countNotWajib) >= kurikulumModel.getBatasSKSLulus()){
            dashboard.setStatusAkademik("LULUS");
        }else{
            dashboard.setStatusAkademik("BELUM LULUS");
        }



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
