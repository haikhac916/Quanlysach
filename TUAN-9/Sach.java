public class Sach {
    private String maSach;
    private NgayNhap ngayNhap;
    private double donGia;
    private int soLuong;
    private String nhaXuatBan;

    public Sach() { }

    public Sach(String maSach, NgayNhap ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
        this.maSach = maSach;
        this.ngayNhap = ngayNhap;
        setDonGia(donGia);
        setSoLuong(soLuong);
        this.nhaXuatBan = nhaXuatBan;
    }

    public String getMaSach() { return maSach; }
    public void setMaSach(String maSach) { this.maSach = maSach; }
    public NgayNhap getNgayNhap() { return ngayNhap; }
    public void setNgayNhap(NgayNhap ngayNhap) { this.ngayNhap = ngayNhap; }
    public double getDonGia() { return donGia; }
    public void setDonGia(double donGia) { if (donGia >= 0) this.donGia = donGia; }
    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { if (soLuong >= 0) this.soLuong = soLuong; }
    public String getNhaXuatBan() { return nhaXuatBan; }
    public void setNhaXuatBan(String nhaXuatBan) { this.nhaXuatBan = nhaXuatBan; }

    public void nhap() {
        maSach = Nhap.chuoi("  Ma sach: ");
        System.out.println("  Ngay nhap:");
        ngayNhap = NgayNhap.nhap();
        setDonGia(Nhap.soThuc("  Don gia: ", 0));
        setSoLuong(Nhap.soNguyen("  So luong: ", 0, Integer.MAX_VALUE));
        nhaXuatBan = Nhap.chuoi("  Nha xuat ban: ");
    }

    public double thanhTien() {
        return soLuong * donGia;
    }

    public void xuat() {
        System.out.printf("Ma: %-8s | Ngay nhap: %s | Don gia: %,.0f | SL: %d | NXB: %s",
                maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
    }
}
