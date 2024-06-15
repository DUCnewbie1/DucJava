package com.example.__HaMinhDuc.service;

import com.example.__HaMinhDuc.model.PhongBan;
import com.example.__HaMinhDuc.repository.PhongBanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * Lớp dịch vụ để quản lý các phòng ban.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class PhongBanService {

    private final PhongBanRepository phongBanRepository;

    /**
     * Lấy tất cả các phòng ban từ cơ sở dữ liệu.
     *
     * @return danh sách các phòng ban
     */
    public List<PhongBan> getAllPhongBans() {
        return phongBanRepository.findAll();
    }

    /**
     * Lấy một phòng ban dựa trên id.
     *
     * @param id id của phòng ban cần lấy
     * @return một Optional chứa phòng ban tìm thấy hoặc rỗng nếu không tìm thấy
     */
    public Optional<PhongBan> getPhongBanById(Long id) {
        return phongBanRepository.findById(id);
    }

    /**
     * Thêm một phòng ban mới vào cơ sở dữ liệu.
     *
     * @param phongBan phòng ban cần thêm
     */
    public void addPhongBan(PhongBan phongBan) {
        phongBanRepository.save(phongBan);
    }

    /**
     * Cập nhật thông tin của một phòng ban đã tồn tại.
     *
     * @param phongBan phòng ban có thông tin cập nhật
     */
    public void updatePhongBan(@NotNull PhongBan phongBan) {
        PhongBan existingPhongBan = phongBanRepository.findById(phongBan.getId())
                .orElseThrow(() -> new IllegalStateException("PhongBan với ID " +
                        phongBan.getId() + " không tồn tại."));
        existingPhongBan.setMaPhong(phongBan.getMaPhong());
        existingPhongBan.setTenPhong(phongBan.getTenPhong());
        phongBanRepository.save(existingPhongBan);
    }

    /**
     * Xóa một phòng ban dựa trên id.
     *
     * @param id id của phòng ban cần xóa
     */
    public void deletePhongBanById(Long id) {
        if (!phongBanRepository.existsById(id)) {
            throw new IllegalStateException("PhongBan với ID " + id + " không tồn tại.");
        }
        phongBanRepository.deleteById(id);
    }
}
