package com.cvrangga.inventory.controller;

import com.cvrangga.inventory.dto.ApiResponse;
import com.cvrangga.inventory.dto.MutasiStokRequest;
import com.cvrangga.inventory.model.MutasiStok;
import com.cvrangga.inventory.service.MutasiStokService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mutasi")
public class MutasiStokController {

    private final MutasiStokService mutasiStokService;

    public MutasiStokController(MutasiStokService mutasiStokService) {
        this.mutasiStokService = mutasiStokService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<MutasiStok>>> getAll() {
        return ResponseEntity.ok(ApiResponse.success("Riwayat mutasi stok", mutasiStokService.getAll()));
    }

    @GetMapping("/barang/{barangId}")
    public ResponseEntity<ApiResponse<List<MutasiStok>>> getByBarang(@PathVariable Long barangId) {
        return ResponseEntity.ok(ApiResponse.success("Riwayat mutasi barang", mutasiStokService.getByBarangId(barangId)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<MutasiStok>> create(@Valid @RequestBody MutasiStokRequest request,
                                                            Authentication authentication) {
        MutasiStok mutasi = mutasiStokService.create(request, authentication.getName());
        return ResponseEntity.ok(ApiResponse.success("Mutasi stok berhasil dicatat", mutasi));
    }
}
