package com.phongth2004110017.tieuluancuoiky;

import java.text.ParseException;
import java.util.Scanner;

public class KhoLinkedList {
    Node head = null;
    Node tail = null;
    Node previous = null;
    Node current = null;
    Node check;
    Node temp;
    Node save;
    static Scanner sc = new Scanner(System.in);

    public KhoLinkedList() {
    }

    void addTail(HangHoa hangHoa) {
        Node newNode = new Node(hangHoa);

        if (head == null) {// thêm 1 nút vào ds rỗng
            head = newNode;
            tail = newNode;
        } else {// ds không rỗng// thêm vào đuổi danh sách
            tail.next = newNode;
            tail = newNode;
        }

    }
    //hàm nhập
    public void add() throws ParseException {
        HangHoa hangHoa = new HangHoa();
        Node newHangHoa = new Node(hangHoa);
        newHangHoa.data.nhapthongtin();
        if (head == null) {
            head = newHangHoa;
            tail = newHangHoa;
        } else {
            newHangHoa.next = head;
            head = newHangHoa;
        }
    }

    // hàm mồi
    public void Bait(String l, String id, String name, double g, int s, String d) {
        HangHoa hangHoa = new HangHoa();
        Node newHangHoa = new Node(hangHoa);
        newHangHoa.data.HangHoa(l, id, name, g, s, d);
        if (head == null) {
            head = newHangHoa;
            tail = newHangHoa;
        } else {
            newHangHoa.next = head;
            head = newHangHoa;
        }
    }

    boolean isEmpty() {

        boolean emtpy = true;

        if (head == null) {
            emtpy = true;
        } else {
            emtpy = false;
        }
        return emtpy;
    }

    public void print() {
        Node current = head;
        if (head == null) {
            System.out.println("EMPTY LIST !!!");
            return;
        } else {
            while (current != null) {
                current.data.inThongTin();
                current = current.next;
            }
        }
    }

    // thêm trước mã hàng
    public void addProduct(String viTri) {
        System.out.println("nhập loại: ");
        String loai = sc.nextLine();
        System.out.println("nhập mã hàng: ");
        String id = sc.nextLine();
        System.out.print("nhập tên sản phẩm: ");
        String name = sc.nextLine();
        System.out.println("nhập giá: ");
        Double gia = sc.nextDouble();
        sc.nextLine();
        System.out.println("nhập số lượng: ");
        int s = sc.nextInt();
        sc.nextLine();
        System.out.println("ngày nhập kho: ");
        String ngaynhapkho = sc.nextLine();
        addTail(new HangHoa(loai, id, name, gia, s, ngaynhapkho));
        Node newNode = new Node(new HangHoa(loai, id, name, gia, s, ngaynhapkho));

        Node before = head;

        Node current = before.next;

        while (current != null) {
            if (current.data.mahang == viTri) {
                before.next = newNode;
                newNode.next = current;
                return;

            }
            before = before.next;
            current = before.next;

        }
    }

    // hàm tìm loại
    boolean timTheoloai(String key) {
        Node current = head;
        boolean result = false;
        while (current != null) {
            if (current.data.loai.equals(key)) {
                current.data.inThongTin();
                result = true;
            }
            current = current.next;
        }
        return result;
    }

    void checkTimTheoloai(String key) {
        if (false == timTheoloai(key)) {
            System.out.println("Không tìm thấy");
        }
    }

    // tim ngày
    boolean timTheongay(String key) {
        Node current = head;
        boolean result = false;
        while (current != null) {
            if (current.data.ngaynhap.equals(key)) {
                current.data.inThongTin();
                result = true;
            }
            current = current.next;
        }
        return result;
    }

    void checkTimTheongay(String key) {
        if (false == timTheongay(key)) {
            System.out.println("Không tìm thấy");
        }
    }

    // tìm giá
    Node timgia(double key) {
        Node current = head;
        if (head.data.gianhap == key) {
            return head;
        }
        while (current != null) {
            if (key == current.data.gianhap)
                return current;
            current = current.next;
        }
        return null;
    }

    // hàm xóa
    boolean find(String mahang) {
        current = head;
        boolean result = false;
        while (current != null) {
            if (current.data.mahang.equals(mahang)) {
                result = true;
                return result;
            }
            current = current.next;
        }
        return result;
    }

    void xoaHangHoa(String mahang) {

        if (true == find(mahang)) {
            if (current == head) {
                xoaHead();
            } else if (current == tail) {
                xoaTail();
            } else {
                xoaGiua();
            }
        } else {
            System.out.println("Không tìm thấy");
        }
    }

    void xoaHead() {
        head = head.next;
    }

    void xoaTail() {
        current = head;
        while (current != null) {
            if (current.next == tail) {
                tail = current;
                tail.next = null;
                return;
            }
            current = current.next;
        }
    }

    void xoaGiua() {
        timDangTruoc();
        current = current.next;
        previous.next = current;
    }

    void timDangTruoc() {
        previous = head;
        while (previous != null) {
            if (previous.next == current) {
                return;
            }
            previous = previous.next;
        }
    }

    // hàm sửa
    public void sua(String key) throws ParseException {
        if (true == find(key)) {
            HangHoa hanghoa = new HangHoa();
            Node newhanghoa = new Node(hanghoa);
            newhanghoa.data.nhapthongtin();
            current.data.loai = hanghoa.loai;
            current.data.mahang = hanghoa.mahang;
            current.data.tenhanghoa = hanghoa.tenhanghoa;
            current.data.gianhap = hanghoa.gianhap;
            current.data.soluongtonkho = hanghoa.soluongtonkho;
            current.data.ngaynhap = hanghoa.ngaynhap;
        } else {
            System.out.println("Không tìm thấy");
        }
    }

    // sắp xếp
    public void sortList() {
        // Node current will point to head
        Node current = head, index = null;

        double temp;

        if (head == null) {
            return;
        } else {
            while (current != null) {
                // Node index will point to node next to
                // current
                index = current.next;

                while (index != null) {
                    // If current node's data is greater
                    // than index's node data, swap the data
                    // between them
                    if (current.data.gianhap > index.data.gianhap) {
                        temp = current.data.gianhap;
                        current.data = index.data;
                        index.data.gianhap = temp;
                    }

                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    void tangDanSelection() {
        current = head;
        while (current != null) {
            check = current;
            save = current;
            while (check != null) {
                if (check.data.gianhap > save.data.gianhap) {
                    save = check;
                }
                check = check.next;
            }
            swapInfo();
            current = current.next;
        }
    }

    void giamDanSelection() {
        current = head;
        while (current != null) {
            check = current;
            save = current;
            while (check != null) {
                if (check.data.gianhap < save.data.gianhap) {
                    save = check;
                }
                check = check.next;
            }
            swapInfo();
            current = current.next;
        }
    }

    void swapInfo() {
        HangHoa hangHoa = new HangHoa();
        temp = new Node(hangHoa);
        temp.data.loai = save.data.loai;
        temp.data.mahang = save.data.mahang;
        temp.data.tenhanghoa = save.data.tenhanghoa;
        temp.data.gianhap = save.data.gianhap;
        temp.data.soluongtonkho = save.data.soluongtonkho;
        temp.data.ngaynhap = save.data.ngaynhap;
        save.data.loai = current.data.loai;
        save.data.mahang = current.data.mahang;
        save.data.tenhanghoa = current.data.mahang;
        save.data.gianhap = current.data.gianhap;
        save.data.soluongtonkho = current.data.soluongtonkho;
        save.data.ngaynhap = current.data.ngaynhap;
        current.data.loai = temp.data.loai;
        current.data.mahang = temp.data.mahang;
        current.data.tenhanghoa = temp.data.tenhanghoa;
        current.data.gianhap = temp.data.gianhap;
        current.data.soluongtonkho = temp.data.soluongtonkho;
        current.data.ngaynhap = temp.data.ngaynhap;
    }

    public void commoditysSatistics() {
        Node current = head;
        int sumHangHoa = 0;
        double sumGia = 0;
        int sumThucPham = 0;
        int sumSanhSu = 0;
        int sumDienMay = 0;
        if (head == null) {

        } else {
            while (current != null) {
                sumHangHoa++;
                sumGia = sumGia + (current.data.gianhap * current.data.soluongtonkho);
                if (current.data.loai.equals("thuc pham")) {
                    sumThucPham++;
                }
                if (current.data.loai.equals("sanh su")) {
                    sumSanhSu++;
                }
                if (current.data.loai.equals("dien may")) {
                    sumDienMay++;
                }
                current = current.next;
            }
        }
        System.out.println("Tổng số lượng hàng hoá: " + sumHangHoa);
        System.out.println("Tổng giá trị nhập kho: " + sumGia);
        System.out.println("Số lượng hàng Thực Phẩm: " + sumThucPham);
        System.out.println("Số lượng hàng Sành Sứ: " + sumSanhSu);
        System.out.println("Số lượng hàng Điện Máy: " + sumDienMay);

    }

}
