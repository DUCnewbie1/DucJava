package com.example.__HaMinhDuc.repository;
import com.example.__HaMinhDuc.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {
}