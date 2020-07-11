package order.borrow_umbrella;

import order.calculate.RentStrategyDTO;
import org.springframework.stereotype.Service;

@Service
public class UmbrellaShelveWrapper {

    public void updateUmbrellaShelveInfo(UpdateShelveForm form) {

    }

    public RackDetailDTO getRackDetailDTO(Long rackId) {
        return new RackDetailDTO();
    }

    public RentStrategyDTO getRentStrategyDTO(Long rackId) {
        return new RentStrategyDTO();
    }
}
