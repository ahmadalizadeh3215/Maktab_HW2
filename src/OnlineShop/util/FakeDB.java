package OnlineShop.util;

import OnlineShop.model.Address;
import OnlineShop.model.Category;
import OnlineShop.model.Product;
import OnlineShop.model.User;

import java.util.ArrayList;
import java.util.List;

public class FakeDB {
    List<Product> productList;
    List<User> userList;
    List<Category> categoryList;

    public FakeDB(List<Product> productList, List<User> userList, List<Category> categoryList) {
        this.productList = productList;
        this.userList = userList;
        this.categoryList = categoryList;
    }

    public FakeDB() {
    }
    public void addUser(User users) {
        this.userList.add(users);
    }
    public List<Product> getProductList() {
        return productList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }
    public void saveChargeBalance(User user, Double balance){
        Double newBalance = user.getAccountBalance();
        newBalance += balance;
        user.setAccountBalance(newBalance);
    }

    public void saveUpdateBalance(User user, Double fee){
        Double temp = user.getAccountBalance();
        temp -= fee;
        user.setAccountBalance(temp);
    }

    public void saveQuantityProductUpdate(Product product){
        Integer quantity = product.getQuantity();
        product.setQuantity(quantity - 1);
    }

    public void saveDeleteAccount(User user){
        for (int i = 0; i < this.userList.size() ; i++) {
            if (this.userList.get(i).getUserName().equals(user.getUserName())){
                this.userList.remove(i);
                break;
            }
        }
    }
    public void initFakeDB(){
        this.userList = new ArrayList<>();
        this.categoryList = new ArrayList<>();
        this.productList = new ArrayList<>();
        initFakeUserData();
        initFakeCategoryDataAndProduct();
    }

    private void initFakeUserData(){
        User userOne = new User();
        userOne.setFirstName("Ahma");
        userOne.setSurname("alalal");
        userOne.setUserName("alizad");
        userOne.setPassword("qwerdf");
        userOne.setEmailAddress("ahmadaliozad@gmail.com");
        userOne.setPhoneNumber("09158898981");
        userOne.setAccountBalance(5000.0);

        Address address1 = new Address("pennsylvania","banshee","baker","22","1234456778");
        userOne.setAddress(address1);

        User userTwo = new User();
        userTwo.setFirstName("lucas");
        userTwo.setSurname("hood");
        userTwo.setUserName("lucashood");
        userTwo.setPassword("Lh1997%&");
        userTwo.setEmailAddress("lucas.hood@Gmail.com");
        userTwo.setPhoneNumber("09128273721");
        userTwo.setAccountBalance(5000.0);

        Address address2 = new Address("arizona","tucson","jordan","12","877654321");
        userTwo.setAddress(address2);

        this.userList.add(userOne);
        this.userList.add(userTwo);
    }
    private void initFakeCategoryDataAndProduct(){
        //categories
        Category categoryElectronic = new Category("Electronic",null,null);
        Category categoryShoe = new Category("Shoe",null,null);
        Category categoryReadableItem = new Category("Readable item",null,null);
        this.categoryList.add(categoryElectronic);
        this.categoryList.add(categoryShoe);
        this.categoryList.add(categoryReadableItem);
        //subCategories one
        Category subCategoryTv = new Category("TV", categoryElectronic,1);
        Category subCategoryRadio = new Category("Radio", categoryElectronic,2);
        Category subCategoryMobile = new Category("Mobile", categoryElectronic,3);
        Category subCategoryLaptop = new Category("Laptop", categoryElectronic,4);
        Category subCategoryFormalShoe = new Category("Formal Shoe", categoryShoe,5);
        Category subCategorySportShoe = new Category("Sport Shoe", categoryShoe,6);
        Category subCategoryChildShoe = new Category("Child Shoe", categoryShoe,7);
        Category subCategoryMagazine = new Category("Magazine", categoryReadableItem,8);
        Category subCategoryBook = new Category("Book", categoryReadableItem,9);
        this.categoryList.add(subCategoryTv);
        this.categoryList.add(subCategoryRadio);
        this.categoryList.add(subCategoryMobile);
        this.categoryList.add(subCategoryLaptop);
        this.categoryList.add(subCategoryFormalShoe);
        this.categoryList.add(subCategorySportShoe);
        this.categoryList.add(subCategoryChildShoe);
        this.categoryList.add(subCategoryBook);
        this.categoryList.add(subCategoryMagazine);

        //subCategories electronic
        Category subCategoryLGTV = new Category("LG", subCategoryTv,1);
        Category subCategorySamsungTV = new Category("Samsung", subCategoryTv,1);
        Category subCategoryPanasonicTV = new Category("Panasonic", subCategoryTv,1);
        Category subCategorySonyRadio = new Category("Sony", subCategoryRadio,2);
        Category subCategoryPanasonicRadio = new Category("Panasonic", subCategoryRadio,2);
        Category subCategoryMarshalRadio = new Category("Marshal", subCategoryRadio,2);
        Category subCategoryAppleMobile= new Category("Apple", subCategoryMobile,3);
        Category subCategorySamsungMobile= new Category("Samsung", subCategoryMobile,3);
        Category subCategoryBlackberryMobile= new Category("Black berry", subCategoryMobile,3);
        Category subCategoryHpLaptop= new Category("HP", subCategoryLaptop,4);
        Category subCategoryDellLaptop= new Category("Dell", subCategoryLaptop,4);
        Category subCategoryLenovoLaptop= new Category("Lenovo", subCategoryLaptop,4);
        this.categoryList.add(subCategoryLGTV);
        this.categoryList.add(subCategorySamsungTV);
        this.categoryList.add(subCategoryPanasonicTV);
        this.categoryList.add(subCategorySonyRadio);
        this.categoryList.add(subCategoryPanasonicRadio);
        this.categoryList.add(subCategoryMarshalRadio);
        this.categoryList.add(subCategoryAppleMobile);
        this.categoryList.add(subCategorySamsungMobile);
        this.categoryList.add(subCategoryBlackberryMobile);
        this.categoryList.add(subCategoryHpLaptop);
        this.categoryList.add(subCategoryDellLaptop);
        this.categoryList.add(subCategoryLenovoLaptop);

        //subCategories shoe
        Category subCategoryWomenFormalShoe = new Category("Women's Shoes",subCategoryFormalShoe,5);
        Category subCategoryMenFormalShoe = new Category("Men's Shoes",subCategoryFormalShoe,5);
        Category subCategorySportShoeNike = new Category("Nike",subCategorySportShoe,6);
        Category subCategorySportShoeAdidas = new Category("Adidas",subCategorySportShoe,6);
        this.categoryList.add(subCategoryWomenFormalShoe);
        this.categoryList.add(subCategoryMenFormalShoe);
        this.categoryList.add(subCategorySportShoeNike);
        this.categoryList.add(subCategorySportShoeAdidas);

        //subCategory readable item
        Category subCategoryScientificMagazine = new Category("Scientific",subCategoryMagazine,8);
        Category subCategorySportMagazine = new Category("Sports",subCategoryMagazine,8);
        this.categoryList.add(subCategoryScientificMagazine);
        this.categoryList.add(subCategorySportMagazine);


        Category subCategoryScientificBook = new Category("Scientific",subCategoryBook,9);
        Category subCategoryNovelBook = new Category("Novel",subCategoryBook,9);
        this.categoryList.add(subCategoryScientificBook);
        this.categoryList.add(subCategoryNovelBook);


        //Electronic---------------------------------------------------------------
        //TV PRODUCT
        //Samsung TV product
        Product productOne = new Product();
        productOne.setProductName("Samsung Smart TV 4K 49 inch");
        productOne.setDescription("4K UHD TV goes beyond regular FHD TV with 4x more pixels,\n unlocking hidden details to offer your eyes the sharp and crisp images they deserve.");
        productOne.setQuantity(20);
        productOne.setUnitPrice(799.00);
        productOne.setCategory(subCategorySamsungTV);

        Product productTwo = new Product();
        productTwo.setProductName("Samsung Smart TV 4K 65 inch");
        productTwo.setDescription("Immerse yourself in a wide range of crystal clear colours that ensure you can see every subtlety.");
        productTwo.setQuantity(10);
        productTwo.setUnitPrice(1093.00);
        productTwo.setCategory(subCategorySamsungTV);

        //LG TV
        Product productTree = new Product();
        productTree.setProductName("LG OLED TV 4K 65 inch");
        productTwo.setDescription(" LG 4K SELF-LIT OLED for infinite contrast & 100% colour fidelity\n" +
                "α7 Gen4 AI processor 4K - outstanding picture & sound\n" +
                "Exceptional cinema & sport with Dolby Vision IQ and Dolby Atmos\n" +
                "Smart LG technology, LG AI ThinQ\n" +
                "webOS Smart TV with Pointing and Wheel Control Magic Remote\n" +
                "Eye Comfort Display, Eco-friendly OLED");
        productTree.setQuantity(13);
        productTree.setUnitPrice(1200.00);
        productTree.setCategory(subCategoryLGTV);

        Product productFour = new Product();
        productFour.setProductName("LG NANO CELL TV 4K 65 inch");
        productFour.setDescription("Real 4K NANO Cell for Pure coloer with Nano Color , Nano Accuracy\n" +
                "α5 AI Processor 4k with AI 4K upscaling\n" +
                "ThinQ AI webOS Smart TV with Magic Remote\n" +
                "True Cinema Experience suported with Active HDR , Film Maker Mode AI Sound\n" +
                "Unlimited Gameplay with HGiG , ALLM , HDMI 2.0 eARC\n");
        productFour.setQuantity(10);
        productFour.setUnitPrice(1033.00);
        productFour.setCategory(subCategoryLGTV);


        //panasonic TV
        Product productFive = new Product();
        productFive.setProductName("Panasonic LED TV TH-65GX800M 65 inch");
        productFive.setDescription("Panel: 4K ULTRA HD IPS LED LCD\n" +
                "Bright Panel: Super Bright Panel Plus\n" +
                "Screen Resolution: 3,840 (W) x 2,160 (H)\n" +
                "Panel Drive: 4K 1800 Hz BMR\n" +
                "Picture Mode: Dynamic/Normal/Cinema/True Cinema/Custom/DolbyVision (Vivid/Bright/Dark)/Game\n" +
                "Signal Processor: HCX Processor\n" +
                "Speakers: Box Bottom (Full Range) x 2\n" +
                "Speaker Output: 20 W (10 W x 2)\n" +
                "Voice Personal Assistant: Works with Google Assistant, Works with Alexa (TBD)");
        productFive.setQuantity(8);
        productFive.setUnitPrice(856.00);
        productFive.setCategory(subCategoryPanasonicTV);

        this.productList.add(productOne);
        this.productList.add(productTwo);
        this.productList.add(productTree);
        this.productList.add(productFour);
        this.productList.add(productFive);

        //Radio Product
        //Sony
        Product productSix = new Product();
        productSix.setProductName("Sony ICF-P36 Radio");
        productSix.setDescription("Dimensions: 131.5x69.5x43.5 cm\n" +
                "Weight: 220 g\n" +
                "Received waves: FM , AM\n" +
                "Energy source: Battery\n" +
                "Search type: Manual");
        productSix.setQuantity(18);
        productSix.setUnitPrice(160.00);
        productSix.setCategory(subCategorySonyRadio);

        //Panasonic
        Product productSeven = new Product();
        productSeven.setProductName("Panasonic RF-800U Radio");
        productSeven.setDescription("Dimensions: 9.7 × 14 × 27 cm\n" +
                "Weight: 1900 g\n" +
                "Received waves: FM,SW\n" +
                "Energy source: Battery\n" +
                "Search type: Manual");
        productSeven.setQuantity(4);
        productSix.setUnitPrice(212.00);
        productSeven.setCategory(subCategoryPanasonicRadio);

        this.productList.add(productSix);
        this.productList.add(productSeven);


        //Mobile Product
        //Apple
        Product productEight = new Product();
        productEight.setProductName("iphone 13 pro 256 Dual sim");
        productEight.setDescription("Dimensions: 146.7x71.5x7.7\n" +
                "Weight: 204 grams\n" +
                "Chip: Apple A15 Bionic (5 nm) Chipset\n" +
                "CPU: Hexa-core CPU\n" +
                "GPU: Apple GPU (5-core graphics) GPU:" +
                "Internal memory: 256 GB\n" +
                "RAM: 6 GB \n" +
                "Display technology: Super Retina XDR OLED\n" +
                "Resolution: 2532x1170 pixels\n");
        productEight.setQuantity(11);
        productEight.setUnitPrice(1333.00);
        productEight.setCategory(subCategoryAppleMobile);


        //Samsung
        Product productNine = new Product();
        productNine.setProductName("Galaxy Z Flip3 5G");
        productNine.setDescription("Dimensions: 166x72.2x6.9\n" +
                "Weight: 183 grams\n" +
                "CPU: Octa-core Processor 5nm\n" +
                "Internal memory: 256 GB\n" +
                "RAM: 8 GB \n" +
                "Display technology: Dynamic AMOLED 2X\n" +
                "Resolution: 2640x1080 pixels\n");
        productNine.setQuantity(15);
        productNine.setUnitPrice(1231.00);
        productNine.setCategory(subCategorySamsungMobile);

        this.productList.add(productEight);
        this.productList.add(productNine);

        //Laptop Product
        //Dell
        Product productTen = new Product();
        productTen.setProductName("Dell laptop Inspiron 5406 14 inch");
        productTen.setDescription("Dimensions: 166x72.2x6.9\n" +
                "Weight: 1.62 kg\n" +
                "CPU: intel core i5\n" +
                "Internal memory: 256 GB\n" +
                "RAM capacity: 16 GB DDR4\n" +
                "Resolution: HD | 1366x768\n" +
                "Battery: Three cell");
        productTen.setQuantity(7);
        productTen.setUnitPrice(1499.00);
        productTen.setCategory(subCategoryDellLaptop);


        //HP
        Product productEleven = new Product();
        productEleven.setProductName("HP laptop ENVY X360 15T ED000-B 15 inch");
        productEleven.setDescription("Dimensions: 357x230x18\n" +
                "Weight: 1.9 kg\n" +
                "CPU: intel core i7\n" +
                "Internal memory: 256 GB SSD\n" +
                "RAM capacity: 32 GB DDR4\n" +
                "Resolution: Full HD | 1920x1080\n" +
                "Battery: Three cell");
        productEleven.setQuantity(5);
        productEleven.setUnitPrice(1799.0);
        productEleven.setCategory(subCategoryHpLaptop);

        this.productList.add(productTen);
        this.productList.add(productEleven);
        //Electronic---------------------------------------------------------------

        //shoe---------------------------------------------------------------------
        //Shoe Product
        // women Formal Shoe
        Product productTwelve = new Product();
        productTwelve.setProductName("Clarks Women's Warren Slip-On Loafer size 37");
        productTwelve.setDescription("Product Dimensions: 10 x 15 x 6 inches; 10 Ounces\n" +
                "Item model number: 26128442\n" +
                "Department: Womens\n" +
                "Date First Available: June 2, 2017\n" +
                "Manufacturer: Clarks");
        productTwelve.setQuantity(12);
        productTwelve.setUnitPrice(66.00);
        productTwelve.setCategory(subCategoryWomenFormalShoe);

        Product productThirteen = new Product();
        productThirteen.setProductName("Madden Girl Women's Beella Dress Sandal size 36");
        productThirteen.setDescription("Product Dimensions: 5 x 5 x 0.7 inches; 8.4 Ounces\n" +
                "Item model number: Beella\n" +
                "Department: Womens\n" +
                "Date First Available: March 3, 2017\n" +
                "Manufacturer: Madden Girl");
        productThirteen.setQuantity(20);
        productThirteen.setUnitPrice(54.00);
        productThirteen.setCategory(subCategoryWomenFormalShoe);

        this.productList.add(productTwelve);
        this.productList.add(productThirteen);


        // men formal shoe
        Product productFourteen = new Product();
        productFourteen.setProductName("Clarks Men's Tilden Free Slip-On Loafer");
        productFourteen.setDescription("Is Discontinued By Manufacturer: No\n" +
                "Product Dimensions: 12.8 x 8.5 x 4.8 inches; 1.01 Pounds\n" +
                "Item model number: 26110312\n" +
                "Department: Mens\n" +
                "Date First Available: June 26, 2015\n" +
                "Manufacturer: Clarks");
        productFourteen.setQuantity(11);
        productFourteen.setUnitPrice(65.00);
        productFourteen.setCategory(subCategoryMenFormalShoe);

        this.productList.add(productFourteen);


        // sport shoe nike
        Product productFifteen = new Product();
        productFifteen.setProductName("Nike Men's-Women's Free Rn 2018 Running Shoe");
        productFifteen.setDescription("Is Discontinued By Manufacturer: No\n" +
                "Product Dimensions: 9.06 x 12.99 x 0.79 inches; 13.76 Ounces\n" +
                "Item model number: 942836\n" +
                "Date First Available: July 18, 2018");
        productFifteen.setQuantity(9);
        productFifteen.setUnitPrice(119.00);
        productFifteen.setCategory(subCategorySportShoeNike);

        this.productList.add(productFifteen);


        //adidas sport shoe
        Product productSixteen = new Product();
        productSixteen.setProductName("adidas Men's-Women's Grand Court Sneaker");
        productSixteen.setDescription("Package Dimensions: 11.26 x 7.56 x 4.33 inches; 1.68 Pounds\n" +
                "Item model number: GZ8186\n" +
                "Date First Available: June 1, 2021\n" +
                "Manufacturer: adidas");
        productSixteen.setQuantity(10);
        productSixteen.setUnitPrice(149.00);
        productSixteen.setCategory(subCategorySportShoeAdidas);

        this.productList.add(productSixteen);


        //child shoe
        Product productSeventeen = new Product();
        productSixteen.setProductName("Under Armour Unisex-Child Grade School Assert 9 Running Shoe");
        productSixteen.setDescription("Package Dimensions: 11.14 x 7.68 x 4.02 inches; 1.15 Pounds\n" +
                "Item model number: 3024634\n" +
                "Date First Available: August 31, 2020\n" +
                "Manufacturer: Under Armour");
        productSixteen.setQuantity(16);
        productSixteen.setUnitPrice(59.00);
        productSixteen.setCategory(subCategoryChildShoe);

        this.productList.add(productSeventeen);

        // readable Item
        //book
        //novel
        Product productEighteen = new Product();
        productEighteen.setProductName("DEAR EVAN HANSEN");
        productEighteen.setDescription("Publisher: PENGUIN (June 13, 2019)\n" +
                "Language: English\n" +
                "Paperback: 368 pages\n" +
                "ISBN-10: 0241361885\n" +
                "ISBN-13: 978-0241361887\n" +
                "Reading age: 12 - 17 years\n" +
                "Item Weight: 9 ounces\n" +
                "Dimensions: 5.08 x 0.87 x 7.8 inches");
        productEighteen.setQuantity(1);
        productEighteen.setUnitPrice(11.00);
        productEighteen.setCategory(subCategoryNovelBook);

        this.productList.add(productEighteen);


        Product productNineteen = new Product();
        productNineteen.setProductName(" What If?: Serious Scientific Answers to Absurd Hypothetical Questions");
        productNineteen.setDescription("Publisher: Mariner Books; First Edition (September 2, 2014)\n" +
                "Language: English\n" +
                "Hardcover: 320 pages\n" +
                "ISBN-10: 0544272994\n" +
                "ISBN-13 : 978-0544272996\n" +
                "Item Weight: 1.8 pounds\n" +
                "Dimensions : 7 x 1.17 x 9 inches");
        productNineteen.setQuantity(3);
        productNineteen.setUnitPrice(10.00);
        productNineteen.setCategory(subCategoryScientificBook);

        this.productList.add(productNineteen);

        //Magazine
        Product productTwenty = new Product();
        productTwenty.setProductName(" Southern Living");
        productTwenty.setDescription("Date First Available: September 25, 2014\n" +
                "Manufacturer: Meredith Corporation");
        productTwenty.setQuantity(7);
        productTwenty.setUnitPrice(5.00);
        productTwenty.setCategory(subCategoryScientificMagazine);
        this.productList.add(productTwenty);
    }


}
