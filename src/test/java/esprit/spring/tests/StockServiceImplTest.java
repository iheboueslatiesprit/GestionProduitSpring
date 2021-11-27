package esprit.spring.tests;
import esprit.spring.entities.Stock;
import esprit.spring.service.StockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {
    @Autowired
    StockService stockService;

    @Test
    public void testAddStock() {
        Stock s = new Stock();
        s.setLibelleStock("stock test");
        s.setQte(10);
        s.setQteMin(100);
        Stock newStock = stockService.addStock(s);
        assertNotNull(newStock);
    }

    @Test
    public void testSuppStock(){
        Stock s = new Stock();
        s.setLibelleStock("stock test");
        s.setQte(10);
        s.setQteMin(100);
        Stock newStock = stockService.addStock(s);
        stockService.deleteStock(newStock.getIdStock());
        assertFalse(stockService.checkExists(newStock.getIdStock()));
    }

}
