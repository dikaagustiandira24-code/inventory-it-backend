package com.cvrangga.inventory.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "mutasi_stok")
public class MutasiStok {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "barang_id", nullable = false)
    private Barang barang;

    @Column(nullable = false, length = 10)
    private String jenis; // MASUK / KELUAR / PENYESUAIAN

    @Column(nullable = false)
    private Integer jumlah;

    @Column(name = "stok_sebelum", nullable = false)
    private Integer stokSebelum;

    @Column(name = "stok_sesudah", nullable = false)
    private Integer stokSesudah;

    @Column(length = 500)
    private String keterangan;

    @Column(name = "lokasi_tujuan", length = 200)
    private String lokasiTujuan;

    @Column(name = "dipinjam_oleh", length = 100)
    private String dipinjamOleh;

    @Column(name = "tanggal_mutasi", insertable = false, updatable = false)
    private LocalDateTime tanggalMutasi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    public MutasiStok() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
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

    public Integer getStokSebelum() {
        return stokSebelum;
    }

    public void setStokSebelum(Integer stokSebelum) {
        this.stokSebelum = stokSebelum;
    }

    public Integer getStokSesudah() {
        return stokSesudah;
    }

    public void setStokSesudah(Integer stokSesudah) {
        this.stokSesudah = stokSesudah;
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

    public LocalDateTime getTanggalMutasi() {
        return tanggalMutasi;
    }

    public void setTanggalMutasi(LocalDateTime tanggalMutasi) {
        this.tanggalMutasi = tanggalMutasi;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
