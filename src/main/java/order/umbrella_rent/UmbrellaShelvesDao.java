package order.umbrella_rent;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmbrellaShelvesDao {

    public void save(UmbrellaShelveEntity entity) {

    }

    public void updateShelve(List<UmbrellaShelveEntity> entities) {

    }

    public boolean isOtherRackAddUmbrella(Long rackId, Long umbrellaTemplateId) {
        return true;
    }

}
