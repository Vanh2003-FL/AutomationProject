package Day5_BTVN2;

import java.util.Scanner;

public class Apllication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Chon phong:");
        System.out.println("1 - Developer");
        System.out.println("2 - Tester");
        System.out.println("3 - BA");
        System.out.print("Hay Chon Phong : ");
        int chon = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhap so luong nhân vien: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();
        Employee[] danhSach = new Employee[soLuong];
        for (int i = 0; i < soLuong; i++) {
            System.out.println("\nNhan vien thu" + (i + 1) +"la:");
            switch (chon) {
                case 1:
                    danhSach[i] = new Employee.Developer();
                    break;
                case 2:
                    danhSach[i] = new Employee.Tester();
                    break;
                case 3:
                    danhSach[i] = new Employee.BA();
                    break;
                default:
                    System.out.println("Chon khong hop le");
                    return;
            }
            danhSach[i].nhapThongTin(scanner);
        }

        System.out.println("\nDanh Sach NV:");
        for (int i = 0; i < soLuong; i++) {
            danhSach[i].inThongTin();
        }
    }
}

