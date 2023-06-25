package Management;

import entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class customerListManagement {
    public static void main(String[] args) {

    List<Customer> customers = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    // Nhập danh sách khách hàng
        System.out.print("Nhập số lượng khách hàng: ");
    int customerCount = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự '\n' sau khi đọc số lượng khách hàng

        for (int i = 0; i < customerCount; i++) {
        System.out.println("Nhập thông tin khách hàng thứ " + (i + 1) + ":");

        System.out.print("Mã KH: ");
        String code = scanner.nextLine();

        System.out.print("Họ tên: ");
        String fullName = scanner.nextLine();

        System.out.print("Địa chỉ: ");
        String address = scanner.nextLine();

        System.out.print("Số ĐT: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Loại KH: ");
        String customerType = scanner.nextLine();

        Customer customer = new Customer(code, fullName, address, phoneNumber, customerType);
        customers.add(customer);
    }
        System.out.println("Danh sách khách hàng đã có:");
        for (Customer customer : customers) {
        System.out.println(customer);

    }
}
}
