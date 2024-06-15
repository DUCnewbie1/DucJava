package com.example.__HaMinhDuc.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phongban")
public class PhongBan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma_phong", nullable = false, length = 2)
    private String maPhong;

    @Column(name = "ten_phong", nullable = false, length = 30)
    private String tenPhong;
}
