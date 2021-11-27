package esprit.spring.service;

import esprit.spring.entities.Stock;

import java.util.List;

public interface StockService {

    List<Stock> retrieveAllStocks();

    Stock addStock(Stock s);

    Stock updateStock(Stock u);

    Stock retrieveStock(Long id);

     void deleteStock(Long id);

    boolean checkExists(Long id);

    public List<Stock> warnStock();


}
