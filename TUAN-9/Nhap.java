import java.util.Scanner;

public class Nhap {
    private static final Scanner sc = new Scanner(System.in);

    public static String chuoi(String thongBao) {
        String s;
        do {
            System.out.print(thongBao);
            s = sc.nextLine().trim();
            if (s.isEmpty()) System.out.println("  Khong duoc de trong.");
        } while (s.isEmpty());
        return s;
    }

    public static int soNguyen(String thongBao, int min, int max) {
        while (true) {
            System.out.print(thongBao);
            try {
                int v = Integer.parseInt(sc.nextLine().trim());
                if (v >= min && v <= max) return v;
            } catch (NumberFormatException e) { }
            System.out.println("  Gia tri khong hop le (" + min + " - " + max + ").");
        }
    }

    public static double soThuc(String thongBao, double min) {
        while (true) {
            System.out.print(thongBao);
            try {
                double v = Double.parseDouble(sc.nextLine().trim());
                if (v >= min) return v;
            } catch (NumberFormatException e) { }
            System.out.println("  Gia tri khong hop le (>= " + min + ").");
        }
    }
}
