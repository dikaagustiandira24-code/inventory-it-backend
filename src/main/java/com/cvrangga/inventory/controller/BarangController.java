package com.cvrangga.inventory.controller;

import com.cvrangga.inventory.dto.ApiResponse;
import com.cvrangga.inventory.dto.BarangRequest;
import com.cvrangga.inventory.model.Barang;
import com.cvrangga.inventory.service.BarangService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/barang")
public class BarangController {

    private final BarangService barangService;

    public BarangController(BarangService barangService) {
        this.barangService = barangService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Barang>>> getAll(
            @RequestParam(required = false) String keyword) {
        List<Barang> result = (keyword != null && !keyword.isBlank())
                ? barangService.search(keyword)
                : barangService.getAll();
        return ResponseEntity.ok(ApiResponse.success("Data barang berhasil diambil", result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Barang>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success("Data barang ditemukan", barangService.getById(id)));
    }

    @GetMapping("/stok-menipis")
    public ResponseEntity<ApiResponse<List<Barang>>> getStokMenipis() {
        return ResponseEntity.ok(ApiResponse.success("Barang dengan stok menipis", barangService.getStokMenipis()));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Barang>> create(@Valid @RequestBody BarangRequest request) {
        Barang created = barangService.create(request);
        return ResponseEntity.ok(ApiResponse.success("Barang berhasil ditambahkan", created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Barang>> update(@PathVariable Long id, @Valid @RequestBody BarangRequest request) {
        Barang updated = barangService.update(id, request);
        return ResponseEntity.ok(ApiResponse.success("Barang berhasil diupdate", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        barangService.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Barang berhasil dihapus", null));
    }
}
