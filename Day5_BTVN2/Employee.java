package Day5_BTVN2;
public class  Employee {
    private String hoTen;
    private String maNV;
    private int SDT;

    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }
    public void nhapThongTin(java.util.Scanner scanner) {
        System.out.print("Ho Ten: ");
        setHoTen(scanner.nextLine());
        System.out.print("Ma Nhan Vien: ");
        setMaNV(scanner.nextLine());
        System.out.print("So DT: ");
        setSDT(scanner.nextInt());
    }

    public void inThongTin(){
        System.out.println("Ho Ten: "+hoTen+", Ma NV: "+maNV+", SDT: "+SDT);
    }

    public static class Developer extends Employee {
    }

    public static class Tester extends Employee {
    }

    public static class BA extends Employee {
    }
}
