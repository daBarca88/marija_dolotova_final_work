package lv.lu.finalwork.ui;

import lv.lu.finalwork.domain.ProductCategory;
import lv.lu.finalwork.model.ui.ProductInputData;
import lv.lu.finalwork.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.Scanner;

@Controller
public class ConsulUI {

    private final ProductService service;
    private final Scanner scanner;

    @Autowired
    public ConsulUI(ProductService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void startUi() {
        int userChoice;
        while (true) {
            printMenu();
            userChoice = scanner.nextInt();

            callServiceByChoice(userChoice);

            if (userChoice == 0) {
                break;
            }
        }
    }

    private void callServiceByChoice(int userChoice) {
        switch (userChoice) {
            case 1:
                initProductSave();
                break;
            case 2:
                retrieveProductList();
                break;
            case 3:
                retrieveProductById();
                break;
            case 4:
                deleteProductById();
                break;
        }
    }

    private void deleteProductById() {
        System.out.println("Enter product id..");
        service.delete(scanner.nextLong());
    }

    private void retrieveProductById() {
        System.out.println("Enter product id..");
        System.out.println(service.findById(scanner.nextLong()));
    }

    private void retrieveProductList() {
//        for(Product product : service.findAll()) {
//            System.out.println(product);
//        }
        service.findAll().stream()
                .forEach(System.out::println);
    }

    private void initProductSave() {
        ProductInputData product = new ProductInputData();

        System.out.println("Enter product name..");
        product.setName(scanner.next());

        System.out.println("Enter product price");
        product.setPrice(scanner.nextDouble());

        System.out.printf("Enter product category from (%s)",
                Arrays.asList(ProductCategory.values()));
        product.setCategory(scanner.next());
        System.out.println();

        service.save(product);
    }

    private void printMenu() {
        System.out.println(" === Product Accounting application === ");
        System.out.println(" Chose one option: \n");
        System.out.println(" Save product - 1");
        System.out.println(" List all products - 2");
        System.out.println(" Retrieve product with exact id - 3");
        System.out.println(" Delete product with exact id - 4");
        System.out.println(" Exit application - 0");
        System.out.println(" Please enter the choice");
    }
}
