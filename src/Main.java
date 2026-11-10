import java.util.ArrayList;
import java.util.Scanner;

/**
 * Tuan 6 - Mang va danh sach (List) trong Java.
 * Bai 1: Mang int[] soLuong cua 5 cuon sach.
 * Bai 2: ArrayList<String> luu ma sach (them, hien thi, tim, xoa).
 * Bai 3: ArrayList<String> danhSachSach (them, hien thi, tim, xoa, sua).
 * Bai 4: Menu hoan chinh 8 chuc nang.
 */
public class Main {
    static final int NAM_HIEN_TAI = 2026;
    static final String SEP = ";"; // ngan cach cac truong trong 1 chuoi sach
    static Scanner sc = new Scanner(System.in);

    // ---------- Ham nhap lieu co kiem tra hop le ----------
    static int nhapSoNguyen(String thongBao, int min, int max) {
        while (true) {
            System.out.print(thongBao);
            try {
                int giaTri = Integer.parseInt(sc.nextLine().trim());
                if (giaTri >= min && giaTri <= max) return giaTri;
            } catch (NumberFormatException e) {
                // nhap lai
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
                // nhap lai
            }
            System.out.println("  Don gia phai la so lon hon 0.");
        }
    }

    static String nhapChuoi(String thongBao) {
        String s;
        do {
            System.out.print(thongBao);
            s = sc.nextLine().trim().replace(SEP, ",");
            if (s.isEmpty()) System.out.println("  Khong duoc de trong.");
        } while (s.isEmpty());
        return s;
    }

    // =====================================================
    // Bai 1: Mang so luong cua 5 cuon sach
    // =====================================================
    static void bai1() {
        int[] soLuong = new int[5];
        for (int i = 0; i < soLuong.length; i++) {
            soLuong[i] = nhapSoNguyen("Nhap so luong cuon sach " + (i + 1) + ": ", 0, Integer.MAX_VALUE);
        }
        int tong = 0;
        int lonNhat = soLuong[0];
        System.out.print("Danh sach so luong: ");
        for (int sl : soLuong) {
            System.out.print(sl + " ");
            tong += sl;
            if (sl > lonNhat) lonNhat = sl;
        }
        System.out.println();
        System.out.println("Tong so luong     : " + tong);
        System.out.println("So luong lon nhat : " + lonNhat);
    }

    // =====================================================
    // Bai 2: ArrayList<String> luu ma sach
    // =====================================================
    static void bai2() {
        ArrayList<String> dsMa = new ArrayList<>();
        int chon;
        do {
            System.out.println("\n--- Quan ly ma sach ---");
            System.out.println("1. Them  2. Hien thi  3. Tim  4. Xoa  0. Quay lai");
            chon = nhapSoNguyen("Chon: ", 0, 4);
            switch (chon) {
                case 1: {
                    String ma = nhapChuoi("Nhap ma sach: ");
                    if (dsMa.contains(ma)) System.out.println("Ma sach da ton tai.");
                    else {
                        dsMa.add(ma);
                        System.out.println("Da them.");
                    }
                    break;
                }
                case 2:
                    if (dsMa.isEmpty()) System.out.println("Danh sach rong.");
                    for (int i = 0; i < dsMa.size(); i++) System.out.println((i + 1) + ". " + dsMa.get(i));
                    break;
                case 3: {
                    String ma = nhapChuoi("Nhap ma can tim: ");
                    int vt = dsMa.indexOf(ma);
                    System.out.println(vt >= 0 ? "Tim thay o vi tri " + (vt + 1) : "Khong tim thay.");
                    break;
                }
                case 4: {
                    String ma = nhapChuoi("Nhap ma can xoa: ");
                    System.out.println(dsMa.remove(ma) ? "Da xoa." : "Khong tim thay ma.");
                    break;
                }
            }
        } while (chon != 0);
    }

    // =====================================================
    // Bai 3 + 4: ArrayList<String> danhSachSach
    // Moi phan tu: ma;ten;tacGia;namXB;donGia;soLuong
    // =====================================================
    static ArrayList<String> danhSachSach = new ArrayList<>();

    static String[] tach(String s) {
        return s.split(SEP);
    }

    static String ghep(String ma, String ten, String tacGia, int nam, double gia, int sl) {
        return ma + SEP + ten + SEP + tacGia + SEP + nam + SEP + gia + SEP + sl;
    }

    static int timViTri(String ma) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            if (tach(danhSachSach.get(i))[0].equalsIgnoreCase(ma)) return i;
        }
        return -1;
    }

    static void inSach(int stt, String s) {
        String[] t = tach(s);
        double thanhTien = Double.parseDouble(t[4]) * Integer.parseInt(t[5]);
        System.out.printf("%-4d %-10s %-22s %-16s %-6s %-12.0f %-5s %-14.0f%n",
                stt, t[0], t[1], t[2], t[3], Double.parseDouble(t[4]), t[5], thanhTien);
    }

    static void inTieuDe() {
        System.out.printf("%-4s %-10s %-22s %-16s %-6s %-12s %-5s %-14s%n",
                "STT", "Ma", "Ten sach", "Tac gia", "Nam", "Don gia", "SL", "Thanh tien");
    }

    static void themSach() {
        String ma;
        while (true) {
            ma = nhapChuoi("Ma sach: ");
            if (timViTri(ma) == -1) break;
            System.out.println("  Ma sach da ton tai.");
        }
        String ten = nhapChuoi("Ten sach: ");
        String tacGia = nhapChuoi("Tac gia: ");
        int nam = nhapSoNguyen("Nam xuat ban: ", 1500, NAM_HIEN_TAI);
        double gia = nhapGia("Don gia: ");
        int sl = nhapSoNguyen("So luong: ", 0, Integer.MAX_VALUE);
        danhSachSach.add(ghep(ma, ten, tacGia, nam, gia, sl));
        System.out.println("Da them sach.");
    }

    static void hienThiSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach rong.");
            return;
        }
        inTieuDe();
        for (int i = 0; i < danhSachSach.size(); i++) inSach(i + 1, danhSachSach.get(i));
    }

    static void timSach() {
        String ma = nhapChuoi("Nhap ma sach can tim: ");
        int vt = timViTri(ma);
        if (vt == -1) {
            System.out.println("Khong tim thay sach co ma " + ma);
            return;
        }
        inTieuDe();
        inSach(vt + 1, danhSachSach.get(vt));
    }

    static void xoaSach() {
        String ma = nhapChuoi("Nhap ma sach can xoa: ");
        int vt = timViTri(ma);
        if (vt == -1) System.out.println("Khong tim thay sach co ma " + ma);
        else {
            danhSachSach.remove(vt);
            System.out.println("Da xoa sach.");
        }
    }

    static void suaSach() {
        String ma = nhapChuoi("Nhap ma sach can sua: ");
        int vt = timViTri(ma);
        if (vt == -1) {
            System.out.println("Khong tim thay sach co ma " + ma);
            return;
        }
        System.out.println("Nhap thong tin moi (ma sach giu nguyen):");
        String ten = nhapChuoi("Ten sach: ");
        String tacGia = nhapChuoi("Tac gia: ");
        int nam = nhapSoNguyen("Nam xuat ban: ", 1500, NAM_HIEN_TAI);
        double gia = nhapGia("Don gia: ");
        int sl = nhapSoNguyen("So luong: ", 0, Integer.MAX_VALUE);
        danhSachSach.set(vt, ghep(tach(danhSachSach.get(vt))[0], ten, tacGia, nam, gia, sl));
        System.out.println("Da cap nhat sach.");
    }

    static void tongSoLuong() {
        int tong = 0;
        for (String s : danhSachSach) tong += Integer.parseInt(tach(s)[5]);
        System.out.println("Tong so luong sach: " + tong);
    }

    static void tongGiaTri() {
        double tong = 0;
        for (String s : danhSachSach) {
            String[] t = tach(s);
            tong += Double.parseDouble(t[4]) * Integer.parseInt(t[5]);
        }
        System.out.printf("Tong gia tri sach: %.0f%n", tong);
    }

    static void menuQuanLySach() {
        int chon;
        do {
            System.out.println("\n===== QUAN LY SACH THU VIEN =====");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Tinh tong so luong");
            System.out.println("7. Tinh tong gia tri");
            System.out.println("8. Thoat");
            chon = nhapSoNguyen("Chon chuc nang: ", 1, 8);
            switch (chon) {
                case 1: themSach(); break;
                case 2: hienThiSach(); break;
                case 3: timSach(); break;
                case 4: xoaSach(); break;
                case 5: suaSach(); break;
                case 6: tongSoLuong(); break;
                case 7: tongGiaTri(); break;
                case 8: System.out.println("Quay lai menu chinh."); break;
            }
        } while (chon != 8);
    }

    // ---------- Menu chinh ----------
    public static void main(String[] args) {
        int chon;
        do {
            System.out.println("\n===== TUAN 6: MANG VA LIST =====");
            System.out.println("1. Bai 1 - Mang so luong 5 cuon sach");
            System.out.println("2. Bai 2 - ArrayList ma sach");
            System.out.println("3. Bai 3, 4 - Quan ly sach (menu hoan chinh)");
            System.out.println("0. Thoat");
            chon = nhapSoNguyen("Chon: ", 0, 3);
            switch (chon) {
                case 1: bai1(); break;
                case 2: bai2(); break;
                case 3: menuQuanLySach(); break;
                case 0: System.out.println("Tam biet!"); break;
            }
        } while (chon != 0);
    }
}
