package services.StockService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockServiceController {

    @RequestMapping("/stocks/{productNumber}")
    public int getNumberOfProductInStock(@PathVariable String productNumber){
        return 25;
    }



}
