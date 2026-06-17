package com.cvrangga.inventory.service;

import com.cvrangga.inventory.dto.MutasiStokRequest;
import com.cvrangga.inventory.model.Barang;
import com.cvrangga.inventory.model.MutasiStok;
import com.cvrangga.inventory.model.User;
import com.cvrangga.inventory.repository.BarangRepository;
import com.cvrangga.inventory.repository.MutasiStokRepository;
import com.cvrangga.inventory.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MutasiStokService {

    private final MutasiStokRepository mutasiStokRepository;
    private final BarangRepository barangRepository;
    private final UserRepository userRepository;

    public MutasiStokService(MutasiStokRepository mutasiStokRepository,
                              BarangRepository barangRepository,
                              UserRepository userRepository) {
        this.mutasiStokRepository = mutasiStokRepository;
        this.barangRepository = barangRepository;
        this.userRepository = userRepository;
    }

    public List<MutasiStok> getAll() {
        return mutasiStokRepository.findAllByOrderByTanggalMutasiDesc();
    }

    public List<MutasiStok> getByBarangId(Long barangId) {
        return mutasiStokRepository.findByBarangIdOrderByTanggalMutasiDesc(barangId);
    }

    @Transactional
    public MutasiStok create(MutasiStokRequest request, String username) {
        Barang barang = barangRepository.findById(request.getBarangId())
                .orElseThrow(() -> new EntityNotFoundException("Barang tidak ditemukan"));

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User tidak ditemukan"));

        int stokSebelum = barang.getStokSekarang();
        int stokSesudah;

        String jenis = request.getJenis().toUpperCase();
        switch (jenis) {
            case "MASUK":
                stokSesudah = stokSebelum + request.getJumlah();
                break;
            case "KELUAR":
                stokSesudah = stokSebelum - request.getJumlah();
                if (stokSesudah < 0) {
                    throw new IllegalArgumentException(
                        "Stok tidak cukup. Stok saat ini: " + stokSebelum + ", diminta: " + request.getJumlah());
                }
                break;
            case "PENYESUAIAN":
                stokSesudah = request.getJumlah();
                break;
            default:
                throw new IllegalArgumentException("Jenis mutasi tidak valid. Gunakan: MASUK, KELUAR, atau PENYESUAIAN");
        }

        barang.setStokSekarang(stokSesudah);
        barangRepository.save(barang);

        MutasiStok mutasi = new MutasiStok();
        mutasi.setBarang(barang);
        mutasi.setJenis(jenis);
        mutasi.setJumlah(request.getJumlah());
        mutasi.setStokSebelum(stokSebelum);
        mutasi.setStokSesudah(stokSesudah);
        mutasi.setKeterangan(request.getKeterangan());
        mutasi.setLokasiTujuan(request.getLokasiTujuan());
        mutasi.setDipinjamOleh(request.getDipinjamOleh());
        mutasi.setCreatedBy(user);

        return mutasiStokRepository.save(mutasi);
    }
}
