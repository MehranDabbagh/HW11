package C;

import C.Entity.Customer;
import C.Entity.Order;
import C.Entity.Product;
import C.Enum.Category;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Customer customer = new Customer("mehran");
        List<Product> products = new ArrayList<>();
        products.add(new Product("BIBLE", Category.BOOK, 150));
        products.add(new Product("TV", Category.ELECTRONIC, 500));
        products.add(new Product("TELEPHONE", Category.ELECTRONIC, 200));
        products.add(new Product("SPEAKER", Category.ELECTRONIC, 120));
        List<Order> orders=new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        try {
            String dateInString = "10-Jan-2016";
            Date date = formatter.parse(dateInString);
            orders.add(new Order(date,customer,products));
             dateInString = "10-Jan-2021";
             formatter = new SimpleDateFormat("dd-MMM-yyyy");
             date = formatter.parse(dateInString);
            orders.add(new Order(date,customer,products));
            dateInString = "10-Apr-2022";
            formatter = new SimpleDateFormat("dd-MMM-yyyy");
            date = formatter.parse(dateInString);
            orders.add(new Order(date,customer,products));
        }catch (ParseException e){

        }
        //*1*//
       products
                .stream()
                .filter(x -> x.getCategory()==Category.ELECTRONIC)
                .collect(Collectors.toList())
                .forEach(x-> System.out.println(x.getName()));

       //*2*//
     Date date2=new Date();
     Date date1=new Date();
        try {
            date2=formatter.parse("10-Jan-2016");
            date1=formatter.parse("10-Jan-2022");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalDate1 = date1;
        Date finalDate2 = date2;
        orders
                    .stream()
                    .filter(order -> order.getDate().compareTo(finalDate2)>0 && order.getDate().compareTo(finalDate1)<0 )
                    .collect(Collectors.toList())
                    .forEach(x-> System.out.println(x.getProducts()));
      //*3*//
        System.out.println(products.stream()
                .filter(x -> x.getCategory() == Category.ELECTRONIC)
                .min(new Comparator<Product>() {
                 @Override
                  public int compare(Product o1, Product o2) {
                  return o1.getPrice().compareTo(o2.getPrice());
                   }
                  })
                .get());
     //*4*//
        System.out.println(orders
                .stream()
                .filter(order -> order.getDate().compareTo(finalDate2) == 0)
                .mapToDouble(Order::getTotalPrice).average().getAsDouble());
    }
}
