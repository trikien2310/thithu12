package org.example.entity;

public class SinhVien {
    private String maSV;
    private String ten;
    private int tuoi;
    private float diemTB;

    private int kyHoc;

    private String chuyenNganh;

    public SinhVien(String maSV, String ten, int tuoi, float diemTB, int kyHoc, String chuyenNganh) {
       setMaSV(maSV);
       setTen(ten);
       setTuoi(tuoi);
       setDiemTB(diemTB);
       setKyHoc(kyHoc);
       setChuyenNganh(chuyenNganh);
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        if(maSV == null || maSV.isEmpty()){
            throw new IllegalArgumentException("Mã sinh viên k được trống");
        }
        this.maSV = maSV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        if(ten == null || ten.isEmpty()){
            throw new IllegalArgumentException("Tên sinh viên k được trống");
        }
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        if(tuoi < 18){
            throw new IllegalArgumentException("Tuổi sinh viên k được hơn 18");
        }
        this.tuoi = tuoi;
    }

    public float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(float diemTB) {
        if(diemTB < 0 || diemTB > 10){
            throw new IllegalArgumentException("Điểm trung bình k hợp lệ");
        }
        this.diemTB = diemTB;
    }

    public int getKyHoc() {
        return kyHoc;
    }

    public void setKyHoc(int kyHoc) {
        if(kyHoc < 0){
            throw new IllegalArgumentException("Kỳ học lớn hơn 0");
        }
        this.kyHoc = kyHoc;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        if(chuyenNganh == null ||chuyenNganh.isEmpty()){
            throw new IllegalArgumentException("Chuyên ngành k được trống");
        }
        this.chuyenNganh = chuyenNganh;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "maSV='" + maSV + '\'' +
                ", ten='" + ten + '\'' +
                ", tuoi=" + tuoi +
                ", diemTB=" + diemTB +
                ", kyHoc=" + kyHoc +
                ", chuyenNganh='" + chuyenNganh + '\'' +
                '}';
    }
}
