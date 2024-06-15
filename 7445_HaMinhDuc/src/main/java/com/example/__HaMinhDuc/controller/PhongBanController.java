package com.example.__HaMinhDuc.controller;

import com.example.__HaMinhDuc.model.PhongBan;
import com.example.__HaMinhDuc.service.PhongBanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Controller cho việc quản lý các phòng ban.
 */
@Controller
@RequiredArgsConstructor
public class PhongBanController {

    @Autowired
    private final PhongBanService phongBanService;

    /**
     * Hiển thị form để thêm phòng ban mới.
     *
     * @param model đối tượng Model để truyền dữ liệu đến view
     * @return tên của view hiển thị form thêm phòng ban
     */
    @GetMapping("/phongbans/them")
    public String showAddForm(Model model) {
        model.addAttribute("phongBan", new PhongBan());
        return "/phongbans/them-phongban";
    }

    /**
     * Xử lý việc thêm phòng ban mới.
     *
     * @param phongBan đối tượng PhongBan chứa dữ liệu từ form
     * @param result đối tượng BindingResult để kiểm tra lỗi validation
     * @return redirect đến danh sách phòng ban nếu thêm thành công, ngược lại trả về form thêm phòng ban
     */
    @PostMapping("/phongbans/add")
    public String addPhongBan(@Valid PhongBan phongBan, BindingResult result) {
        if (result.hasErrors()) {
            return "/phongbans/them-phongban";
        }
        phongBanService.addPhongBan(phongBan);
        return "redirect:/phongbans";
    }

    /**
     * Hiển thị danh sách các phòng ban.
     *
     * @param model đối tượng Model để truyền dữ liệu đến view
     * @return tên của view hiển thị danh sách phòng ban
     */
    @GetMapping("/phongbans")
    public String listPhongBans(Model model) {
        List<PhongBan> phongBans = phongBanService.getAllPhongBans();
        model.addAttribute("phongBans", phongBans);
        return "/phongbans/danhsach-phongban";
    }

}
