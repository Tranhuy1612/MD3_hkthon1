package ra.run;

import ra.bussiness.Book;

import java.util.Arrays;
import java.util.Scanner;

public class BookManagement {
    static Scanner scanner = new Scanner(System.in);
    static Book[] arrBook = new Book[100];
    static int bookCount = 0;

    public static void main(String[] args) {
        while (true) {
            System.out.println("***********************MENU**************************");
            System.out.println("1 .Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách");
            System.out.println("2. Hiển thị thông tin tất cả sách trong thư viện");
            System.out.println("3. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả");
            System.out.println("6. Thay đổi thông tin sách theo mã sách");
            System.out.println("7. Thoát");
            System.out.print("Chọn một chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputData();
                    break;
                case 2:
                    displayData();
                    break;
                case 3:
                    sort();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    thayDoiThongTinTheoMaSach();
                    break;
                case 7:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }
    }

    public static void inputData() {
        System.out.print("Nhập số lượng sản phẩm: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            arrBook[bookCount] = new Book();
            arrBook[bookCount].inputData(scanner, arrBook);
            bookCount++;
        }
    }

    public static void displayData() {
        for (int i = 0; i < bookCount; i++) {
            arrBook[i].displayData();
            System.out.println();
        }
    }

    public static void search() {
        System.out.println("nhập tên sách cần tìm :");
        String searchName = scanner.nextLine();
        if (searchName.isEmpty()) {
            System.err.println("không tìm thấy sách");
        } else {
            for (int i = 0; i < bookCount; i++) {
                if (arrBook[i].getBookName().equalsIgnoreCase(searchName)) {
                    arrBook[i].displayData();
                    System.out.println();
                }
            }
        }
    }

    public static void deleteBook() {
        System.out.print("Nhập mã sách cần xóa: ");
        int bookIdToDelete = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < bookCount; i++) {
            if (arrBook[i].getBookId() == bookIdToDelete) {
                for (int j = i; j < bookCount - 1; j++) {
                    arrBook[j] = arrBook[j + 1];
                }
                bookCount--;
                System.out.println("Sách có mã " + bookIdToDelete + " đã bị xóa.");
                return;
            }
        }
        System.err.println("Không tìm thấy sách có mã " + bookIdToDelete);
    }

    public static void thayDoiThongTinTheoMaSach() {
        System.out.print("Nhập mã sách cần chỉnh sửa thông tin: ");
        int bookIdToModify = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < bookCount; i++) {
            if (arrBook[i].getBookId() == bookIdToModify) {
                arrBook[i].inputData(scanner, arrBook);
                return;
            }
        }
        System.err.println("Không tìm thấy sách có mã " + bookIdToModify);
    }

    public static void sort() {
        for (int i = 0; i < bookCount - 1; i++) {
            for (int j = 0; j < bookCount - i - 1; j++) {
                if (arrBook[j].getInterest() > arrBook[j + 1].getInterest()) {
                    Book temp = arrBook[j];
                    arrBook[j] = arrBook[j + 1];
                    arrBook[j + 1] = temp;
                }
            }
        }
        System.out.println("Danh sách sách đã được sắp xếp theo lợi nhuận tăng dần:");
        displayData();
    }

}
