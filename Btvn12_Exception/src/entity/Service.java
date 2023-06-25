package entity;

public class Service {
        private static int AUTO_ID = 100;

        private String code;
        private String name;
        private double price;
        private String unit;

        public Service(int serviceId, String name, double price, String unit) {
            this.code = "DV" + AUTO_ID;
            this.name = name;
            this.price = price;
            this.unit = unit;

            AUTO_ID++;
        }


        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public String getUnit() {
            return unit;
        }

        @Override
        public String toString() {
            return "Service{" +
                    "code='" + code + '\'' +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    ", unit='" + unit + '\'' +
                    '}';
        }
    }

