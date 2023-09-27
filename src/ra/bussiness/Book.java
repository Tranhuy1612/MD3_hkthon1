package ra.bussiness;

import java.util.Scanner;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus = true;

    public Book() {
    }

    public Book(int bookId, String bookName, String author, String descriptions, double importPrice, double exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData(Scanner scanner, Book[] arrBook) {
        System.out.println("Nhập tên sách :");
        bookId = Integer.parseInt(scanner.nextLine());


        do {
            System.out.println("Nhập tên sách :");
            bookName = scanner.nextLine();
            if (bookName.trim().isEmpty()) {
                System.err.println("Tên sách không được để trống. Vui lòng nhập lại.");
            }
        } while (bookName.trim().isEmpty());

        do {
            System.out.println("Nhập tác giả  :");
            author = scanner.nextLine();
            if (author.trim().isEmpty()) {
                System.err.println("Tên tác giả  không được để trống. Vui lòng nhập lại.");
            }
        } while (author.trim().isEmpty());

        do {
            System.out.println("Nhập mô tả  :");
            descriptions = scanner.nextLine();
            if (descriptions.trim().isEmpty()) {
                System.err.println("Mô tả không được để trống. Vui lòng nhập lại.");
            }
        } while (descriptions.trim().isEmpty());


        System.out.print("nhập giá nhập ");
        this.importPrice = Double.parseDouble(scanner.nextLine());
        while (importPrice <= 0) {
            System.err.println("giá sản phẩm phải lớn hơn 0");
            this.importPrice = Double.parseDouble(scanner.nextLine());
        }

        System.out.print("nhập giá xuất : ");
        this.exportPrice = Double.parseDouble(scanner.nextLine());
        while (exportPrice < importPrice * 1.2) {
            System.err.println("Giá xuất phải lớn hơn 20% giá nhập");
            this.exportPrice = Double.parseDouble(scanner.nextLine());
        }

        System.out.println("nhập trạng thái ");
        bookStatus = Boolean.parseBoolean(scanner.nextLine());

        calculationInterest();
    }

    public void displayData() {
        System.out.println("Id :" + bookId + "| Tên sách :" + bookName + " | Tên tác giả :" + author
                + "| Mô tả :" + descriptions + "| Giá nhập :" + importPrice + " | Giá xuất :" + exportPrice
                + " | Lợi nhuận :" + interest + " | Trạng thái :" + (bookStatus ? "Đang bán" : "Không bán "));
    }

    public void calculationInterest() {
        interest = (float) (exportPrice - importPrice);
    }


}
