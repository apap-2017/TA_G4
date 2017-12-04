package com.akademik.mahasiswa.g4.controller;

import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.akademik.mahasiswa.g4.model.db.RiwayatPerkuliahanModel;
import com.akademik.mahasiswa.g4.model.rest.*;
import com.akademik.mahasiswa.g4.model.view.IRSModel;
import com.akademik.mahasiswa.g4.service.IRSService;
import com.akademik.mahasiswa.g4.service.MahasiswaService;
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
    @Autowired
    private MahasiswaService mahasiswaService;

    @RequestMapping(value = "/irs", method = RequestMethod.GET)
    public String setIRS(Model model){

        //TODO get jadwalModel from service
        JadwalModel jadwalModel = irsService.getJadwalSekarang();

        model.addAttribute("jadwal", jadwalModel);

        return "set-irs";
    }

    @RequestMapping(value = "/irs", method = RequestMethod.POST)
    public String submitIRS(@ModelAttribute("jadwal") JadwalModel jadwalModel){
        irsService.submitIRS(jadwalModel);
        return "lihat-irs";
    }

    @RequestMapping(value = "/irs/{npm}", method = RequestMethod.GET)
    public String lihatIRS(Model model, @PathVariable("npm") String npm){
        //get mahasiswa
        MahasiswaDBModel mahasiswa = mahasiswaService.getMahasiswa(npm);

        System.out.println("nullllll > " + mahasiswa);

        IRSModel irs = new IRSModel();//
        irs.setMahasiswa(mahasiswa);
        irs.setTotalSKS(22);
        irs.setIpTerakhir(3.89);
        irs.setSksMaksimum(24);
        List<String> error = new ArrayList<>();
        error.add("SKS kekurangan");
        error.add("Kecepetan isi IRS");
        error.add("IRS udah tutup");
        irs.setError(error);
        RiwayatPerkuliahanModel riwayatPerkuliahanModel = new RiwayatPerkuliahanModel();
        riwayatPerkuliahanModel.setNpm(npm);
        riwayatPerkuliahanModel.setStatusIrs(true);
        riwayatPerkuliahanModel.setTahunAjar("2017-18");
        riwayatPerkuliahanModel.setTerm(1);
        List<KelasModel> kelases = new ArrayList<>();

        KelasModel kelas1 = new KelasModel();
        kelas1.setSks(4);
        kelas1.setNamaMK("APAP");
        kelas1.setKodeMK("SI-32");
        kelas1.setKurikulum("2016.2017.23");
        kelas1.setNamaKelas("APAP-C");
        kelases.add(kelas1);

        KelasModel kelas2 = new KelasModel();
        kelas2.setSks(3);
        kelas2.setNamaMK("Adbis");
        kelas2.setKodeMK("SI-31");
        kelas2.setKurikulum("2016.2017.23");
        kelas2.setNamaKelas("Adbis-A");
        kelases.add(kelas2);

        KelasModel kelas3 = new KelasModel();
        kelas3.setSks(2);
        kelas3.setNamaMK("Basdat");
        kelas3.setKodeMK("IK-11");
        kelas3.setKurikulum("2016.2017.23");
        kelas3.setNamaKelas("Basdat-B");
        kelases.add(kelas3);

        KelasModel kelas4 = new KelasModel();
        kelas4.setSks(6);
        kelas4.setNamaMK("Propensi");
        kelas4.setKodeMK("SI-111");
        kelas4.setKurikulum("2016.2017.23");
        kelas4.setNamaKelas("Propensi-K");
        kelases.add(kelas4);

        riwayatPerkuliahanModel.setKelases(kelases);
        irs.setRiwayat(riwayatPerkuliahanModel);

        model.addAttribute("irs", irs);

        return "lihat-irs";
    }


}
