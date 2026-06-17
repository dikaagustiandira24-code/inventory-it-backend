package com.cvrangga.inventory.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class BarangRequest {

    @NotBlank(message = "Kode barang wajib diisi")
    private String kodeBarang;

    @NotBlank(message = "Nama barang wajib diisi")
    private String namaBarang;

    @NotNull(message = "Kategori wajib dipilih")
    private Long kategoriId;

    private String merek;
    private String model;
    private String spesifikasi;
    private String satuan;

    @NotNull(message = "Stok minimum wajib diisi")
    private Integer stokMinimum;

    @NotNull(message = "Stok sekarang wajib diisi")
    private Integer stokSekarang;

    private BigDecimal hargaSatuan;
    private Long lokasiId;
    private String kondisi;
    private String keterangan;
    private String fotoUrl;

    public BarangRequest() {
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

    public Long getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(Long kategoriId) {
        this.kategoriId = kategoriId;
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

    public Long getLokasiId() {
        return lokasiId;
    }

    public void setLokasiId(Long lokasiId) {
        this.lokasiId = lokasiId;
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
}
