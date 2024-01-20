///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package Main;
//
//import TheBusiness.Business.Business;
//import TheBusiness.CustomerManagement.CustomerDirectory;
//import TheBusiness.CustomerManagement.CustomerProfile;
//import TheBusiness.OrderManagement.Order;
//import TheBusiness.Personnel.Person;
//import TheBusiness.Personnel.PersonDirectory;
//import TheBusiness.ProductManagement.Product;
//import TheBusiness.SalesManagement.SalesPersonDirectory;
//import TheBusiness.SalesManagement.SalesPersonProfile;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONException;
//import org.json.simple.JSONObject;
//import org.json.simple.JSONString;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
///**
// *
// * @author aayus
// */
//public class ConfigureABusiness {
//    
//   static Business initializeMarkets() throws FileNotFoundException, ParseException, IOException{
//       
//        Business business = new Business("Xerox");
//    
//        
//    //String jsonString = readFile("src/util/data.json");
//    
//    Object jsonObj = new JSONParser().parse(new FileReader("data.json"));
//
//    JSONObject jsonObject = new JSONObject(jsonObj);  
//    
//    CustomerDirectory customerDirectory = business.getCustomerDirectory();
//    
//    JSONObject customerDirectoryObject = jsonObject.getJSONObject("CustomerDirectory");
//    JSONArray customers = customerDirectoryObject.getJSONArray("CustomerList");
//    
//    for(int i =0; i < 1; i++){
//        
//        PersonDirectory persondirectory = business.getPersonDirectory();
//        
//        JSONObject customerObject = customers.getJSONObject(i);
//        JSONObject personObject = customerObject.getJSONObject("person");
//        
//
//        Person person = persondirectory.newPerson(personObject.getString("id"));
////        person.
//        CustomerProfile customerProfile = customerDirectory.newCustomerProfile(person);
//        
//        JSONArray orders = customerObject.getJSONArray("orders");
//        
//        Order order = new Order(customerProfile);
//        customerProfile.addCustomerOrder(order);
//        
//        for(int j = 0; j < orders.length(); j++){
//            JSONObject ordersObject = orders.getJSONObject(j);
//            JSONArray orderItems = ordersObject.getJSONArray("orderItems");
//            
//            for(int k = 0 ; k < orderItems.length(); j++){
//                
//                JSONObject orderItemObject = orderItems.getJSONObject(k);
//                int actualPrice = orderItemObject.getInt("actualPrice");
//                int quantity = orderItemObject.getInt("quantity");
//                String customerId = orderItemObject.getString("customerID");
//                String marketName = orderItemObject.getString("marketName");
//                String channel = orderItemObject.getString("channel");
//                JSONObject selectedProductObject = orderItemObject.getJSONObject("selectedProduct");
//                String productName = selectedProductObject.getString("name");
//                int floorPrice = selectedProductObject.getInt("floorPrice");
//                int ceilingprice = selectedProductObject.getInt("ceilingPrice");
//                int targetPrice = selectedProductObject.getInt("targetPrice");
//                Product product = new Product(productName, floorPrice, ceilingprice, targetPrice);
//                order.newOrderItem(product, actualPrice, quantity);
//                
//            }
//            
//            JSONObject salesPersonObject = ordersObject.getJSONObject("salesPerson");
//            JSONObject salesPerson = salesPersonObject.getJSONObject("person");
////            
//            Person sales = persondirectory.newPerson(salesPerson.getString("id"));
//
//            SalesPersonDirectory salespersondirectory = business.getSalesPersonDirectory();
//            SalesPersonProfile salespersonprofile = salespersondirectory.newSalesPersonProfile(sales);
//            salespersonprofile.addSalesOrder(order);
//            
//        }
//        
//    }
//    
//    ObjectMapper mapper = new ObjectMapper();
//    
//    String res = mapper.writeValueAsString(business);
//    
////       System.out.println(res);
//    return business;
//   }
//    
//}
