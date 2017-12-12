package com.akademik.mahasiswa.g4.controller;

import com.akademik.mahasiswa.g4.model.view.DashboardModel;
import com.akademik.mahasiswa.g4.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DasboardController {

    @Autowired
    private DashboardService dashboardService;

    @RequestMapping(value = "/mahasiswa/ringkasan/{npm}", method = RequestMethod.GET)
    public String displayDashboardMahasiswa(@PathVariable("npm") String npm, Model model){
        DashboardModel dashboard = dashboardService.getDashboardMahasiswa(npm);
        model.addAttribute("page_title", "Dashboard Mahasiswa");
        model.addAttribute("dashboard", dashboard);
        return "page-dashboard";
    }

}
