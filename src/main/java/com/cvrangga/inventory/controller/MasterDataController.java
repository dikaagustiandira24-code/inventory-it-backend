package com.cvrangga.inventory.controller;

import com.cvrangga.inventory.dto.ApiResponse;
import com.cvrangga.inventory.model.Kategori;
import com.cvrangga.inventory.model.Lokasi;
import com.cvrangga.inventory.repository.KategoriRepository;
import com.cvrangga.inventory.repository.LokasiRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/master")
public class MasterDataController {

    private final KategoriRepository kategoriRepository;
    private final LokasiRepository lokasiRepository;

    public MasterDataController(KategoriRepository kategoriRepository, LokasiRepository lokasiRepository) {
        this.kategoriRepository = kategoriRepository;
        this.lokasiRepository = lokasiRepository;
    }

    @GetMapping("/kategori")
    public ResponseEntity<ApiResponse<List<Kategori>>> getAllKategori() {
        return ResponseEntity.ok(ApiResponse.success("Daftar kategori", kategoriRepository.findAll()));
    }

    @PostMapping("/kategori")
    public ResponseEntity<ApiResponse<Kategori>> createKategori(@RequestBody Kategori kategori) {
        return ResponseEntity.ok(ApiResponse.success("Kategori ditambahkan", kategoriRepository.save(kategori)));
    }

    @GetMapping("/lokasi")
    public ResponseEntity<ApiResponse<List<Lokasi>>> getAllLokasi() {
        return ResponseEntity.ok(ApiResponse.success("Daftar lokasi", lokasiRepository.findAll()));
    }

    @PostMapping("/lokasi")
    public ResponseEntity<ApiResponse<Lokasi>> createLokasi(@RequestBody Lokasi lokasi) {
        return ResponseEntity.ok(ApiResponse.success("Lokasi ditambahkan", lokasiRepository.save(lokasi)));
    }
}
