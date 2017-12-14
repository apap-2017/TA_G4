package com.akademik.mahasiswa.g4.controller;

import com.akademik.mahasiswa.g4.mapper.MahasiswaMapper;
import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.akademik.mahasiswa.g4.model.rest.UnivModel;
import com.akademik.mahasiswa.g4.service.MahasiswaService;
import com.akademik.mahasiswa.g4.service.UnivService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private MahasiswaService mahasiswaService;

    @Autowired
    private UnivService univService;

    @RequestMapping("/admin")
    public String home(Model model)
    {
        model.addAttribute("page_title","Home Admin");
        return "home-admin";
    }

    @RequestMapping("/admin/addmahasiswa")
    public String goToAddmahasiswa(Model model)
    {
        List<UnivModel> univs = univService.getAllUniv();
        model.addAttribute("univs", univs);
        model.addAttribute("page_title","Add Mahasiswa");

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

        if(mahasiswaService.checkNPM(npm).equals("npm-duplikat")) {
            List<UnivModel> univs = univService.getAllUniv();
            model.addAttribute("univs", univs);
            model.addAttribute("page_title", "Invalid NPM");
            model.addAttribute("invalidity", "NPM " + npm + " sudah terdaftar");
            return "add-mahasiswa-form";
        }

        if(mahasiswaService.checkUsername(username).equalsIgnoreCase("username-duplikat")) {
            List<UnivModel> univs = univService.getAllUniv();
            model.addAttribute("univs", univs);
            model.addAttribute("page_title", "Invalid Username");
            model.addAttribute("invalidity", "Username " + username + " sudah terdaftar");
            return "add-mahasiswa-form";
        }

        int idUniv = univService.convertUniv(univ);

        String hasilFakultas = univService.checkFakultas(idUniv, fakultas);

        if(hasilFakultas.equals("invalid-fakultas")) {
            List<UnivModel> univs = univService.getAllUniv();
            model.addAttribute("univs", univs);
            model.addAttribute("page_title", "Invalid Fakultas");
            model.addAttribute("invalidity", "Fakultas Tidak tersedia pada " + univ);
            return "add-mahasiswa-form";

        }else {

            int idFakultas = univService.convertFakultas(idUniv, fakultas);

            String hasilProdi = univService.checkProdi(idUniv, idFakultas, prodi);

            if(hasilProdi.equals("invalid-prodi")) {
                List<UnivModel> univs = univService.getAllUniv();
                model.addAttribute("univs", univs);
                model.addAttribute("page_title", "Invalid Prodi");
                model.addAttribute("invalidity", "Prodi Tidak tersedia pada " + univ + " , " + fakultas);
                return "add-mahasiswa-form";

            }else {

                int idProdi = univService.convertProdi(idUniv, idFakultas, prodi);

                MahasiswaDBModel newMahasiswa = new MahasiswaDBModel();
                newMahasiswa.setNama(nama);
                newMahasiswa.setNpm(npm);
                newMahasiswa.setUsername(username);
                newMahasiswa.setPassword(password);
                newMahasiswa.setIdUniv(idUniv);
                newMahasiswa.setIdFakultas(idFakultas);
                newMahasiswa.setIdProdi(idProdi);
                newMahasiswa.setAngkatan(angkatan);

                mahasiswaService.addUserMahasiswaToDB(newMahasiswa);

                model.addAttribute("page_title","Mahasiswa Added");
                model.addAttribute("npm",newMahasiswa.getNpm());
                return "add-mahasiswa-sukses";

            }
        }

    }

    @RequestMapping("/admin/viewmahasiswa")
    public String viewMahasiswa(@RequestParam(value = "npm", required = false) String npm, Model model)
    {
        MahasiswaDBModel mahasiswa = mahasiswaService.getMahasiswaWithUniv(npm);
        if(mahasiswa == null) {
            model.addAttribute("invalidity", "Mahasiswa dengan npm "+ npm + " tidak ditemukan");
            model.addAttribute("page_title","View Mahasiswa");
            return "home-admin";
        }else {
            model.addAttribute("mahasiswa",mahasiswa);
            model.addAttribute("page_title","View Mahasiswa");
            return "view-mahasiswa";
        }
    }

    @RequestMapping("/admin/viewallmahasiswa")
    public String viewAllMahasiswa(Model model)
    {
        List<MahasiswaDBModel> mahasiswas = mahasiswaService.getAllMahasiswa();
        model.addAttribute("mahasiswas",mahasiswas);
        model.addAttribute("page_title","View All Mahasiswa");

        return "viewall-mahasiswa";
    }

    @RequestMapping("/admin/update/{npm}")
    public String update (@PathVariable(value = "npm") String npm, Model model)
    {
        MahasiswaDBModel  mahasiswa = mahasiswaService.getMahasiswaAllData(npm);
        model.addAttribute("npm", mahasiswa.getNpm());
        model.addAttribute ("mahasiswa", mahasiswa);

        model.addAttribute("page_title", "Update Mahasiswa");
        return "update-mahasiswa-form";
    }

    @RequestMapping(value = "/admin/update/submit/{npm}", method = RequestMethod.POST)
    public String updateSubmit(@PathVariable(value = "npm") String npm, MahasiswaDBModel mahasiswa, Model model)
    {
        if(mahasiswaService.checkNPM(mahasiswa.getNpm()).equals("npm-duplikat") && !npm.equals(mahasiswa.getNpm())) {
            MahasiswaDBModel  mahasiswaLama = mahasiswaService.getMahasiswaAllData(npm);
            model.addAttribute("npm", npm);
            model.addAttribute ("mahasiswa", mahasiswaLama);
            model.addAttribute("page_title", "Invalid NPM");
            model.addAttribute("invalidity", "NPM " + mahasiswa.getNpm() + " sudah terdaftar");
            return "update-mahasiswa-form";
        }

        String hasilUniv = univService.checkUniv(mahasiswa.getNamaUniv());

        if(hasilUniv.equals("invalid-univ")) {
            MahasiswaDBModel  mahasiswaLama = mahasiswaService.getMahasiswaAllData(npm);
            model.addAttribute("npm", mahasiswaLama.getNpm());
            model.addAttribute ("mahasiswa", mahasiswaLama);

            model.addAttribute("page_title", "Invalid Universitas");
            model.addAttribute("invalidity", "Universitas Tidak tersedia");
            return "update-mahasiswa-form";
        }else {
            int idUniv = univService.convertUniv(mahasiswa.getNamaUniv());

            String hasilFakultas = univService.checkFakultas(idUniv, mahasiswa.getNamaFakultas());

            if(hasilFakultas.equals("invalid-fakultas")) {
                MahasiswaDBModel  mahasiswaLama = mahasiswaService.getMahasiswaAllData(npm);
                model.addAttribute("npm", mahasiswaLama.getNpm());
                model.addAttribute ("mahasiswa", mahasiswaLama);

                model.addAttribute("page_title", "Invalid Fakultas");
                model.addAttribute("invalidity", "Fakultas Tidak tersedia pada " + mahasiswa.getNamaUniv());
                return "update-mahasiswa-form";
            }else {

                int idFakultas = univService.convertFakultas(idUniv, mahasiswa.getNamaFakultas());

                String hasilProdi = univService.checkProdi(idUniv, idFakultas, mahasiswa.getNamaProdi());

                if(hasilProdi.equals("invalid-prodi")) {
                    MahasiswaDBModel  mahasiswaLama = mahasiswaService.getMahasiswaAllData(npm);
                    model.addAttribute("npm", mahasiswaLama.getNpm());
                    model.addAttribute ("mahasiswa", mahasiswaLama);

                    model.addAttribute("page_title", "Invalid Prodi");
                    model.addAttribute("invalidity", "Prodi Tidak tersedia pada " + mahasiswa.getNamaUniv()
                            + " , " + mahasiswa.getNamaFakultas());
                    return "update-mahasiswa-form";

                }else {

                    int idProdi = univService.convertProdi(idUniv, idFakultas, mahasiswa.getNamaProdi());

                    MahasiswaDBModel newMahasiswa = new MahasiswaDBModel();
                    newMahasiswa.setNama(mahasiswa.getNama());
                    newMahasiswa.setNpm(mahasiswa.getNpm());
                    newMahasiswa.setUsername(mahasiswa.getUsername());
                    newMahasiswa.setPassword(mahasiswa.getPassword());
                    newMahasiswa.setIdUniv(idUniv);
                    newMahasiswa.setIdFakultas(idFakultas);
                    newMahasiswa.setIdProdi(idProdi);
                    newMahasiswa.setAngkatan(mahasiswa.getAngkatan());

                    mahasiswaService.updateUserMahasiswaToDB(newMahasiswa);

                    model.addAttribute("page_title", "Mahasiswa Updated");
                    model.addAttribute("npmLama", npm);
                    model.addAttribute("npmBaru", newMahasiswa.getNpm());
                    return "update-mahasiswa-sukses";

                }
            }
        }
    }

    @RequestMapping("/admin/viewallmahasiswa/delete/{npm}")
    public String deleteFromAll(@PathVariable(value = "npm") String npm, Model model)
    {
        MahasiswaDBModel mahasiswa = mahasiswaService.getMahasiswa(npm);
        model.addAttribute("invalidity", "Mahasiswa dengan NPM " + mahasiswa.getNpm() + " berhasil dihapus");
        mahasiswaService.deleteMahasiswaFromDB(mahasiswa);

        List<MahasiswaDBModel> mahasiswas = mahasiswaService.getAllMahasiswa();
        model.addAttribute("mahasiswas",mahasiswas);
        model.addAttribute("page_title","Mahasiswa Deleted");

        return "viewall-mahasiswa";
    }

    @RequestMapping("/admin/viewmahasiswa/delete/{npm}")
    public String deleteFromOne(@PathVariable(value = "npm") String npm, Model model)
    {
        MahasiswaDBModel mahasiswa = mahasiswaService.getMahasiswa(npm);
        model.addAttribute("invalidity", "Mahasiswa dengan NPM " + mahasiswa.getNpm() + " berhasil dihapus");
        mahasiswaService.deleteMahasiswaFromDB(mahasiswa);
        model.addAttribute("page_title","Mahasiswa Deleted");

        return "home-admin";
    }



}


