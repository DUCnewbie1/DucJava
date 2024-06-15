package com.example.__HaMinhDuc.repository;
import com.example.__HaMinhDuc.model.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PhongBanRepository extends JpaRepository<PhongBan, Long> {
}