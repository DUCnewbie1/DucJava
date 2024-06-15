package com.example.__HaMinhDuc.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NHANVIEN")
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Ma_NV", nullable = false, length = 3)
    private String maNV;

    @Column(name = "Ten_NV", nullable = false, length = 100)
    private String tenNV;

    @Column(name = "Phai", length = 3)
    private String phai;

    @Column(name = "Noi_Sinh", length = 200)
    private String noiSinh;

    @ManyToOne
    @JoinColumn(name = "Ma_Phong", referencedColumnName = "Ma_Phong")
    private PhongBan maPhong;

    @Column(name = "Luong")
    private int luong;

    // Các phương thức getter và setter đã được tạo tự động bởi Lombok (@Getter và @Setter)
}
