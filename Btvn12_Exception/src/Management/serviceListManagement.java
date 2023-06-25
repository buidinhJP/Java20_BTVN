package Management;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entity.Service;
public class serviceListManagement {
        public static void main(String[] args) {
            List<Service> services = new ArrayList<>();

            Scanner scanner = new Scanner(System.in);

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
        }
    }
    
