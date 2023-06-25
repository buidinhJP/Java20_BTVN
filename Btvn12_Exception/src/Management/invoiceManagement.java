package Management;
import entity.Customer;
import entity.Invoice;
import entity.Service;

import java.util.*;

public class invoiceManagement{
    public static void main(String[] args) {
        List<Invoice> invoices = new ArrayList<>();

        Map<Customer, List<Invoice>> invoiceMap = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===============================PHẦN MỀM QUẢN LÝ HÓA ĐƠN============================");
            System.out.println("1. Nhập danh sách khách hàng.");
            System.out.println("2. Nhập danh sách dịch vụ.");
            System.out.println("3. Nhập hóa đơn cho khách hàng.");
            System.out.println("4. In danh sách hóa đơn.");
            System.out.println("5. Sắp xếp danh sách hóa đơn.");
            System.out.println("6. Lập bàng kê số tiền phải trả. ");
            System.out.println("7. Thoát.");
            System.out.print("Chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự '\n' sau khi đọc lựa chọn

            switch (choice) {
                case 1:
                    List<Customer> customers = new ArrayList<>();

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
                    break;
                case 2:
                    List<Service> services = new ArrayList<>();



                    System.out.print("Nhập số lượng dịch vụ: ");
                    int serviceCount = scanner.nextInt();
                    scanner.nextLine(); // Đọc ký tự '\n' sau khi đọc số lượng dịch vụ

                    for (int i = 0; i < serviceCount; i++) {
                        System.out.println("Nhập thông tin dịch vụ thứ " + (i + 1) + ":");
                        System.out.print("Mã DV: ");
                        int serviceId = scanner.nextInt();
                        scanner.nextLine(); // Đọc ký tự '\n' sau khi đọc mã DV

                        System.out.print("Tên DV: ");
                        String serviceName = scanner.nextLine();

                        System.out.print("Giá cước: ");
                        double servicePrice = scanner.nextDouble();
                        scanner.nextLine(); // Đọc ký tự '\n' sau khi đọc giá cước

                        System.out.print("Đơn vị tính: ");
                        String serviceUnit = scanner.nextLine();

                        Service service = new Service(serviceId, serviceName, servicePrice, serviceUnit);
                        services.add(service);
                    }

                    System.out.println("Danh sách dịch vụ đã có:");
                    for (Service service : services) {
                        System.out.println(service);
                    }

                    break;
                case 3:
                    System.out.print("Nhập mã KH: ");
                    int customerId = scanner.nextInt();
                    scanner.nextLine(); // Đọc ký tự '\n' sau khi đọc mã KH

                    System.out.print("Nhập mã DV: ");
                    int serviceId = scanner.nextInt();
                    scanner.nextLine(); // Đọc ký tự '\n' sau khi đọc mã DV

                    System.out.print("Nhập số lượng: ");
                    double quantity = scanner.nextDouble();
                    scanner.nextLine(); // Đọc ký tự '\n' sau khi đọc số lượng

                    Customer customer = new Customer(customerId);
                    Invoice invoice = new Invoice(serviceId, quantity);

                    if (invoiceMap.containsKey(customer)) {
                        invoices = invoiceMap.get(customer);
                        boolean duplicate = false;

                        for (Invoice existingInvoice : invoices) {
                            if (existingInvoice.getServiceId() == serviceId) {
                                duplicate = true;
                                break;
                            }
                        }

                        if (!duplicate) {
                            invoices.add(invoice);
                        } else {
                            System.out.println("Hóa đơn đã tồn tại cho khách hàng và dịch vụ tương ứng.");
                        }
                    } else {

                        invoices.add(invoice);
                        invoiceMap.put(customer, invoices);
                    }

                    break;
                case 4:
                    System.out.println("Danh sách hóa đơn:");
                    for (Map.Entry<Customer, List<Invoice>> entry : invoiceMap.entrySet()) {
                        Customer cust = entry.getKey();
                        List<Invoice> invs = entry.getValue();

                        System.out.print("Mã KH: " + cust.getCustomerId());
                        for (Invoice inv : invs) {
                            System.out.print("  Mã DV: " + inv.getServiceId());
                            System.out.println("  Số lượng: " + inv.getQuantity());
                        }
                    }
                    break;
                case 5:

                    sortByFullName(invoices);
                    System.out.println("Đã sắp xếp danh sách hóa đơn theo Họ tên khách hàng.");
                    break;

                case 6:
                    System.out.println("Bảng kê số tiền phải trả cho mỗi khách hàng:");
                    for (Map.Entry<Customer, List<Invoice>> entry : invoiceMap.entrySet()) {
                        Customer cust = entry.getKey();
                        List<Invoice> invs = entry.getValue();

                        double totalAmount = 0;
                        for (Invoice inv : invs) {
                            totalAmount += inv.getTotalAmount();
                        }
                        System.out.println("Mã KH: " + cust.getCustomerId());
                        System.out.println("Tổng số tiền phải trả: " + totalAmount);
                    }
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
        }
        private static void sortByFullName(List<Invoice> invoices) {
            Collections.sort(invoices, new Comparator<Invoice>() {
                @Override
                public int compare(Invoice invoice1, Invoice invoice2) {
                    String fullName1 = invoice1.getCustomer().getFullName();
                    String fullName2 = invoice2.getCustomer().getFullName();
                    return fullName1.compareTo(fullName2);
                }
            });
        }

        private static void sortByQuantity(List<Invoice> invoices) {
            Collections.sort(invoices, new Comparator<Invoice>() {
                @Override
                public int compare(Invoice invoice1, Invoice invoice2) {
                    double quantity1 = invoice1.getQuantity();
                    double quantity2 = invoice2.getQuantity();
                    return Double.compare(quantity2, quantity1);
                }
            });

    }
}

