package order.umbrella_rent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class RentStrategyService {

    @Autowired
    private UmbrellaShelvesDao umbrellaShelvesDao;
    @Autowired
    private RentStrategyDao rentStrategyDao;
    @Autowired
    private RentStrategyCache rentStrategyCache;

    private BigDecimal defaultDeposit;
    private BigDecimal defaultBuyPrice;
    private BigDecimal defaultRentPrice;
    private int defaultRentUnit;

    boolean existUmbrellaRentStrategy(Long umbrellaInstanceId) {

        return true;
    }

    @Transactional
    void createDefaultRentStrategy(Long roleId, Long rackId) {
        RentStrategyEntity entity = new RentStrategyEntity(rackId, roleId, defaultDeposit, defaultBuyPrice, defaultRentPrice, defaultRentUnit);
        rentStrategyDao.save(entity);
        rentStrategyCache.setRentStrategy(entity);
    }


    @Transactional
    void updateRentStrategy(UpdateRentStrategyForm form) {
        RentStrategyEntity entity = new RentStrategyEntity(form);
        rentStrategyDao.update(entity);
        rentStrategyCache.setRentStrategy(entity);
    }

    @Transactional
    void deleteRentStrategy(Long rackId) {
        rentStrategyDao.delete(rackId);
        rentStrategyCache.deleteRentStrategy(rackId);
    }

}
