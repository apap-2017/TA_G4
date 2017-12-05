package com.akademik.mahasiswa.g4.controller;

import com.akademik.mahasiswa.g4.model.db.RiwayatPerkuliahanModel;
import com.akademik.mahasiswa.g4.model.rest.KelasModel;
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
        model.addAttribute("riwayats", riwayats);
//        TODO uncomment this for see result or remove this afterall
//        System.out.println(">>>>>>>>>>>>> " + riwayats);
//        if(riwayats != null){
//            for(RiwayatPerkuliahanModel riwayat : riwayats){
//                System.out.println(" riwayat : " + riwayat);
//                for(KelasModel kelas : riwayat.getKelases()){
//                    System.out.println(">>>>>>> kelas : " + kelas);
//                }
//            }
//        }
        return "page-lihat-riwayat";
    }

}
