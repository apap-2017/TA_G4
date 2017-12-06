package com.akademik.mahasiswa.g4.controller;

import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.akademik.mahasiswa.g4.model.db.RiwayatPerkuliahanModel;
import com.akademik.mahasiswa.g4.model.rest.*;
import com.akademik.mahasiswa.g4.model.view.IRSModel;
import com.akademik.mahasiswa.g4.service.IRSService;
import com.akademik.mahasiswa.g4.service.KelasService;
import com.akademik.mahasiswa.g4.service.MahasiswaService;
import com.akademik.mahasiswa.g4.service.RiwayatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IRSController {

    @Autowired
    private IRSService irsService;

    @RequestMapping(value = "/irs", method = RequestMethod.GET)
    public String setIRS(Model model){

        //TODO remove getJadwalMock() and uncomment
        JadwalModel jadwalModel = getJadwalMock();//irsService.getJadwalSekarang();

        if(jadwalModel != null) {
            model.addAttribute("jadwal", jadwalModel);
            return "page-set-irs";
        }

        return "not-found";
    }

    //TODO remove this
    private JadwalModel getJadwalMock() {
        JadwalModel model = new JadwalModel();
        TermModel termModel = new TermModel();
        termModel.setTahunAjar("2017-18");
        termModel.setNomor(3);
        model.setTerm(termModel);

        List<MatakuliahModel> matakuliahModels = new ArrayList<>();
        MatakuliahModel matkul1 = new MatakuliahModel();
        matkul1.setNama("Adbis");
        matkul1.setKurikulum("2017.2016.1.1");
        matkul1.setKodeMK("SI-1");
        matkul1.setSks(2);
        List<KelasModel> kelas11 = new ArrayList<>();
        KelasModel kelas111 = new KelasModel();
        kelas111.setKodeMK(matkul1.getKodeMK());
        kelas111.setKurikulum(matkul1.getKurikulum());
        kelas111.setIdKelas(234);
        kelas111.setNamaMK(matkul1.getNama());
        kelas111.setNamaKelas("Adbis-A");
        kelas111.setSks(matkul1.getSks());
        kelas11.add(kelas111);
        kelas111.setKapasitas(54);
        kelas111.setMahasiswaSaatIni(23);

        List<JadwalKelasModel> jadwalKelasModels11 = new ArrayList<>();
        JadwalKelasModel jadwalKelasModel111 = new JadwalKelasModel();
        jadwalKelasModel111.setHari("Sabtu");
        jadwalKelasModel111.setRuangan("Aula");
        jadwalKelasModel111.setJamMulai("17:00");
        jadwalKelasModel111.setJamAkhir("19:00");
        List<DosenPengajarModel> dosenPengajarModels111 = new ArrayList<>();
        dosenPengajarModels111.add(new DosenPengajarModel("Sukiman"));
        dosenPengajarModels111.add(new DosenPengajarModel("Badu"));
        jadwalKelasModel111.setDosenPengajars(dosenPengajarModels111);
        jadwalKelasModels11.add(jadwalKelasModel111);
        JadwalKelasModel jadwalKelasModel112 = new JadwalKelasModel();
        jadwalKelasModel112.setHari("Jumat");
        jadwalKelasModel112.setRuangan("Aula");
        jadwalKelasModel112.setJamMulai("17:00");
        jadwalKelasModel112.setJamAkhir("19:00");
        List<DosenPengajarModel> dosenPengajarModels112 = new ArrayList<>();
        dosenPengajarModels112.add(new DosenPengajarModel("Sukiman"));
        dosenPengajarModels112.add(new DosenPengajarModel("Badu"));
        jadwalKelasModel112.setDosenPengajars(dosenPengajarModels112);
        jadwalKelasModels11.add(jadwalKelasModel112);
        kelas111.setWaktu(jadwalKelasModels11);

        KelasModel kelas112 = new KelasModel();
        kelas112.setKodeMK(matkul1.getKodeMK());
        kelas112.setKurikulum(matkul1.getKurikulum());
        kelas112.setIdKelas(235);
        kelas112.setNamaMK(matkul1.getNama());
        kelas112.setNamaKelas("Adbis-B");
        kelas112.setSks(matkul1.getSks());
        kelas11.add(kelas112);
        kelas112.setKapasitas(78);
        kelas112.setMahasiswaSaatIni(11);

        List<JadwalKelasModel> jadwalKelasModels112 = new ArrayList<>();
        JadwalKelasModel jadwalKelasModel1121 = new JadwalKelasModel();
        jadwalKelasModel1121.setHari("Selasa");
        jadwalKelasModel1121.setRuangan("Aula");
        jadwalKelasModel1121.setJamMulai("17:00");
        jadwalKelasModel1121.setJamAkhir("19:00");
        List<DosenPengajarModel> dosenPengajarModels1121 = new ArrayList<>();
        dosenPengajarModels1121.add(new DosenPengajarModel("Sukiman"));
        dosenPengajarModels1121.add(new DosenPengajarModel("Badu"));
        jadwalKelasModel1121.setDosenPengajars(dosenPengajarModels1121);
        jadwalKelasModels112.add(jadwalKelasModel1121);
        JadwalKelasModel jadwalKelasModel1122 = new JadwalKelasModel();
        jadwalKelasModel1122.setHari("Kamis");
        jadwalKelasModel1122.setRuangan("1204");
        jadwalKelasModel1122.setJamMulai("17:00");
        jadwalKelasModel1122.setJamAkhir("19:00");
        List<DosenPengajarModel> dosenPengajarModels1122 = new ArrayList<>();
        dosenPengajarModels1122.add(new DosenPengajarModel("Sukiman"));
        dosenPengajarModels1122.add(new DosenPengajarModel("Badu"));
        jadwalKelasModel112.setDosenPengajars(dosenPengajarModels1122);
        jadwalKelasModels112.add(jadwalKelasModel1122);
        kelas112.setWaktu(jadwalKelasModels112);

        KelasModel kelas113 = new KelasModel();
        kelas113.setKodeMK(matkul1.getKodeMK());
        kelas113.setKurikulum(matkul1.getKurikulum());
        kelas113.setIdKelas(237);
        kelas113.setNamaMK(matkul1.getNama());
        kelas113.setNamaKelas("Adbis-C");
        kelas113.setSks(matkul1.getSks());
        kelas113.setKapasitas(154);
        kelas113.setMahasiswaSaatIni(1);

        List<JadwalKelasModel> jadwalKelasModels113 = new ArrayList<>();
        JadwalKelasModel jadwalKelasModel1131 = new JadwalKelasModel();
        jadwalKelasModel1131.setHari("Kamis");
        jadwalKelasModel1131.setRuangan("1102");
        jadwalKelasModel1131.setJamMulai("10:00");
        jadwalKelasModel1131.setJamAkhir("11:00");
        List<DosenPengajarModel> dosenPengajarModels1131 = new ArrayList<>();
        dosenPengajarModels1131.add(new DosenPengajarModel("Koko"));
        dosenPengajarModels1131.add(new DosenPengajarModel("Neko"));
        jadwalKelasModel1131.setDosenPengajars(dosenPengajarModels1131);
        jadwalKelasModels113.add(jadwalKelasModel1131);
        JadwalKelasModel jadwalKelasModel1132 = new JadwalKelasModel();
        jadwalKelasModel1132.setHari("Rabu");
        jadwalKelasModel1132.setRuangan("1103");
        jadwalKelasModel1132.setJamMulai("16:00");
        jadwalKelasModel1132.setJamAkhir("11:00");
        List<DosenPengajarModel> dosenPengajarModels1132 = new ArrayList<>();
        dosenPengajarModels1132.add(new DosenPengajarModel("Siou"));
        dosenPengajarModels1132.add(new DosenPengajarModel("Ahur"));
        jadwalKelasModel1132.setDosenPengajars(dosenPengajarModels1132);
        jadwalKelasModels113.add(jadwalKelasModel1132);
        kelas112.setWaktu(jadwalKelasModels113);
        kelas113.setWaktu(jadwalKelasModels113);
        kelas11.add(kelas113);

        matkul1.setKelas(kelas11);
        matakuliahModels.add(matkul1);

        MatakuliahModel matkul2 = new MatakuliahModel();
        matkul2.setNama("APAP");
        matkul2.setKurikulum("2017.2018.2.1");
        matkul2.setKodeMK("SI-3");
        matkul2.setSks(4);
        List<KelasModel> kelas21 = new ArrayList<>();
        KelasModel kelas211 = new KelasModel();
        kelas211.setWaktu(jadwalKelasModels112);
        kelas211.setKodeMK(matkul2.getKodeMK());
        kelas211.setKurikulum(matkul2.getKurikulum());
        kelas211.setIdKelas(238);
        kelas211.setNamaMK(matkul2.getNama());
        kelas211.setNamaKelas("APAP-A");
        kelas211.setSks(matkul2.getSks());
        kelas211.setMahasiswaSaatIni(23);
        kelas211.setKapasitas(100);
        kelas21.add(kelas211);
        KelasModel kelas212 = new KelasModel();
        kelas212.setWaktu(jadwalKelasModels11);
        kelas212.setKodeMK(matkul2.getKodeMK());
        kelas212.setKurikulum(matkul2.getKurikulum());
        kelas212.setIdKelas(239);
        kelas212.setNamaMK(matkul2.getNama());
        kelas212.setNamaKelas("APAP-B");
        kelas212.setSks(matkul2.getSks());
        kelas212.setMahasiswaSaatIni(343);
        kelas212.setKapasitas(1);
        kelas21.add(kelas212);
        matkul2.setKelas(kelas21);
        matakuliahModels.add(matkul2);

        model.setMatkul(matakuliahModels);

        model.setMatkul(matakuliahModels);

        return model;
    }

    @RequestMapping(value = "/irs", method = RequestMethod.POST)
    public String submitIRS(Model model, @ModelAttribute("jadwal") JadwalModel jadwalModel){
        //TODO remove this and uncomment
        return "login.html";
//        IRSModel irs = irsService.getIRS("123456786");
//        if(irs != null) {
//            model.addAttribute("irs", irs);
//            return "page-lihat-irs";
//        }else{
//            return "page-not-found-irs";
//        }
    }

    @RequestMapping(value = "/irs/{npm}", method = RequestMethod.GET)
    public String lihatIRS(Model model, @PathVariable("npm") String npm){
        IRSModel irs = irsService.getIRS(npm);
        if(irs != null) {
            model.addAttribute("irs", irs);
            return "page-lihat-irs";
        }else{
            return "page-not-found-irs";
        }
    }


}
