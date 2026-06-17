package com.cvrangga.inventory.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "lokasi")
public class Lokasi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nama;

    @Column(length = 100)
    private String gedung;

    @Column(length = 50)
    private String lantai;

    @Column(length = 255)
    private String keterangan;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    public Lokasi() {
    }

    public Lokasi(Long id, String nama, String gedung, String lantai, String keterangan, LocalDateTime createdAt) {
        this.id = id;
        this.nama = nama;
        this.gedung = gedung;
        this.lantai = lantai;
        this.keterangan = keterangan;
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

    public String getGedung() {
        return gedung;
    }

    public void setGedung(String gedung) {
        this.gedung = gedung;
    }

    public String getLantai() {
        return lantai;
    }

    public void setLantai(String lantai) {
        this.lantai = lantai;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
