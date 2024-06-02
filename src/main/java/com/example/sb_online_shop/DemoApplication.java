package com.example.sb_online_shop;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.sb_online_shop.domain.Customer;
import com.example.sb_online_shop.domain.Order;
import com.example.sb_online_shop.domain.Product;
import com.example.sb_online_shop.domain.Item;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
    private final CustomerRepository crepository;
    private final OrderRepository orepository;
    private final ProductRepository prepository;
    private final ItemRepository irepository;

    public DemoApplication(CustomerRepository cRepository, OrderRepository oRepository, ProductRepository pRepository, ItemRepository iRepository) {
        this.crepository = cRepository;
        this.orepository = oRepository;
        this.prepository = pRepository;
        this.irepository = iRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        logger.info("Boutique en ligne démarrée à http://localhost:8080/");
    }

    @Override
    public void run(String... args) throws Exception {
        Customer c1 = new Customer("Bugs Bunny", "New York", 59000);
        Customer c2 = new Customer("Daffy Duck", "Los Angeles", 37000);
        Customer c3 = new Customer("Porky Pig", "Miami", 28000);
        crepository.saveAll(Arrays.asList(c1, c2, c3));

        Order o1 = new Order(100, c1);
        Order o2 = new Order(300, c1);
        Order o3 = new Order(200, c2);
        Order o4 = new Order(140, c3);
        orepository.saveAll(Arrays.asList(o1, o2, o3, o4));

        Product p1 = new Product("Produit 1", "Description du produit 1", "image1.png", 50);
        Product p2 = new Product("Produit 2", "Description du produit 2", "image2.png", 30);
        Product p3 = new Product("Produit 3", "Description du produit 3", "image3.png", 20);
        prepository.saveAll(Arrays.asList(p1, p2, p3));

        Item i1 = new Item(2, 100, o1, p1);
        Item i2 = new Item(1, 30, o2, p2);
        Item i3 = new Item(4, 80, o3, p3);
        irepository.saveAll(Arrays.asList(i1, i2, i3));

        int i_order = 0;
        System.out.println("----- Toutes les commandes ------");

        for (Order o : orepository.findAll()) {
            i_order++;
            System.out.print("commande_" + i_order + " \t " + o.getCustomer().getFullname() + "\t " + o.getTotal() + "$");
            System.out.println(" ");
        }
        System.out.println("-----             ------");
    }
}
