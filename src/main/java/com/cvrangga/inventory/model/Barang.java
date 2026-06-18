package com.cvrangga.inventory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "barang")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Barang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kode_barang", nullable = false, unique = true, length = 50)
    private String kodeBarang;

    @Column(name = "nama_barang", nullable = false, length = 150)
    private String namaBarang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kategori_id", nullable = false)
    private Kategori kategori;

    @Column(length = 100)
    private String merek;

    @Column(length = 100)
    private String model;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String spesifikasi;

    @Column(nullable = false, length = 30)
    private String satuan = "unit";

    @Column(name = "stok_minimum", nullable = false)
    private Integer stokMinimum = 0;

    @Column(name = "stok_sekarang", nullable = false)
    private Integer stokSekarang = 0;

    @Column(name = "harga_satuan", precision = 15, scale = 2)
    private BigDecimal hargaSatuan = BigDecimal.ZERO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lokasi_id")
    private Lokasi lokasi;

    @Column(nullable = false, length = 20)
    private String kondisi = "BAIK"; // BAIK / RUSAK / PERBAIKAN

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String keterangan;

    @Column(name = "foto_url", length = 500)
    private String fotoUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private User createdBy;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Barang() {
    }

    // Helper: cek apakah stok di bawah minimum (untuk alert)
    @Transient
    public boolean isStokMenipis() {
        return stokSekarang != null && stokMinimum != null && stokSekarang <= stokMinimum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSpesifikasi() {
        return spesifikasi;
    }

    public void setSpesifikasi(String spesifikasi) {
        this.spesifikasi = spesifikasi;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public Integer getStokMinimum() {
        return stokMinimum;
    }

    public void setStokMinimum(Integer stokMinimum) {
        this.stokMinimum = stokMinimum;
    }

    public Integer getStokSekarang() {
        return stokSekarang;
    }

    public void setStokSekarang(Integer stokSekarang) {
        this.stokSekarang = stokSekarang;
    }

    public BigDecimal getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(BigDecimal hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }

    public Lokasi getLokasi() {
        return lokasi;
    }

    public void setLokasi(Lokasi lokasi) {
        this.lokasi = lokasi;
    }

    public String getKondisi() {
        return kondisi;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}