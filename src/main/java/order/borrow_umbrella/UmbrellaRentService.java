package order.borrow_umbrella;

public interface UmbrellaRentService {


    boolean borrow(BorrowUmbrellaForm form);

    UmbrellaRentInfoVO showRentInfo(Long roleId, Long rackId);

}
