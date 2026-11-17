public class SachGiaoKhoa extends Sach {
    private boolean moi;

    public SachGiaoKhoa() { }

    public SachGiaoKhoa(String maSach, NgayNhap ngayNhap, double donGia, int soLuong,
                        String nhaXuatBan, boolean moi) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.moi = moi;
    }

    public boolean isMoi() { return moi; }
    public void setMoi(boolean moi) { this.moi = moi; }

    @Override
    public void nhap() {
        super.nhap();
        int chon = Nhap.soNguyen("  Tinh trang (1. Moi, 2. Cu): ", 1, 2);
        moi = (chon == 1);
    }

    @Override
    public double thanhTien() {
        return moi ? super.thanhTien() : super.thanhTien() * 0.5;
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf(" | Tinh trang: %s | Thanh tien: %,.0f%n", moi ? "Moi" : "Cu", thanhTien());
    }
}
