package com.phongth2004110017.tieuluancuoiky;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HangHoa{
    String loai;
    String mahang;
    String tenhanghoa;
    double gianhap;
    int soluongtonkho;
    String ngaynhap;
    Date ngay;
    HangHoa next;

    static Scanner sc = new Scanner(System.in);
    static Scanner ss = new Scanner(System.in);

    public HangHoa() {
    }

    public HangHoa(String l, String id, String name, double g, int s, String d) {
        loai = l;
        mahang = id;
        tenhanghoa = name;
        gianhap = g;
        soluongtonkho = s;
        ngaynhap = d;
    }

    public void HangHoa(String l, String id, String name, double g, int s, String d) {
        loai = l;
        mahang = id;
        tenhanghoa = name;
        gianhap = g;
        soluongtonkho = s;
        ngaynhap = d;
    }

    /** đổi chuỗi (theo chuẩn ngày Việt Nam) sang ngày java */
    public static Date chuyenChuoiSangNgay(String chuoiNgay) throws ParseException {
        // ngày việt nam
        Date date;
        /**
         * dd: ngày
         * mm: tháng
         * yyyy: năm
         */
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
        date = simpleDateFormat.parse(chuoiNgay);
        return date;
    }

    // Đổi ngày Java sang kiểu ngày việt dd/mm/yyy
    public static String chuyenNgaySangChuoi(Date date) {
        String chuoiNgayViet = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
        chuoiNgayViet = simpleDateFormat.format(date);
        return chuoiNgayViet;

    }

    void nhapthongtin() throws ParseException {
        System.out.println("nhập loại: ");
        loai = sc.nextLine();
        System.out.println("nhập mã hàng: ");
        mahang = sc.nextLine();
        System.out.println("nhập tên hàng hóa : ");
        tenhanghoa = ss.nextLine();
        System.out.println("nhập giá: ");
        gianhap = sc.nextDouble();
        sc.nextLine();
        System.out.println("nhập số lượng tồn kho: ");
        soluongtonkho = sc.nextInt();
        sc.nextLine();
        System.out.println("ngày nhập kho: ");
        ngaynhap = sc.nextLine();
        ngay = chuyenChuoiSangNgay(ngaynhap);
        ngaynhap = chuyenNgaySangChuoi(ngay);
    }

    void inThongTin() {
        System.out.print("|| loại hàng: " + loai);
        System.out.print("|| ID: " + mahang);
        System.out.print("|| tên hàng: " + tenhanghoa);
        System.out.print("|| giá: " + gianhap);
        System.out.print("|| số lượng tồn kho: " + soluongtonkho);
        System.out.println("|| ngày nhập kho: " + ngay + " " + ngaynhap);
    }
}
