import java.util.Scanner;

/**
 * Tuan 5 - Cau lenh lap trong Java.
 * Bai 1: Nhap n sach bang vong lap.
 * Bai 2: Tinh tong so luong va tong gia tri sach.
 * Bai 3: Menu lap den khi chon Thoat.
 * Bai 4: Tim sach theo ma.
 */
public class Main {
    static final int NAM_HIEN_TAI = 2026;
    static Scanner sc = new Scanner(System.in);

    // Du lieu sach (luu bang cac mang song song, kich thuoc toi da 100)
    static final int MAX = 100;
    static String[] maSach = new String[MAX];
    static String[] tenSach = new String[MAX];
    static String[] tacGia = new String[MAX];
    static int[] namXuatBan = new int[MAX];
    static double[] donGia = new double[MAX];
    static int[] soLuong = new int[MAX];
    static int soSach = 0;

    // ---------- Ham nhap lieu co kiem tra hop le (tuan 4) ----------
    static int nhapSoNguyen(String thongBao, int min, int max) {
        int giaTri;
        while (true) {
            System.out.print(thongBao);
            try {
                giaTri = Integer.parseInt(sc.nextLine().trim());
                if (giaTri >= min && giaTri <= max) return giaTri;
            } catch (NumberFormatException e) {
                // bo qua, nhap lai
            }
            System.out.println("  Gia tri khong hop le, vui long nhap lai (" + min + " - " + max + ").");
        }
    }

    static double nhapGia(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                double gia = Double.parseDouble(sc.nextLine().trim());
                if (gia > 0) return gia;
            } catch (NumberFormatException e) {
                // bo qua, nhap lai
            }
            System.out.println("  Don gia phai la so lon hon 0.");
        }
    }

    // ---------- Bai 1: Nhap n sach bang vong lap ----------
    static void nhapNSach() {
        int n = nhapSoNguyen("Nhap so sach can nhap (1 - " + (MAX - soSach) + "): ", 1, MAX - soSach);
        for (int i = 1; i <= n; i++) {
            System.out.println("--- Nhap sach thu " + i + "/" + n + " ---");
            String ma;
            do {
                System.out.print("Ma sach: ");
                ma = sc.nextLine().trim();
                if (ma.isEmpty()) System.out.println("  Ma sach khong duoc de trong.");
                else if (timViTri(ma) != -1) {
                    System.out.println("  Ma sach da ton tai.");
                    ma = "";
                }
            } while (ma.isEmpty());

            maSach[soSach] = ma;
            System.out.print("Ten sach: ");
            tenSach[soSach] = sc.nextLine().trim();
            System.out.print("Tac gia: ");
            tacGia[soSach] = sc.nextLine().trim();
            namXuatBan[soSach] = nhapSoNguyen("Nam xuat ban: ", 1500, NAM_HIEN_TAI);
            donGia[soSach] = nhapGia("Don gia: ");
            soLuong[soSach] = nhapSoNguyen("So luong: ", 0, Integer.MAX_VALUE);
            soSach++;
        }
        System.out.println("Da nhap them " + n + " sach.");
    }

    static void hienThiDanhSach() {
        if (soSach == 0) {
            System.out.println("Danh sach rong.");
            return;
        }
        System.out.printf("%-4s %-10s %-22s %-16s %-6s %-12s %-5s %-14s%n",
                "STT", "Ma", "Ten sach", "Tac gia", "Nam", "Don gia", "SL", "Thanh tien");
        for (int i = 0; i < soSach; i++) {
            System.out.printf("%-4d %-10s %-22s %-16s %-6d %-12.0f %-5d %-14.0f%n",
                    i + 1, maSach[i], tenSach[i], tacGia[i], namXuatBan[i],
                    donGia[i], soLuong[i], donGia[i] * soLuong[i]);
        }
    }

    // ---------- Bai 2: Tong so luong va tong gia tri ----------
    static void thongKe() {
        int tongSoLuong = 0;
        double tongGiaTri = 0;
        for (int i = 0; i < soSach; i++) {
            tongSoLuong += soLuong[i];
            tongGiaTri += donGia[i] * soLuong[i];
        }
        System.out.println("Tong so luong sach: " + tongSoLuong);
        System.out.printf("Tong gia tri sach : %.0f%n", tongGiaTri);
    }

    // ---------- Bai 4: Tim sach theo ma ----------
    static int timViTri(String ma) {
        for (int i = 0; i < soSach; i++) {
            if (maSach[i].equalsIgnoreCase(ma)) return i;
        }
        return -1;
    }

    static void timSachTheoMa() {
        System.out.print("Nhap ma sach can tim: ");
        String ma = sc.nextLine().trim();
        int vt = timViTri(ma);
        if (vt == -1) {
            System.out.println("Khong tim thay sach co ma " + ma);
            return;
        }
        System.out.println("Tim thay sach:");
        System.out.println("  Ma sach  : " + maSach[vt]);
        System.out.println("  Ten sach : " + tenSach[vt]);
        System.out.println("  Tac gia  : " + tacGia[vt]);
        System.out.println("  Nam XB   : " + namXuatBan[vt]);
        System.out.printf("  Don gia  : %.0f%n", donGia[vt]);
        System.out.println("  So luong : " + soLuong[vt]);
        System.out.printf("  Thanh tien: %.0f%n", donGia[vt] * soLuong[vt]);
    }

    // ---------- Bai 3: Menu lap den khi chon Thoat ----------
    public static void main(String[] args) {
        int chon;
        do {
            System.out.println("\n===== QUAN LY SACH THU VIEN =====");
            System.out.println("1. Nhap n sach");
            System.out.println("2. Hien thi danh sach sach");
            System.out.println("3. Tong so luong va tong gia tri");
            System.out.println("4. Tim sach theo ma");
            System.out.println("0. Thoat");
            chon = nhapSoNguyen("Chon chuc nang: ", 0, 4);
            switch (chon) {
                case 1: nhapNSach(); break;
                case 2: hienThiDanhSach(); break;
                case 3: thongKe(); break;
                case 4: timSachTheoMa(); break;
                case 0: System.out.println("Tam biet!"); break;
            }
        } while (chon != 0);
    }
}
