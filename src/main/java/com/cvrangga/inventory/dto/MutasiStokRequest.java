package com.cvrangga.inventory.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class MutasiStokRequest {

    @NotNull(message = "Barang wajib dipilih")
    private Long barangId;

    @NotBlank(message = "Jenis mutasi wajib diisi (MASUK/KELUAR/PENYESUAIAN)")
    private String jenis;

    @NotNull(message = "Jumlah wajib diisi")
    @Positive(message = "Jumlah harus lebih dari 0")
    private Integer jumlah;

    private String keterangan;
    private String lokasiTujuan;
    private String dipinjamOleh;

    public MutasiStokRequest() {
    }

    public Long getBarangId() {
        return barangId;
    }

    public void setBarangId(Long barangId) {
        this.barangId = barangId;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getLokasiTujuan() {
        return lokasiTujuan;
    }

    public void setLokasiTujuan(String lokasiTujuan) {
        this.lokasiTujuan = lokasiTujuan;
    }

    public String getDipinjamOleh() {
        return dipinjamOleh;
    }

    public void setDipinjamOleh(String dipinjamOleh) {
        this.dipinjamOleh = dipinjamOleh;
    }
}
