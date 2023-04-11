package studio.thinkground.testproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import studio.thinkground.testproject.data.dto.ProductDto;
import studio.thinkground.testproject.service.ProductService;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    //http://localhost:8080/api/v1/product-api/product/{productId}
    @GetMapping("/product/{productId}")
    public ProductDto getProduct(@PathVariable String productId){
        return productService.getProduct(productId);
    }

    //http://localhost:8080/api/v1/product-api/product
    @PostMapping("/product")
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        return productService.saveProduct(productId, productName, productPrice, productStock);
    }

    //http://localhost:8080/api/v1/product-api/product/{productId}
    @DeleteMapping("/product/{productId}")
    public ProductDto deleteProduct(@PathVariable String productId){
        return null;
    }

}
