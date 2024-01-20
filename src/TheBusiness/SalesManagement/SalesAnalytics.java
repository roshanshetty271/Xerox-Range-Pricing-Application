package TheBusiness.SalesManagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Objects;


public class SalesAnalytics {

    @SuppressWarnings("element-type-mismatch")
    public static List<SolutionOrder> getTopNegotiatedSolutions(List<SolutionOrder> solutionOrders) {
        Map<SolutionOrder, Double> solutionRevenues = new HashMap<>();
        for (SolutionOrder solutionOrder : solutionOrders) {
            solutionRevenues.put(solutionOrder, solutionOrder.calculateTotalRevenue());
        }

        Map<Market, List<SolutionOrder>> solutionsByMarket = solutionRevenues.keySet().stream()
                .collect(Collectors.groupingBy(solutionOrder -> solutionOrder.getSolution().getMarket()));

        List<SolutionOrder> topNegotiatedSolutions = new ArrayList<>();
        for (Map.Entry<Market, List<SolutionOrder>> entry : solutionsByMarket.entrySet()) {
            List<SolutionOrder> solutionsInMarket = entry.getValue();

            List<SolutionOrder> topSolutionsInMarket = solutionsInMarket.stream()
                    .distinct() // Ensure distinct instances based on equals and hashCode
                    .limit(3)
                    .collect(Collectors.toList());

            topNegotiatedSolutions.addAll(topSolutionsInMarket);
        }

        topNegotiatedSolutions.sort(Comparator.comparingDouble(SolutionOrder::getRevenue).reversed());

        return topNegotiatedSolutions.stream().limit(3).collect(Collectors.toList());
    }


    public static List<Customer> getTopCustomers(List<SolutionOrder> solutionOrders, double targetPrice) {
    Map<Customer, Double> customerSpending = solutionOrders.stream()
            .collect(Collectors.groupingBy(SolutionOrder::getCustomer, Collectors.summingDouble(SolutionOrder::getRevenue)));

    List<Customer> sortedCustomers = customerSpending.entrySet().stream()
            .sorted(Map.Entry.<Customer, Double>comparingByValue().reversed())
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

    List<Customer> topCustomers = sortedCustomers.stream()
            .filter(customer -> customerSpending.get(customer) > targetPrice)
            .limit(3)
            .collect(Collectors.toList());

    return topCustomers;
}

    public static void main(String[] args) {
        Supplier supplier1 = new Supplier("Lenovo");
        ProductCatalog productCatalog = supplier1.getProductCatalog();

        // Populate products
        Product products1p1 = productCatalog.newProduct("printer 3  1", 2000, 16500, 10000);
        Product products1p2 = productCatalog.newProduct("printer 4", 10000, 25000, 16500);
        Product products1p3 = productCatalog.newProduct("Printer 2", 22000, 40000, 36500);
        Product products1p4 = productCatalog.newProduct("Photocopier 2", 30000, 70000, 50000);
        Product products1p5 = productCatalog.newProduct("Scanner  5", 19000, 36500, 25000);
        Product products1p6 = productCatalog.newProduct("photocopierr 6", 90000, 125000, 105000);
        Product products1p7 = productCatalog.newProduct("Printer 3", 22000, 60000, 36500);
        Product products2p1 = productCatalog.newProduct("Scanner 13  1", 12000, 26000, 18500);
        Product products2p2 = productCatalog.newProduct("color printer 14", 90000, 165000, 125000);
        Product products2p3 = productCatalog.newProduct("Color Printer 112", 422000, 540000, 495000);
        Product products2p4 = productCatalog.newProduct("Photocopier 922 ", 430000, 890000, 550000);
        Product products2p5 = productCatalog.newProduct("Low toner Scanner  102", 195000, 500100, 365102);
        Product products2p6 = productCatalog.newProduct("Speedy color Scanner 611", 900000, 125000, 1650000);
        Product products2p7 = productCatalog.newProduct("Premier Printer 300", 322000, 470000, 736500);
        Product products2p8 = productCatalog.newProduct("Color Photocopier 500", 350000, 580000, 780000);

        List<Product> solutionProducts = Arrays.asList(products1p1, products1p2, products1p3,
                products1p4, products1p5, products1p6, products1p7, products2p1, products2p2, products2p3, products2p4,
                products2p5, products2p6, products2p7, products2p8);

        Solution solution = new Solution("Xerox Solution", new Market("Your Market"), solutionProducts);

        Customer customer1 = new Customer("Customer1");
        Customer customer2 = new Customer("Customer2");
        Customer customer3 = new Customer("Customer3");

        SolutionOrder solutionOrder1 = new SolutionOrder(solution, customer1);
        SolutionOrder solutionOrder2 = new SolutionOrder(solution, customer2);
        SolutionOrder solutionOrder3 = new SolutionOrder(solution, customer3);

        System.out.println("Solution: " + solutionOrder1.getSolution().getName() +
                ", Revenue: " + solutionOrder1.getRevenue());

        List<SolutionOrder> top3Solutions = getTopNegotiatedSolutions(Arrays.asList(solutionOrder1, solutionOrder2, solutionOrder3));
        System.out.println("\nTop 3 Best-Negotiated Solutions:");
        for (SolutionOrder topSolution : top3Solutions) {
            System.out.println("Solution: " + topSolution.getSolution().getName() +
                    ", Revenue: " + topSolution.getRevenue());
        }

        double targetPrice = 5000000; // Set your target price
        List<Customer> topCustomers = getTopCustomers(Arrays.asList(solutionOrder1, solutionOrder2, solutionOrder3), targetPrice);
        System.out.println("\nTop 3 Customers Who Buy Above Target Price:");
        for (Customer topCustomer : topCustomers) {
            System.out.println("Customer: " + topCustomer.getName());
        }
    }
}

class Market {
    private String name;

    public Market(String your_Market) {
        this.name = your_Market;
    }
}

class SolutionOrder {
  private Solution solution;
  private Customer customer;
  private double revenue;

  public SolutionOrder(Solution solution, Customer customer) {
    this.solution = solution;
    this.customer = customer;
    this.revenue = calculateTotalRevenue();
  }

  public SolutionOrder(Solution solution, Customer customer, Double revenue) {
    this.solution = solution;
    this.customer = customer;
    this.revenue = revenue;
  }

  public Solution getSolution() {
    return solution;
  }

  public Customer getCustomer() {
    return customer;
  }

  public double getRevenue() {
    return revenue;
  }

  double calculateTotalRevenue() {
    List<Product> products = solution.getProducts();
    double totalRevenue = 0.0;

    for (Product product : products) {
      totalRevenue += getPriceForProduct(product);
    }

    return totalRevenue;
  }

  private double getPriceForProduct(Product product) {
    return product.getPrice();
  }
    
    @Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    SolutionOrder that = (SolutionOrder) obj;

    if (Double.compare(that.revenue, revenue) != 0) return false;
    if (!Objects.equals(solution, that.solution)) return false;
    return Objects.equals(customer, that.customer);
}

@Override
public int hashCode() {
    int result = Objects.hash(solution, customer, revenue);
    return result;
}
}


class Solution {
    private final String name;
    private final Market market;
    private final List<Product> products;

    public Solution(String name, Market market, List<Product> products) {
        this.name = name;
        this.market = market;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public Market getMarket() {
        return market;
    }

    public List<Product> getProducts() {
        return products;
    }
}

class Product {
    private final String name;
    private final double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Supplier {
    private String name;
    private ProductCatalog productCatalog;

    public Supplier(String name) {
        this.name = name;
        this.productCatalog = new ProductCatalog();
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }
}

class ProductCatalog {
    private List<Product> products;

    public ProductCatalog() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product getProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public Product newProduct(String name, double price1, double price2, double price3) {
    double minPrice = Math.min(Math.min(price1, price2), price3);
    return new Product(name, minPrice);
}
}

class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
