package com.akademik.mahasiswa.g4.controller;

import com.akademik.mahasiswa.g4.mapper.MahasiswaMapper;
import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.akademik.mahasiswa.g4.model.rest.UnivModel;
import com.akademik.mahasiswa.g4.service.MahasiswaService;
import com.akademik.mahasiswa.g4.service.UnivService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private MahasiswaService mahasiswaService;

    @Autowired
    private UnivService univService;

    @RequestMapping("/admin")
    public String home()
    {
        return "home-admin";
    }

    @RequestMapping("/admin/addmahasiswa")
    public String goToAddmahasiswa(Model model)
    {
        model.addAttribute("page-title","Add Mahasiswa");
        return "add-mahasiswa-form";
    }

    @RequestMapping("/admin/addmahasiswa/submit")
    public String addMahasiswa(@RequestParam(value = "nama", required = false) String nama,
                                @RequestParam(value = "npm", required = false) String npm,
                                @RequestParam(value = "angkatan", required = false) String angkatan,
                                @RequestParam(value = "univ", required = false) String univ,
                                @RequestParam(value = "fakultas", required = false) String fakultas,
                                @RequestParam(value = "prodi", required = false) String prodi,
                                @RequestParam(value = "username", required = false) String username,
                                @RequestParam(value = "password", required = false) String password,
                            Model model)
    {
        String hasilUniv = univService.checkUniv(univ);

        if(hasilUniv.equals("invalid-univ")) {

            model.addAttribute("page-title","Invalid Univ");
            model.addAttribute("invalidity","Universitas Tidak Tersedia");
            return "add-mahasiswa-form";

        }else {

            String idUniv = univService.convertUniv(univ);

            String hasilFakultas = univService.checkFakultas(idUniv, fakultas);

            if(hasilFakultas.equals("invalid-fakultas")) {

                model.addAttribute("page-title", "Invalid Fakultas");
                model.addAttribute("invalidity", "Fakultas Tidak tersedia pada " + univ);
                return "add-mahasiswa-form";

            }else {

                String idFakultas = univService.convertFakultas(idUniv, fakultas);

                String hasilProdi = univService.checkProdi(idUniv, idFakultas, prodi);

                if(hasilProdi.equals("invalid-prodi")) {

                    model.addAttribute("page-title", "Invalid Prodi");
                    model.addAttribute("invalidity", "Prodi Tidak tersedia pada " + univ + " , " + fakultas);
                    return "add-mahasiswa-form";

                }else {

                    String idProdi = univService.convertProdi(idUniv, idFakultas, prodi);

                    MahasiswaDBModel newMahasiswa = new MahasiswaDBModel();
                    newMahasiswa.setNama(nama);
                    newMahasiswa.setNpm(npm);
                    newMahasiswa.setUsername(username);
                    newMahasiswa.setPassword(password);
                    newMahasiswa.setIdUniv(Integer.parseInt(idUniv));
                    newMahasiswa.setIdFakultas(Integer.parseInt(idFakultas));
                    newMahasiswa.setIdProdi(Integer.parseInt(idProdi));
                    newMahasiswa.setAngkatan(angkatan);

                    mahasiswaService.addUserMahasiswaToDB(newMahasiswa);

                    model.addAttribute("page-title","Sukses Add Mahasiswa");
                    model.addAttribute("npm",newMahasiswa.getNpm());
                    return "add-mahasiswa-sukses";

                }
            }
        }
    }

    @RequestMapping("/admin/viewmahasiswa")
    public String viewMahasiswa(@RequestParam(value = "npm", required = false) String npm, Model model)
    {
        MahasiswaDBModel mahasiswa = mahasiswaService.getMahasiswaWithUniv(npm);
        if(mahasiswa == null) {
            model.addAttribute("invalidity", "Mahasiswa dengan npm "+ npm + " tidak ditemukan");
            model.addAttribute("page-title","View Mahasiswa");
            return "view-mahasiswa";
        }else {
            model.addAttribute("mahasiswa",mahasiswa);
            model.addAttribute("page-title","View Mahasiswa");
            return "view-mahasiswa";
        }
    }

    @RequestMapping("/admin/viewallmahasiswa")
    public String viewAllMahasiswa(Model model)
    {
        List<MahasiswaDBModel> mahasiswas = mahasiswaService.getAllMahasiswa();
        model.addAttribute("mahasiswas",mahasiswas);
        model.addAttribute("page-title","View All Mahasiswa");

        return "viewall-mahasiswa";
    }



}


