package com.cvrangga.inventory.repository;

import com.cvrangga.inventory.model.MutasiStok;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MutasiStokRepository extends JpaRepository<MutasiStok, Long> {
    List<MutasiStok> findByBarangIdOrderByTanggalMutasiDesc(Long barangId);
    List<MutasiStok> findAllByOrderByTanggalMutasiDesc();
}
