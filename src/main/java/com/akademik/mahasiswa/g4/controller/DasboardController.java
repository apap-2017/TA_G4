package com.akademik.mahasiswa.g4.controller;

import com.akademik.mahasiswa.g4.model.view.DashboardModel;
import com.akademik.mahasiswa.g4.service.DashboardService;
import com.akademik.mahasiswa.g4.service.MahasiswaService;
import com.akademik.mahasiswa.g4.utls.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.function.Predicate;

@Controller
public class DasboardController {

    @Autowired
    private DashboardService dashboardService;
    @Autowired
    private MahasiswaService mahasiswaService;

    @GetMapping("/")
    public String index(){
        boolean isMahasiswa = UserUtils.userRoleIs(UserUtils.ROLE_MAHASISWA);
        if(isMahasiswa){
            return "redirect:/mahasiswa/ringkasan";
        }else{
            return "redirect:/admin";
        }
    }

    @RequestMapping(value = {"/mahasiswa/ringkasan/{npm}","/mahasiswa/ringkasan"}, method = RequestMethod.GET)
    public String displayDashboardMahasiswa(@PathVariable("npm") Optional<String> npm, Model model){
        String realNPM = null;
        if(!npm.isPresent()){
            realNPM = mahasiswaService.getNPMMahasiswa(UserUtils.getUsername());
        }else{
            realNPM = npm.get();
        }
        DashboardModel dashboard = dashboardService.getDashboardMahasiswa(realNPM);

        model.addAttribute("npm",realNPM);
        model.addAttribute("page_title", "Dashboard Mahasiswa");
        model.addAttribute("dashboard", dashboard);
        return "page-dashboard";
    }

}
