import java.time.LocalDate;
import java.time.YearMonth;

public class NgayNhap {
    private int ngay, thang, nam;

    public NgayNhap(int ngay, int thang, int nam) {
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }

    public int getNgay() { return ngay; }
    public int getThang() { return thang; }
    public int getNam() { return nam; }

    public static NgayNhap nhap() {
        int nam = Nhap.soNguyen("  Nam nhap: ", 1900, LocalDate.now().getYear());
        int thang = Nhap.soNguyen("  Thang nhap: ", 1, 12);
        int soNgayToiDa = YearMonth.of(nam, thang).lengthOfMonth();
        int ngay = Nhap.soNguyen("  Ngay nhap (1-" + soNgayToiDa + "): ", 1, soNgayToiDa);
        return new NgayNhap(ngay, thang, nam);
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", ngay, thang, nam);
    }
}
