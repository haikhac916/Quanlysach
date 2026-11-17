import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

class Sach {
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    public Sach() { }

    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        setNamXuatBan(namXuatBan);
        setSoLuong(soLuong);
    }

    public String getMaSach() { return maSach; }
    public void setMaSach(String maSach) { this.maSach = maSach; }

    public String getTieuDe() { return tieuDe; }
    public void setTieuDe(String tieuDe) { this.tieuDe = tieuDe; }

    public String getTacGia() { return tacGia; }
    public void setTacGia(String tacGia) { this.tacGia = tacGia; }

    public int getNamXuatBan() { return namXuatBan; }
    public void setNamXuatBan(int namXuatBan) {
        int currentYear = Year.now().getValue();
        if (namXuatBan > 0 && namXuatBan <= currentYear) {
            this.namXuatBan = namXuatBan;
        } else {
            System.out.println("  Nam xuat ban khong hop le (1 - " + currentYear + ").");
        }
    }

    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) {
            this.soLuong = soLuong;
        } else {
            System.out.println("  So luong khong duoc am.");
        }
    }

    public void hienThiThongTin() {
        System.out.printf("Ma: %-8s | Tieu de: %-22s | Tac gia: %-16s | Nam XB: %-5d | SL: %d%n",
                maSach, tieuDe, tacGia, namXuatBan, soLuong);
    }
}

public class Test {
    static final Scanner sc = new Scanner(System.in);
    static final ArrayList<Sach> ds = new ArrayList<>();

    static String nhapChuoi(String thongBao) {
        String s;
        do {
            System.out.print(thongBao);
            s = sc.nextLine().trim();
            if (s.isEmpty()) System.out.println("  Khong duoc de trong.");
        } while (s.isEmpty());
        return s;
    }

    static int nhapSo(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  Vui long nhap so nguyen.");
            }
        }
    }

    static int timViTri(String ma) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getMaSach().equalsIgnoreCase(ma)) return i;
        }
        return -1;
    }

    static void nhapNamXuatBan(Sach s) {
        int nam;
        do {
            nam = nhapSo("Nam xuat ban: ");
            s.setNamXuatBan(nam);
        } while (s.getNamXuatBan() != nam);
    }

    static void nhapSoLuong(Sach s) {
        int sl;
        do {
            sl = nhapSo("So luong: ");
            s.setSoLuong(sl);
        } while (s.getSoLuong() != sl);
    }

    static void themSach() {
        Sach s = new Sach();
        String ma;
        while (true) {
            ma = nhapChuoi("Ma sach: ");
            if (timViTri(ma) == -1) break;
            System.out.println("  Ma sach da ton tai.");
        }
        s.setMaSach(ma);
        s.setTieuDe(nhapChuoi("Tieu de: "));
        s.setTacGia(nhapChuoi("Tac gia: "));
        nhapNamXuatBan(s);
        nhapSoLuong(s);
        ds.add(s);
        System.out.println("Da them sach.");
    }

    static void hienThiDanhSach() {
        if (ds.isEmpty()) {
            System.out.println("Danh sach rong.");
            return;
        }
        for (Sach s : ds) s.hienThiThongTin();
    }

    static void timSach() {
        int vt = timViTri(nhapChuoi("Nhap ma sach can tim: "));
        if (vt == -1) System.out.println("Khong tim thay sach.");
        else ds.get(vt).hienThiThongTin();
    }

    static void xoaSach() {
        int vt = timViTri(nhapChuoi("Nhap ma sach can xoa: "));
        if (vt == -1) System.out.println("Khong tim thay sach.");
        else {
            ds.remove(vt);
            System.out.println("Da xoa sach.");
        }
    }

    static void suaSach() {
        int vt = timViTri(nhapChuoi("Nhap ma sach can sua: "));
        if (vt == -1) {
            System.out.println("Khong tim thay sach.");
            return;
        }
        Sach s = ds.get(vt);
        s.setTieuDe(nhapChuoi("Tieu de moi: "));
        s.setTacGia(nhapChuoi("Tac gia moi: "));
        nhapNamXuatBan(s);
        nhapSoLuong(s);
        System.out.println("Da cap nhat sach.");
    }

    public static void main(String[] args) {
        ds.add(new Sach("S01", "Lap trinh Java", "Nguyen Van A", 2020, 10));
        ds.add(new Sach("S02", "Cau truc du lieu", "Tran Van B", 2018, 5));

        int chon;
        do {
            System.out.println("\n===== QUAN LY SACH THU VIEN (TUAN 7 + 8) =====");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Tim sach theo ma");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua thong tin sach");
            System.out.println("0. Thoat");
            chon = nhapSo("Chon chuc nang: ");
            switch (chon) {
                case 1: themSach(); break;
                case 2: hienThiDanhSach(); break;
                case 3: timSach(); break;
                case 4: xoaSach(); break;
                case 5: suaSach(); break;
                case 0: System.out.println("Tam biet!"); break;
                default: System.out.println("Chuc nang khong hop le.");
            }
        } while (chon != 0);
    }
}
