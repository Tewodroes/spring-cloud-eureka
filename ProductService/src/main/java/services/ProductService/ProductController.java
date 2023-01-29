package services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private StockFeignClient stockFeignClient;

    @RequestMapping("/products/{productNumber}")
    public Product getNumberOfProducts(@PathVariable String productNumber){
        int numberOfProduct = stockFeignClient.getNumberOfProductInStock(productNumber);
        return new Product("76393", "IPhone 14",numberOfProduct);
    }
    @FeignClient("StockService")
    interface StockFeignClient{
        @RequestMapping("stocks/{productNumber}")
        public int getNumberOfProductInStock(@PathVariable String productNumber);
    }
}
