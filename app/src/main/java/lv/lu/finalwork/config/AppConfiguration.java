package lv.lu.finalwork.config;

import lv.lu.finalwork.model.repository.Product;
import lv.lu.finalwork.repository.ProductRepository;
import lv.lu.finalwork.service.ProductMapper;
import lv.lu.finalwork.service.ProductService;
import lv.lu.finalwork.ui.ConsulUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Configuration
@ComponentScan("lv.lu.finalwork")
public class AppConfiguration {

//    @Bean("repo")
//    public Map<Long, Product> repository(){
//        return new HashMap<>();
//    }

//    @Bean
//    public ProductRepository productRepository() {
//        return new ProductRepository(repository());
//    }

//    @Bean
//    public ProductMapper productMapper() {
//        return new ProductMapper();
//    }

//    @Bean
//    public ProductService productService() {
//        return new ProductService(productRepository(), productMapper());
//    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

//    so izdzesam jo pievienojam @Component un @Autowired ConsulUi klasee
//    @Bean
//    public ConsulUI consulUI(){
//        return new ConsulUI();
//    }

}
