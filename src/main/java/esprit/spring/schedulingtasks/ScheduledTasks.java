package esprit.spring.schedulingtasks;


import esprit.spring.entities.Stock;
import esprit.spring.service.FactureService;
import esprit.spring.service.StockService;
import esprit.spring.service.StockServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;


@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Autowired
    private StockService sr;
    @Autowired
    private FactureService fs ;

    SimpleDateFormat formater = new SimpleDateFormat("YYYY-MM-dd");


    @Scheduled(fixedRate = 60000)
    public void check() {
        for(Stock s : sr.warnStock()) {
        log.info("STOCK EN DANGER DETECTE "+s.getLibelleStock(), dateFormat.format(new Date())); }
    }


    //@Scheduled(fixedRate = 60000)
    @Scheduled(cron = "0 0 0 1 1 *")
    public void chiffreAffaire(){
        //Ne marche pas ( avec parse , mySQL ne lis pas les dates ,0 resultats )
        String debutAnne = /*Year.now().getValue()+*/"2021-01-01" ;
        String finAnne = /*Year.now().getValue()+*/"2021-12-31" ;

        //Marche ( mySQL lis les dates )
        Date d = new Date("2021/01/0");
        Date b = new Date("2021/12/31");

            log.info("CHIFFRE D AFFAIRES :"+fs.calculChiffreAffaires(d ,b ) );
            log.info(debutAnne+" "+finAnne);

    }

}
