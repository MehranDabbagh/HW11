package C;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Customer customer = new Customer("mehran");
        List<Product> products = new ArrayList<>();
        products.add(new Product("BIBLE", Category.BOOK, 150));
        products.add(new Product("TV", Category.ELECTRONIC, 500));
        products.add(new Product("TELEPHONE", Category.ELECTRONIC, 200));
        products.add(new Product("SPEAKER", Category.ELECTRONIC, 120));
        //*1*//
       products
                .stream()
                .filter(x -> x.getCategory()==Category.ELECTRONIC)
                .collect(Collectors.toList())
                .forEach(x-> System.out.println(x.getName()));


    }
}
