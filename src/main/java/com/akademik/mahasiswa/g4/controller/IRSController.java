package com.akademik.mahasiswa.g4.controller;

import com.akademik.mahasiswa.g4.model.IRSFormModel;
import com.akademik.mahasiswa.g4.model.rest.*;
import com.akademik.mahasiswa.g4.service.IRSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class IRSController {

    @Autowired
    private IRSService irsService;

    private JadwalModel get(){
        JadwalModel jadwalModel = new JadwalModel();
        jadwalModel.setTerm(new TermModel("2017/2018",1));
        List<MatakuliahModel> matakuliahModels = new ArrayList<>();

        matakuliahModels.add(createMataKuliah("APAP-A","APAP-B",1,2));
        matakuliahModels.add(createMataKuliah("ADBIS-A","ADBIS-B",3,4));
        matakuliahModels.add(createMataKuliah("PSP-A","PSP-B",5,6));
        jadwalModel.setMatkul(matakuliahModels);
        return jadwalModel;
    }

    private MatakuliahModel createMataKuliah(String kelas1, String kelas2, int idKelas1, int idKelas2){
        MatakuliahModel matakuliahModel = new MatakuliahModel();
        matakuliahModel.setKodeMK("CS123");
        matakuliahModel.setNama("APAP");
        matakuliahModel.setSks(4);
        matakuliahModel.setKurikulum("2016.2017.2018");
        List<KelasModel> kelasModels = new ArrayList<>();

        KelasModel kelasModel = new KelasModel();
        kelasModel.setIdKelas(idKelas1);
        kelasModel.setKodeMK("CS123");
        kelasModel.setNamaKelas(kelas1);
        kelasModel.setKapasitas(50);
        kelasModel.setMahasiswaSaatIni(30);
        List<JadwalKelasModel> jadwalKelasModels = new ArrayList<>();
        JadwalKelasModel jadwalKelasModel1 = new JadwalKelasModel();
        jadwalKelasModel1.setHari("Senin");
        jadwalKelasModel1.setJamMulai("13:00");
        jadwalKelasModel1.setJamAkhir("14:00");
        jadwalKelasModel1.setRuangan("AULA A");
        List<DosenPengajarModel> dosenPengajarModels1 = new ArrayList<>();
        DosenPengajarModel dosenPengajarModel11 = new DosenPengajarModel();
        dosenPengajarModel11.setNama("badu");
        dosenPengajarModels1.add(dosenPengajarModel11);
        DosenPengajarModel dosenPengajarModel12 = new DosenPengajarModel();
        dosenPengajarModel12.setNama("oalah");
        dosenPengajarModels1.add(dosenPengajarModel12);
        jadwalKelasModel1.setDosenPengajars(dosenPengajarModels1);
        jadwalKelasModels.add(jadwalKelasModel1);
        JadwalKelasModel jadwalKelasModel2 = new JadwalKelasModel();
        jadwalKelasModel2.setHari("Rabu");
        jadwalKelasModel2.setJamMulai("00:00");
        jadwalKelasModel2.setJamAkhir("03:00");
        jadwalKelasModel2.setRuangan("AULA B");
        List<DosenPengajarModel> dosenPengajarModels2 = new ArrayList<>();
        DosenPengajarModel dosenPengajarMode211 = new DosenPengajarModel();
        dosenPengajarMode211.setNama("hahaha");
        dosenPengajarModels2.add(dosenPengajarMode211);
        DosenPengajarModel dosenPengajarMode212 = new DosenPengajarModel();
        dosenPengajarMode212.setNama("hehehe");
        dosenPengajarModels2.add(dosenPengajarMode212);
        jadwalKelasModel2.setDosenPengajars(dosenPengajarModels2);
        jadwalKelasModels.add(jadwalKelasModel2);
        kelasModel.setWaktu(jadwalKelasModels);
        kelasModels.add(kelasModel);
        KelasModel kelasModel2= new KelasModel();
        kelasModel2.setIdKelas(idKelas2);
        kelasModel2.setKodeMK("CS123");
        kelasModel2.setNamaKelas(kelas2);
        kelasModel2.setKapasitas(60);
        kelasModel2.setMahasiswaSaatIni(30);
        List<JadwalKelasModel> jadwalKelasModels2 = new ArrayList<>();
        JadwalKelasModel jadwalKelasModel21 = new JadwalKelasModel();
        jadwalKelasModel21.setHari("Senin");
        jadwalKelasModel21.setJamMulai("13:00");
        jadwalKelasModel21.setJamAkhir("14:00");
        jadwalKelasModel21.setRuangan("AULA A");
        List<DosenPengajarModel> dosenPengajarModels21 = new ArrayList<>();
        DosenPengajarModel dosenPengajarModel211 = new DosenPengajarModel();
        dosenPengajarModel211.setNama("badu");
        dosenPengajarModels21.add(dosenPengajarModel211);
        DosenPengajarModel dosenPengajarModel212 = new DosenPengajarModel();
        dosenPengajarModel212.setNama("oalah");
        dosenPengajarModels21.add(dosenPengajarModel212);
        jadwalKelasModel21.setDosenPengajars(dosenPengajarModels21);
        jadwalKelasModels2.add(jadwalKelasModel21);
        JadwalKelasModel jadwalKelasMode2l2 = new JadwalKelasModel();
        jadwalKelasMode2l2.setHari("Rabu");
        jadwalKelasMode2l2.setJamMulai("00:00");
        jadwalKelasMode2l2.setJamAkhir("03:00");
        jadwalKelasMode2l2.setRuangan("AULA B");
        List<DosenPengajarModel> dosenPengajarModels22 = new ArrayList<>();
        DosenPengajarModel dosenPengajarMode2211 = new DosenPengajarModel();
        dosenPengajarMode2211.setNama("hahaha");
        dosenPengajarModels22.add(dosenPengajarMode2211);
        DosenPengajarModel dosenPengajarMode2212 = new DosenPengajarModel();
        dosenPengajarMode2212.setNama("hehehe");
        dosenPengajarModels22.add(dosenPengajarMode2212);
        jadwalKelasMode2l2.setDosenPengajars(dosenPengajarModels22);
        jadwalKelasModels2.add(jadwalKelasMode2l2);
        kelasModel2.setWaktu(jadwalKelasModels2);
        kelasModels.add(kelasModel2);
        matakuliahModel.setKelas(kelasModels);
        return matakuliahModel;
    }

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


}
