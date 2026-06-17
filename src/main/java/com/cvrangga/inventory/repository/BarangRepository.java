package com.cvrangga.inventory.repository;

import com.cvrangga.inventory.model.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BarangRepository extends JpaRepository<Barang, Long> {

    Optional<Barang> findByKodeBarang(String kodeBarang);

    boolean existsByKodeBarang(String kodeBarang);

    List<Barang> findByKategoriId(Long kategoriId);

    List<Barang> findByLokasiId(Long lokasiId);

    @Query("SELECT b FROM Barang b WHERE " +
           "LOWER(b.namaBarang) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(b.kodeBarang) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(b.merek) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Barang> search(@Param("keyword") String keyword);

    @Query("SELECT b FROM Barang b WHERE b.stokSekarang <= b.stokMinimum")
    List<Barang> findStokMenipis();

    @Query("SELECT COUNT(b) FROM Barang b")
    long countTotalBarang();

    @Query("SELECT COALESCE(SUM(b.stokSekarang), 0) FROM Barang b")
    long sumTotalStok();
}
