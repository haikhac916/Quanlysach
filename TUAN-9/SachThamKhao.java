public class SachThamKhao extends Sach {
    private double thue;

    public SachThamKhao() { }

    public SachThamKhao(String maSach, NgayNhap ngayNhap, double donGia, int soLuong,
                        String nhaXuatBan, double thue) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        setThue(thue);
    }

    public double getThue() { return thue; }
    public void setThue(double thue) { if (thue >= 0) this.thue = thue; }

    @Override
    public void nhap() {
        super.nhap();
        setThue(Nhap.soThuc("  Thue: ", 0));
    }

    @Override
    public double thanhTien() {
        return super.thanhTien() + thue;
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf(" | Thue: %,.0f | Thanh tien: %,.0f%n", thue, thanhTien());
    }
}
