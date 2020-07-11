package order.umbrella_rent;

import org.springframework.stereotype.Repository;

@Repository
public class RentStrategyDao {

    void save(RentStrategyEntity entity) {

    }

    void update(RentStrategyEntity entity) {

    }

    void delete(Long umbrellaTemplateId) {

    }

    boolean isOtherRackAddUmbrella(Long rackId, Long umbrellaTemplateId) {
        return true;
    }
}
