package org.example.service;

import org.example.entity.SinhVien;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SinhVienService {
    private List<SinhVien> student = new ArrayList<>();

    public void addSinhVien(SinhVien sinhVien) {
        if (sinhVien == null) {
            throw new IllegalArgumentException("Sinh viên không thể trống");
        }

        student.add(sinhVien);
    }

    public Optional<SinhVien> getSinhVienByMa(String maSV){
        return student
                .stream()
                .filter(sv -> sv.getMaSV().equalsIgnoreCase(maSV))
                .findFirst();
    }


    public void updateSinhVien(SinhVien sinhVien){

        if(sinhVien == null){
            throw new IllegalArgumentException("Sinh viên không được để trống");
        }

        Optional<SinhVien> existingSinhVien = getSinhVienByMa(sinhVien.getMaSV());
        if(existingSinhVien.isPresent()){
            student.set(student.indexOf(existingSinhVien.get()), sinhVien);

        }else {
            throw  new IllegalArgumentException("Sinh viên với mã" + sinhVien.getMaSV() + "không tồn tại");
        }
    }

    public boolean deleteSinhVien(String maSV){
        return student.removeIf(sv -> sv.getMaSV() == maSV);
    }

    public List<SinhVien> getAllSinhVien(){
        return new ArrayList<>(student);
    }
}