package esprit.spring.service;

import esprit.spring.entities.Stock;
import esprit.spring.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService{
    @Autowired
    StockRepository stockRepo;

    @Override
    public List<Stock> retrieveAllStocks() {
       return stockRepo.findAll();
    }

    @Override
    public Stock addStock(Stock s) {
        return stockRepo.save(s);
    }

    @Override
    public Stock updateStock(Stock u) {
        Stock stock = stockRepo.getById(u.getIdStock());
        stock.setLibelleStock(u.getLibelleStock());
        stock.setQte(u.getQte());
        stock.setQteMin(u.getQteMin());

        return stockRepo.save(stock);
    }

    @Override
    public Stock retrieveStock(Long id) {
        return stockRepo.getById(id);
    }

    @Override
    public void deleteStock(Long id) {
    stockRepo.deleteById(id);
    }

    @Override
    public boolean checkExists(Long id){
        return stockRepo.existsById(id);
    }

    @Override
    public List<Stock> warnStock(){
        return stockRepo.warnStock();
    }



}
