import java.util.ArrayList;

public class Test {
    static ArrayList<Sach> ds = new ArrayList<>();

    static void nhapDanhSach() {
        int n = Nhap.soNguyen("Nhap so luong sach can them: ", 1, 1000);
        for (int i = 1; i <= n; i++) {
            System.out.println("--- Sach thu " + i + "/" + n + " ---");
            int loai = Nhap.soNguyen("Loai sach (1. Giao khoa, 2. Tham khao): ", 1, 2);
            Sach s = (loai == 1) ? new SachGiaoKhoa() : new SachThamKhao();
            s.nhap();
            ds.add(s);
        }
    }

    static void xuatDanhSach() {
        if (ds.isEmpty()) {
            System.out.println("Danh sach rong.");
            return;
        }
        System.out.println("=== SACH GIAO KHOA ===");
        for (Sach s : ds) if (s instanceof SachGiaoKhoa) s.xuat();
        System.out.println("=== SACH THAM KHAO ===");
        for (Sach s : ds) if (s instanceof SachThamKhao) s.xuat();
    }

    static void tongThanhTien() {
        double tongGK = 0, tongTK = 0;
        for (Sach s : ds) {
            if (s instanceof SachGiaoKhoa) tongGK += s.thanhTien();
            else if (s instanceof SachThamKhao) tongTK += s.thanhTien();
        }
        System.out.printf("Tong thanh tien sach giao khoa: %,.0f%n", tongGK);
        System.out.printf("Tong thanh tien sach tham khao: %,.0f%n", tongTK);
    }

    static void trungBinhDonGiaThamKhao() {
        double tong = 0;
        int dem = 0;
        for (Sach s : ds) {
            if (s instanceof SachThamKhao) {
                tong += s.getDonGia();
                dem++;
            }
        }
        if (dem == 0) System.out.println("Chua co sach tham khao.");
        else System.out.printf("Trung binh cong don gia sach tham khao: %,.2f%n", tong / dem);
    }

    static void xuatGiaoKhoaTheoNXB() {
        String nxb = Nhap.chuoi("Nhap nha xuat ban X: ");
        boolean coKetQua = false;
        for (Sach s : ds) {
            if (s instanceof SachGiaoKhoa && s.getNhaXuatBan().equalsIgnoreCase(nxb)) {
                s.xuat();
                coKetQua = true;
            }
        }
        if (!coKetQua) System.out.println("Khong co sach giao khoa cua nha xuat ban " + nxb);
    }

    public static void main(String[] args) {
        int chon;
        do {
            System.out.println("\n===== QUAN LY SACH THU VIEN (TUAN 9) =====");
            System.out.println("1. Nhap danh sach sach");
            System.out.println("2. Xuat danh sach sach");
            System.out.println("3. Tong thanh tien tung loai");
            System.out.println("4. Trung binh cong don gia sach tham khao");
            System.out.println("5. Xuat sach giao khoa cua nha xuat ban X");
            System.out.println("0. Thoat");
            chon = Nhap.soNguyen("Chon chuc nang: ", 0, 5);
            switch (chon) {
                case 1: nhapDanhSach(); break;
                case 2: xuatDanhSach(); break;
                case 3: tongThanhTien(); break;
                case 4: trungBinhDonGiaThamKhao(); break;
                case 5: xuatGiaoKhoaTheoNXB(); break;
                case 0: System.out.println("Tam biet!"); break;
            }
        } while (chon != 0);
    }
}
