package org.example.service;

import org.example.entity.SinhVien;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SinhVienServiceTest {

    private SinhVienService sinhVienService;

    @BeforeEach
    void setUp() {
        sinhVienService = new SinhVienService();
    }

    @Test
    void addSinhVienWithValidStudent() {
        SinhVien sinhVien = new SinhVien("SV1", "Kien", 20, 7, 2, "IT");
        sinhVienService.addSinhVien(sinhVien);

        assertEquals(1, sinhVienService.getAllSinhVien().size());
    }

    @Test
    void addSinhVienWithNull(){
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> sinhVienService.addSinhVien(null));
        assertEquals("Sinh viên không thể trống", exception.getMessage());

    }

    @Test
    void addSinhVienWithInvalidMaSV(){
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> sinhVienService.addSinhVien(new SinhVien("", "Kien", 20, 7, 2, "IT")));
        assertEquals("Mã sinh viên k được trống", exception.getMessage());
    }

    @Test
    void addSinhVienWithInvalidName(){
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new SinhVien("SV1", "", 20, 7, 2, "IT"));
        assertEquals("Tên sinh viên k được trống", exception.getMessage());
    }

    @Test
    void addSinhVienWithInvalidTuoi(){
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new SinhVien("SV1", "Kien", 17, 7, 2, "IT"));
        assertEquals("Tuổi sinh viên k được hơn 18", exception.getMessage());
    }

    @Test
    void getSinhVienByMaWithValidId() {
        SinhVien sinhVien = new SinhVien("SV1", "Kien", 20, 7, 2, "IT");
        sinhVienService.addSinhVien(sinhVien);

        assertEquals(Optional.of(sinhVien), sinhVienService.getSinhVienByMa("SV1"));
    }

    @Test
    void getSinhVienByMaWithInvalidMa(){
        SinhVien sinhVien = new SinhVien("SV1", "Kien", 20, 7, 2, "IT");
        sinhVienService.addSinhVien(sinhVien);

        assertEquals(Optional.empty(), sinhVienService.getSinhVienByMa("SV2"));
    }


    @Test
    void updateSinhVienWithValidSinhVien() {
        SinhVien sinhVien = new SinhVien("SV1", "Kien", 20, 7, 2, "IT");
        sinhVienService.addSinhVien(sinhVien);

        sinhVien.setMaSV("SV1");
        sinhVien.setTen("Quyet");
        sinhVien.setTuoi(18);
        sinhVien.setDiemTB(8);
        sinhVien.setKyHoc(1);
        sinhVien.setChuyenNganh("Marketing");
        sinhVienService.updateSinhVien(sinhVien);

        assertEquals("Quyet", sinhVienService.getSinhVienByMa("SV1").get().getTen());
        assertEquals(18, sinhVienService.getSinhVienByMa("SV1").get().getTuoi());
        assertEquals(8, sinhVienService.getSinhVienByMa("SV1").get().getDiemTB());
        assertEquals(1, sinhVienService.getSinhVienByMa("SV1").get().getKyHoc());
        assertEquals("Marketing", sinhVienService.getSinhVienByMa("SV1").get().getChuyenNganh());

    }

    @Test
    void updateStudentWithNull(){
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> sinhVienService.updateSinhVien(null));
        assertEquals("Sinh viên không được để trống", exception.getMessage());
    }
    @Test
    void updateStudentWithInvalidMa(){
        SinhVien sinhVien = new SinhVien("SV1", "Kien", 20, 7, 2, "IT");
        sinhVienService.addSinhVien(sinhVien);
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> sinhVienService.updateSinhVien(new SinhVien("SV2", "Quyet", 21, 8, 2, "marketing")));
        assertEquals("Sinh viên với mãSV2không tồn tại", exception.getMessage());
    }

    @Test
    void updateSinhVienWithInvalidTen(){
        SinhVien sinhVien = new SinhVien("SV1", "Kien", 20, 7, 2, "IT");
        sinhVienService.addSinhVien(sinhVien);
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> sinhVienService.updateSinhVien(new SinhVien("SV2", "",20, 8, 4, "IT")));
        assertEquals("Tên sinh viên k được trống", exception.getMessage());
    }

    @Test
    void updateSinhVienWithInvalidTuoi(){
        SinhVien sinhVien = new SinhVien("SV1", "Kien", 20, 7, 2, "IT");
        sinhVienService.addSinhVien(sinhVien);
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> sinhVienService.updateSinhVien(new SinhVien("SV1", "Kien", 17, 7, 2, "IT")));
    }

    @Test
    void deleteSinhVienWithValidMa() {
        SinhVien sinhVien = new SinhVien("SV1", "Kien", 20, 7, 2, "IT");
        sinhVienService.addSinhVien(sinhVien);

        sinhVienService.deleteSinhVien("SV2");
        assertEquals(0, sinhVienService.getAllSinhVien().size());
    }

    @Test
    void deleteSinhVienWithInValidMa(){
        SinhVien sinhVien = new SinhVien("SV1", "Kien", 20, 7, 2, "IT");
        sinhVienService.addSinhVien(sinhVien);

        assertFalse(sinhVienService.deleteSinhVien("SV2"));
        assertEquals(1, sinhVienService.getAllSinhVien().size());

    }

    @Test
    void deleteSinhVienWhenListIsEmpty() {
        assertFalse(sinhVienService.deleteSinhVien("SV1")); // Không có sinh viên nào để xóa
        assertEquals(0, sinhVienService.getAllSinhVien().size()); // Danh sách vẫn rỗng
    }
    @Test
    void checkExistingSinhVienByMa() {
        // Kiểm tra mã số tồn tại trong danh sách
        SinhVien sinhVien = new SinhVien("SV1", "Kien", 20, 7, 2, "IT");
        sinhVienService.addSinhVien(sinhVien);

        assertTrue(sinhVienService.getSinhVienByMa("SV1").isPresent());
    }

    @Test
    void checkNonExistingSinhVienByMa() {
        // Kiểm tra mã số không tồn tại
        assertFalse(sinhVienService.getSinhVienByMa("SV99").isPresent());
    }

    @Test
    void getAllSinhVien() {
        assertEquals(0, sinhVienService.getAllSinhVien().size());

        // Thêm 2 sinh viên
        SinhVien sinhVien1 = new SinhVien("SV1", "Kien", 20, 7, 2, "IT");
        SinhVien sinhVien2 = new SinhVien("SV2", "Quyet", 21, 8, 3, "Business");
        sinhVienService.addSinhVien(sinhVien1);
        sinhVienService.addSinhVien(sinhVien2);

        // Kiểm tra số lượng
        assertEquals(2, sinhVienService.getAllSinhVien().size());
        assertTrue(sinhVienService.getAllSinhVien().contains(sinhVien1));
        assertTrue(sinhVienService.getAllSinhVien().contains(sinhVien2));
    }
}