package Automation.Testsuite;

import java.util.Scanner;

public class NhanVien {
    private String ten;

    public NhanVien(String ten) {
        this.ten = ten;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        System.out.print("Nhap so luong nhan vien: ");
        int n = sn.nextInt();
        sn.nextLine();
        NhanVien[] danhsach = new NhanVien[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap ten nhan vien thu " + (i + 1) + ": ");
            String ten = sn.nextLine();
            danhsach[i] = new NhanVien(ten);
        }

        System.out.println("\nDanh sách nhân viên:");
        for (NhanVien nv : danhsach) {
            System.out.println(" " + nv.getTen());
        }
    }
}
