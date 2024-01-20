/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package UserInterface.Main;
//
//import MarketingManagement.MarketingPersonDirectory;
//import MarketingManagement.MarketingPersonProfile;
//import TheBusiness.Business.Business;
//import TheBusiness.CustomerManagement.CustomerDirectory;
//import TheBusiness.CustomerManagement.CustomerProfile;
//import TheBusiness.OrderManagement.MasterOrderList;
//import TheBusiness.OrderManagement.Order;
//import TheBusiness.OrderManagement.OrderItem;
//import TheBusiness.Personnel.Person;
//import TheBusiness.Personnel.PersonDirectory;
//import TheBusiness.ProductManagement.Product;
//import TheBusiness.ProductManagement.ProductCatalog;
//import TheBusiness.SalesManagement.SalesPersonDirectory;
//import TheBusiness.SalesManagement.SalesPersonProfile;
//import TheBusiness.Supplier.Supplier;
//import TheBusiness.Supplier.SupplierDirectory;
//import TheBusiness.UserAccountManagement.UserAccount;
//import TheBusiness.UserAccountManagement.UserAccountDirectory;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
///**
// *
// * @author kal bugrara
// */
//class ConfigureABusiness {
//
//    static Business initialize() throws JsonProcessingException {
//        Business business = new Business("Xerox");
//        SupplierDirectory suplierdirectory = business.getSupplierDirectory();
//
//        Supplier supplier1 = suplierdirectory.newSupplier("Lenovo");
//        ProductCatalog productcatalog = supplier1.getProductCatalog();
//        Product products1p1 = productcatalog.newProduct("Scanner 3  1", 2000, 16500, 10000);
//        Product products1p2 = productcatalog.newProduct("Scanner 4", 10000, 25000, 16500);
//        Product products1p3 = productcatalog.newProduct("Printer 2", 22000, 40000, 36500);
//        Product products1p4 = productcatalog.newProduct("Photocopier 2 ", 30000, 70000, 50000);
//        Product products1p5 = productcatalog.newProduct("Scanner  5", 19000, 36500, 25000);
//        Product products1p6 = productcatalog.newProduct("Scanner 6", 90000, 125000, 105000);
//        Product products1p7 = productcatalog.newProduct("Printer 3", 22000, 60000, 36500);
//        Product products1p8 = productcatalog.newProduct("Photocopier 3", 30000, 70000, 50000);
//
//        //       SupplierDirectory suplierdirectory = business.getSupplierDirectory();
//        Supplier supplier2 = suplierdirectory.newSupplier("Epson");
//        productcatalog = supplier2.getProductCatalog();
//        Product products2p1 = productcatalog.newProduct("Scanner 13  1", 12000, 26000, 18500);
//        Product products2p2 = productcatalog.newProduct("Scanner 14", 90000, 165000, 125000);
//        Product products2p3 = productcatalog.newProduct("Color Printer 112", 422000, 540000, 495000);
//        Product products2p4 = productcatalog.newProduct("Photocopier 922 ", 430000, 890000, 550000);
//        Product products2p5 = productcatalog.newProduct("Low toner Scanner  102", 195000, 500100, 365102);
//        Product products2p6 = productcatalog.newProduct("Speedy color Scanner 611", 900000, 125000, 1650000);
//        Product products2p7 = productcatalog.newProduct("Premier Printer 300", 322000, 470000, 736500);
//        Product products2p8 = productcatalog.newProduct("Color Photocopier 500", 350000, 580000, 780000);
//
//// Create Persons
//        PersonDirectory persondirectory = business.getPersonDirectory();
//// person representing sales organization        
//        Person xeroxsalesperson001 = persondirectory.newPerson("Xerox sales");
//        Person xeroxmarketingperson001 = persondirectory.newPerson("Xerox marketing");
//        Person xeroxadminperson001 = persondirectory.newPerson("Xerox admin");
//
//
//// Create person objects to represent customer organizations. 
//        Person person005 = persondirectory.newPerson("Dell");
//        Person person006 = persondirectory.newPerson("Microsoft");
//        Person person007 = persondirectory.newPerson("Google");
//        Person person008 = persondirectory.newPerson("JP Morgan");
//        Person person009 = persondirectory.newPerson("State street"); //we use this as customer
//
//// Create Customers
//        CustomerDirectory customedirectory = business.getCustomerDirectory();
//        CustomerProfile customerprofile1 = customedirectory.newCustomerProfile(person005);
//        CustomerProfile customerprofile2 = customedirectory.newCustomerProfile(person006);
//        CustomerProfile customerprofile3 = customedirectory.newCustomerProfile(person007);
//        CustomerProfile customerprofile4 = customedirectory.newCustomerProfile(person008);
//        CustomerProfile customerprofile5 = customedirectory.newCustomerProfile(person009);
//
//// Create Sales people
//        SalesPersonDirectory salespersondirectory = business.getSalesPersonDirectory();
//        SalesPersonProfile salespersonprofile = salespersondirectory.newSalesPersonProfile(xeroxsalesperson001);
//
//// Create Marketing people
//        MarketingPersonDirectory marketingpersondirectory = business.getMarketingPersonDirectory();
//        MarketingPersonProfile marketingpersonprofile0 = marketingpersondirectory.newMarketingPersonProfile(xeroxmarketingperson001);
//
//// Create Admins to manage the business
// //       EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
// //       EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(xeroxadminperson001);
//
//// Create User accounts that link to specific profiles
//        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
//        UserAccount ua1 = uadirectory.newUserAccount(salespersonprofile, "Sales", "XXXX"); /// order products for one of the customers and performed by a sales person
//        UserAccount ua2 = uadirectory.newUserAccount(marketingpersonprofile0, "Marketing", "XXXX"); /// order products for one of the customers and performed by a sales person
// //       UserAccount ua3 = uadirectory.newUserAccount(employeeprofile0, "Admin", "XXXX"); /// order products for one of the customers and performed by a sales person
//
//// Process Orders on behalf of sales person and customer
//        MasterOrderList masterorderlist = business.getMasterOrderList();
//        Order order1 = masterorderlist.newOrder(customerprofile4, salespersonprofile);
//        OrderItem oi1 = order1.newOrderItem(products1p1, 18000, 1);
//        OrderItem oi2 = order1.newOrderItem(products1p2, 19500, 4);
//        OrderItem oi3 = order1.newOrderItem(products1p3, 36500, 10);
//        OrderItem oi4 = order1.newOrderItem(products1p4, 50000, 1);
//        OrderItem oi5 = order1.newOrderItem(products1p5, 25000, 3);
//        OrderItem oi6 = order1.newOrderItem(products1p6, 105000, 2);
//        OrderItem oi7 = order1.newOrderItem(products1p7, 36500, 3);
//        OrderItem oi8 = order1.newOrderItem(products1p8, 50000, 2);
//
//        Order order12 = masterorderlist.newOrder(customerprofile4, salespersonprofile);
//        OrderItem oi112 = order1.newOrderItem(products1p1, 17000, 1);
//        OrderItem oi12 = order1.newOrderItem(products1p2, 9500, 4);
//        OrderItem oi13 = order1.newOrderItem(products1p3, 29500, 10);
//        OrderItem oi14 = order1.newOrderItem(products1p4, 30000, 1);
//        OrderItem oi15 = order1.newOrderItem(products1p5, 2000, 3);
//        OrderItem oi16 = order1.newOrderItem(products1p6, 95000, 2);
//        OrderItem oi17 = order1.newOrderItem(products1p7, 26500, 3);
//        OrderItem oi18 = order1.newOrderItem(products1p8, 40000, 2);
//
//        
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
//
//        String res = mapper.writeValueAsString(business);
//
//        System.out.println("=============================");
//
//        System.out.println(res);
//        
//        return business;
//
//    }
//
//}



///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//
package UserInterface.Main;
import TheBusiness.Business.Business;
import TheBusiness.CustomerManagement.CustomerDirectory;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.OrderManagement.Order;
import TheBusiness.Personnel.Person;
import TheBusiness.Personnel.PersonDirectory;
import TheBusiness.ProductManagement.Product;
import TheBusiness.SalesManagement.SalesPersonDirectory;
import TheBusiness.SalesManagement.SalesPersonProfile;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ConfigureABusiness {

    static Business initialize() throws IOException, ParseException {

        Business business = new Business("Xerox");

        Object jsonObj = new JSONParser().parse(new FileReader("data.json"));
        JSONObject jsonObject = (JSONObject) jsonObj;

//        System.out.println(jsonObject);
        CustomerDirectory customerDirectory = business.getCustomerDirectory();

        JSONArray customers = (JSONArray) jsonObject.get("customerList");
        
//        System.out.println(customers);
        
        for (int i = 0; i < customers.size(); i++) {

            PersonDirectory persondirectory = business.getPersonDirectory();

            JSONObject customerObject = (JSONObject) customers.get(i);
            JSONObject personObject = (JSONObject) customerObject.get("person");
            
//                    System.out.println(personObject);

            
            Person person = persondirectory.newPerson((String) personObject.get("id"));
//            System.out.println(person);
            CustomerProfile customerProfile = customerDirectory.newCustomerProfile(person);
           //System.out.println(customerProfile);

            JSONArray orders = (JSONArray) customerObject.get("orders");
            Order order = new Order(customerProfile);
                        System.out.println(order);

            customerProfile.addCustomerOrder(order);
            for (int j = 0; j < orders.size(); j++) {

                JSONObject ordersObject = (JSONObject) orders.get(j);
                JSONArray orderItems = (JSONArray) ordersObject.get("orderItems");
                
                                if (orderItems != null) {

                
                for (int k = 0; k < orderItems.size(); k++) {

                    JSONObject orderItemObject = (JSONObject) orderItems.get(k);
                    int actualPrice = Integer.parseInt(orderItemObject.get("actualPrice").toString());
                    int quantity = Integer.parseInt(orderItemObject.get("quantity").toString());
                    String customerId = (String) orderItemObject.get("customerID");
                    String marketName = (String) orderItemObject.get("marketName");
                    String channel = (String) orderItemObject.get("channel");
                    JSONObject selectedProductObject = (JSONObject) orderItemObject.get("selectedProduct");
                    String productName = (String) selectedProductObject.get("name");
                    int floorPrice = Integer.parseInt(selectedProductObject.get("floorPrice").toString());
                    int ceilingprice = Integer.parseInt(selectedProductObject.get("ceilingPrice").toString());
                    int targetPrice = Integer.parseInt(selectedProductObject.get("targetPrice").toString());
                    Product product = new Product(productName, floorPrice, ceilingprice, targetPrice);
                    order.newOrderItem(product, actualPrice, quantity);

                }
                
                                }

                JSONObject salesPersonObject = (JSONObject) ordersObject.get("salesPerson");
                
                if (salesPersonObject != null) {
              
                JSONObject salesPerson = (JSONObject) salesPersonObject.get("person");

                Person sales = persondirectory.newPerson((String) salesPerson.get("id"));

                SalesPersonDirectory salespersondirectory = business.getSalesPersonDirectory();
                SalesPersonProfile salespersonprofile = salespersondirectory.newSalesPersonProfile(sales);
                salespersonprofile.addSalesOrder(order);
                }

            }
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        String res = mapper.writeValueAsString(business);

        System.out.println("=============================");

        System.out.println(res);
        return business;
    }
}
