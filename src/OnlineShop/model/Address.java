package OnlineShop.model;



    public class Address {
        private String state;
        private String city;
        private String street;
        private String alley;
        private String postalCode;

        public Address() {}

        public Address(String state, String city, String street, String alley, String postalCode) {
            this.state = state;
            this.city = city;
            this.street = street;
            this.alley = alley;
            this.postalCode = postalCode;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getAlley() {
            return alley;
        }

        public void setAlley(String alley) {
            this.alley = alley;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }
}
