package com.cvrangga.inventory.service;

import com.cvrangga.inventory.dto.BarangRequest;
import com.cvrangga.inventory.model.Barang;
import com.cvrangga.inventory.model.Kategori;
import com.cvrangga.inventory.model.Lokasi;
import com.cvrangga.inventory.repository.BarangRepository;
import com.cvrangga.inventory.repository.KategoriRepository;
import com.cvrangga.inventory.repository.LokasiRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BarangService {

    private final BarangRepository barangRepository;
    private final KategoriRepository kategoriRepository;
    private final LokasiRepository lokasiRepository;

    public BarangService(BarangRepository barangRepository,
                          KategoriRepository kategoriRepository,
                          LokasiRepository lokasiRepository) {
        this.barangRepository = barangRepository;
        this.kategoriRepository = kategoriRepository;
        this.lokasiRepository = lokasiRepository;
    }

    public List<Barang> getAll() {
        return barangRepository.findAll();
    }

    public Barang getById(Long id) {
        return barangRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Barang dengan id " + id + " tidak ditemukan"));
    }

    public List<Barang> search(String keyword) {
        return barangRepository.search(keyword);
    }

    public List<Barang> getStokMenipis() {
        return barangRepository.findStokMenipis();
    }

    @Transactional
    public Barang create(BarangRequest request) {
        if (barangRepository.existsByKodeBarang(request.getKodeBarang())) {
            throw new IllegalArgumentException("Kode barang '" + request.getKodeBarang() + "' sudah digunakan");
        }

        Barang barang = new Barang();
        mapRequestToEntity(request, barang);
        return barangRepository.save(barang);
    }

    @Transactional
    public Barang update(Long id, BarangRequest request) {
        Barang barang = getById(id);

        if (!barang.getKodeBarang().equals(request.getKodeBarang())
                && barangRepository.existsByKodeBarang(request.getKodeBarang())) {
            throw new IllegalArgumentException("Kode barang '" + request.getKodeBarang() + "' sudah digunakan");
        }

        mapRequestToEntity(request, barang);
        barang.setUpdatedAt(LocalDateTime.now());
        return barangRepository.save(barang);
    }

    @Transactional
    public void delete(Long id) {
        Barang barang = getById(id);
        barangRepository.delete(barang);
    }

    private void mapRequestToEntity(BarangRequest request, Barang barang) {
        Kategori kategori = kategoriRepository.findById(request.getKategoriId())
                .orElseThrow(() -> new EntityNotFoundException("Kategori tidak ditemukan"));

        barang.setKodeBarang(request.getKodeBarang());
        barang.setNamaBarang(request.getNamaBarang());
        barang.setKategori(kategori);
        barang.setMerek(request.getMerek());
        barang.setModel(request.getModel());
        barang.setSpesifikasi(request.getSpesifikasi());
        barang.setSatuan(request.getSatuan() != null ? request.getSatuan() : "unit");
        barang.setStokMinimum(request.getStokMinimum());
        barang.setStokSekarang(request.getStokSekarang());
        barang.setHargaSatuan(request.getHargaSatuan());
        barang.setKondisi(request.getKondisi() != null ? request.getKondisi() : "BAIK");
        barang.setKeterangan(request.getKeterangan());
        barang.setFotoUrl(request.getFotoUrl());

        if (request.getLokasiId() != null) {
            Lokasi lokasi = lokasiRepository.findById(request.getLokasiId())
                    .orElseThrow(() -> new EntityNotFoundException("Lokasi tidak ditemukan"));
            barang.setLokasi(lokasi);
        }
    }
}
