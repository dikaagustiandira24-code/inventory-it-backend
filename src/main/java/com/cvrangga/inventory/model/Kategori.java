package com.cvrangga.inventory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "kategori")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Kategori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 100)
    private String nama;
    @Column(length = 255)
    private String deskripsi;
    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;
    public Kategori() {
    }
    public Kategori(Long id, String nama, String deskripsi, LocalDateTime createdAt) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.createdAt = createdAt;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}