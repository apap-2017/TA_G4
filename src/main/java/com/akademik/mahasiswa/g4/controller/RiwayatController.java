package com.akademik.mahasiswa.g4.controller;

import com.akademik.mahasiswa.g4.model.db.RiwayatPerkuliahanModel;
import com.akademik.mahasiswa.g4.service.RiwayatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RiwayatController {

    @Autowired
    private RiwayatService riwayatService;

    @RequestMapping(value = "/riwayat/{npm}")
    public String getRiwayatMahasiswa(@PathVariable("npm") String npm, Model model){
        List<RiwayatPerkuliahanModel> riwayats = riwayatService.getAllRiwayatMahasiswa(npm);
        model.addAttribute("page_title", "Lihat Riwayat");
        model.addAttribute("riwayats", riwayats);
        return "page-lihat-riwayat";
    }

    @RequestMapping(value = "/riwayat")
    public String getRiwayatMahasiswa(Model model){
        List<RiwayatPerkuliahanModel> riwayats = riwayatService.getAllRiwayatMahasiswa();
        model.addAttribute("page_title", "Lihat Riwayat");
        model.addAttribute("riwayats", riwayats);
        return "page-lihat-riwayat";
    }

}
