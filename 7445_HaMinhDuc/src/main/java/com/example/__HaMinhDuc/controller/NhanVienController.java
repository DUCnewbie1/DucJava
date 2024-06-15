package com.example.__HaMinhDuc.controller;

import com.example.__HaMinhDuc.model.NhanVien;
import com.example.__HaMinhDuc.service.NhanVienService;
import com.example.__HaMinhDuc.service.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/nhanviens")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private PhongBanService phongBanService;

    // Display a list of all employees
    @GetMapping
    public String showNhanVienList(Model model) {
        model.addAttribute("nhanViens", nhanVienService.getAllNhanViens());
        return "nhanviens/nhanvien-danhsach";
    }

    // For adding a new employee
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("nhanVien", new NhanVien());
        model.addAttribute("phongBans", phongBanService.getAllPhongBans()); // Load departments
        return "nhanviens/add-nhanvien";
    }

    // Process the form for adding a new employee
    @PostMapping("/add")
    public String addNhanVien(@Valid NhanVien nhanVien, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("phongBans", phongBanService.getAllPhongBans()); // Reload departments
            return "nhanviens/add-nhanvien";
        }
        nhanVienService.addNhanVien(nhanVien);
        return "redirect:/nhanviens";
    }

    // For editing an employee
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        NhanVien nhanVien = nhanVienService.getNhanVienById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        model.addAttribute("nhanVien", nhanVien);
        model.addAttribute("phongBans", phongBanService.getAllPhongBans()); // Load departments
        return "/nhanviens/update-nhanvien";
    }

    // Process the form for updating an employee
    @PostMapping("/update/{id}")
    public String updateNhanVien(@PathVariable Long id, @Valid NhanVien nhanVien, BindingResult result, Model model) {
        if (result.hasErrors()) {
            nhanVien.setId(id); // set id to keep it in the form in case of errors
            model.addAttribute("phongBans", phongBanService.getAllPhongBans()); // Reload departments
            return "/nhanviens/update-nhanvien";
        }
        nhanVienService.updateNhanVien(nhanVien);
        return "redirect:/nhanviens";
    }

    // Handle request to delete an employee
    @GetMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable Long id) {
        nhanVienService.deleteNhanVienById(id);
        return "redirect:/nhanviens";
    }
}
