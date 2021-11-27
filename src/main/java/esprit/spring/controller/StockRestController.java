package esprit.spring.controller;

import esprit.spring.entities.Stock;
import esprit.spring.service.StockServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
@Api(tags = "Stock managment")
public class StockRestController {

    @Autowired
    StockServiceImpl stockService;

    // http://localhost:8089/SpringMVC/stock/retrieve-all-stock
    @GetMapping("/retrieve-all-stock")
    @ResponseBody
    @ApiOperation(value = "Récupérer la liste des stock")
    public List<Stock> getStock() {
        List<Stock> listStock = stockService.retrieveAllStocks();
        return listStock;
    }

    // http://localhost:8089/SpringMVC/stock/add-stock
    @PostMapping("/add-stock")
    @ResponseBody
    @ApiOperation(value = "permet d'ajouter un stock")
    public Stock addStock(@RequestBody Stock c) {
        Stock stock = stockService.addStock(c);
        return stock;
    }

    // http://localhost:8089/SpringMVC/stock/retrieve-stock/3
    @GetMapping("/retrieve-stock/{stock-id}")
    @ResponseBody
    @ApiOperation(value = "Permet de récuperer un stock avec son id")
    public Stock retrieveStock(@PathVariable("stock-id") Long stockId) {
        return stockService.retrieveStock(stockId);
    }
}
