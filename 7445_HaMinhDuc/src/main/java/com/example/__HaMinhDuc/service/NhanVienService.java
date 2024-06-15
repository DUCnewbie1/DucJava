package com.example.__HaMinhDuc.service;

import com.example.__HaMinhDuc.model.NhanVien;
import com.example.__HaMinhDuc.repository.NhanVienRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class NhanVienService {

    private final NhanVienRepository nhanVienRepository;

    // Retrieve all employees from the database
    public List<NhanVien> getAllNhanViens() {
        return nhanVienRepository.findAll();
    }

    // Retrieve an employee by its id
    public Optional<NhanVien> getNhanVienById(Long id) {
        return nhanVienRepository.findById(id);
    }

    // Add a new employee to the database
    public NhanVien addNhanVien(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    // Update an existing employee
    public NhanVien updateNhanVien(@NotNull NhanVien nhanVien) {
        NhanVien existingNhanVien = nhanVienRepository.findById(nhanVien.getId())
                .orElseThrow(() -> new IllegalStateException("Employee with ID " +
                        nhanVien.getId() + " does not exist."));
        existingNhanVien.setMaNV(nhanVien.getMaNV());
        existingNhanVien.setTenNV(nhanVien.getTenNV());
        existingNhanVien.setPhai(nhanVien.getPhai());
        existingNhanVien.setNoiSinh(nhanVien.getNoiSinh());
        existingNhanVien.setMaPhong(nhanVien.getMaPhong());
        existingNhanVien.setLuong(nhanVien.getLuong());
        return nhanVienRepository.save(existingNhanVien);
    }

    // Delete an employee by its id
    public void deleteNhanVienById(Long id) {
        if (!nhanVienRepository.existsById(id)) {
            throw new IllegalStateException("Employee with ID " + id + " does not exist.");
        }
        nhanVienRepository.deleteById(id);
    }
}
