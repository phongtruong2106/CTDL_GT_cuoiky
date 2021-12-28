package com.phongth2004110017.tieuluancuoiky;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    static KhoLinkedList qlkho = new KhoLinkedList();
    static Scanner sc = new Scanner(System.in);
    static Scanner ss = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        addBait();
        int key;
        do {
            System.out.println("_________________MENU_______________");
            System.out.println("1> nhập thông tin");
            System.out.println("2> nhập thông tin (theo mã)");
            System.out.println("3> in thông tin");
            System.out.println("4> xóa hành hóa theo mã hàng");
            System.out.println("5> sửa thông tin hàng hóa theo mã hàng");
            System.out.println("6> tìm kiếm (ngày)");
            System.out.println("7> tìm kiếm (giá)");
            System.out.println("8> tìm kiếm (loại)");
            System.out.println("9> sắp xếp tăng dần (theo giá)");
            System.out.println("10> sắp xếp giảm dần (theo giá)");
            System.out.println("11> thống kê ");
            System.out.println("12> kết thúc(exit)");
            System.out.println(">>> nhập số để lựa chọn chức năng: ");

            System.out.print("Lựa chọn:");
            key = sc.nextInt();
            switch (key) {
                case 1:
                    qlkho.add();
                    break;
                case 2:
                    System.out.print("Nhập mã id  muốn thêm vào đằng trước: ");
                    String add = ss.nextLine();
                    qlkho.addProduct(add);
                    qlkho.print();
                    break;
                case 3:
                    qlkho.print();
                    break;
                case 4:
                    System.out.println("4> xóa hành hóa theo mã hàng");
                    System.out.println("nhập id muốn xóa: ");
                    String id = ss.nextLine();
                    sc.nextLine();
                    qlkho.xoaHangHoa(id);
                    break;
                case 5:
                    System.out.println("5> sửa thông tin hàng hóa theo mã hàng");
                    System.out.println("nhập id cần sữa: ");
                    String mahang = ss.nextLine();
                    qlkho.sua(mahang);
                    break;
                case 6:
                    System.out.println(">>6: Tìm kiếm ngày trong dách sách.");
                    System.out.println("nhập ngay muốn kiếm: ");
                    String ngay = ss.nextLine();
                    qlkho.checkTimTheongay(ngay);
                    break;
                case 7:
                    System.out.println(">>7: Tìm kiếm giá hàng trong dách sách.");
                    double gianhap = sc.nextDouble();
                    if (qlkho.timgia(gianhap) != null) {
                        System.out.println(" có trong danh sách");
                        qlkho.timgia(gianhap).data.inThongTin();
                    } else {
                        System.out.println("Không tìm thấy");
                    }
                    break;
                case 8:
                    System.out.println(">>8: Tìm kiếm loại hàng trong dách sách.");
                    System.out.println("nhập loại muốn tìm: ");
                    String loai = ss.nextLine();
                    sc.nextLine();
                    qlkho.checkTimTheoloai(loai);
                    break;
                case 9:
                    System.out.println("9> sắp xếp theo giá(td)");
                    sorttd();
                    break;
                case 10:
                    sortgd();
                    break;
                case 11:
                    System.out.println("10> thống kê  ");
                    qlkho.commoditysSatistics();
                    break;
                case 12:
                    System.exit(0);
            }
        } while (key != 14);

    }

    // hàm mồi
    static void addBait() {
        qlkho.Bait("thuc pham", "2000", "rau", 236654, 2, "21/2/2002");
        qlkho.Bait("thuc pham", "2001", "phô mai", 264548, 5, "21/1/2021");
        qlkho.Bait("thuc pham", "2005", "rau ngò", 2482, 6, "22/7/2021");
        qlkho.Bait("thuc pham", "2006", "bí đỏ", 1520, 6, "20/3/2021");
        qlkho.Bait("thuc pham", "2002", "nước mắm", 26482, 6, "21/3/2021");
        qlkho.Bait("thuc pham", "2003", "sốt madone", 22665, 6, "5/2/2021");
        qlkho.Bait("thuc pham", "2004", "cà rốt", 26545, 6, "1/1/2021");
        qlkho.Bait("dien may", "1001", "quạt máy", 266546, 2, "3/5/2021");
        qlkho.Bait("dien may", "1002", "máy hút bụi", 265546, 8, "1/7/2021");
        qlkho.Bait("dien may", "1003", "đèn", 215546, 7, "9/2/2021");
        qlkho.Bait("dien may", "1006", "máy lạnh", 1563212, 8, "1/8/2021");
        qlkho.Bait("dien may", "1004", "tủ lạnh", 2661546, 2, "4/5/2021");
        qlkho.Bait("dien may", "1007", "bếp từ", 1255488, 7, "1/7/2021");
        qlkho.Bait("dien may", "1005", "máy giặt", 966546, 7, "1/5/2021");
        qlkho.Bait("sanh su", "4001", "bình hoa", 12515, 6, "1/9/2021");
        qlkho.Bait("sanh su", "4002", "đồ gốm", 165544, 2, "1/8/2021");
        qlkho.Bait("sanh su", "4003", "chén", 12715, 18, "1/9/2021");
        qlkho.Bait("sanh su", "4004", "đĩa", 11565, 7, "10/10/2021");
        qlkho.Bait("sanh su", "4005", "ấm sứ", 125515, 10, "7/12/2021");
        qlkho.print();
    }

    static void sorttd() {
        System.out.println("list sao khi sắp xếp: ");
        qlkho.tangDanSelection();
        qlkho.print();
    }

    static void sortgd() {
        System.out.println("list sao khi sắp xếp: ");
        qlkho.giamDanSelection();
        qlkho.print();
    }

}
