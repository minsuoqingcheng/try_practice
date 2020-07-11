package mockito;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import order.ErrorCodeException;
import order.ResponseCode;
import order.borrow_umbrella.*;

import java.util.HashMap;


public class UmbrellaRentServiceTest {


    @Test
    public void testBorrowDeviceOffLine() {
        IOTServerWrapper iotServerWrapper = Mockito.mock(IOTServerWrapper.class);
        UmbrellaRentService umbrellaRentService = new UmbrellaRentServiceImpl();
        Mockito.when(iotServerWrapper.callDevice(new DeviceConfig(), OperationEnum.BORROW, null, null)).thenReturn("{\"flag\":false}");
        ErrorCodeException exception = null;
        try {
            umbrellaRentService.borrow(new BorrowUmbrellaForm(5L, 1001L, 30000L));
        } catch (ErrorCodeException e) {
            exception = e;
        }
        Assert.assertNotNull(exception);
        Assert.assertTrue(exception.getCode() == ResponseCode.DEVICE_OFF_LINE);
    }

    public void testBorrowSuccess() {
        IOTServerWrapper iotServerWrapper = Mockito.mock(IOTServerWrapper.class);
        OrderWrapper orderWrapper = new OrderWrapper();
        RecordService recordService = new RecordService();
        UmbrellaRentService umbrellaRentService = new UmbrellaRentServiceImpl();
        Mockito.when(iotServerWrapper.callDevice(new DeviceConfig(), OperationEnum.BORROW, null, null))
                .thenReturn("{\"flag\":true, \"data\": {\"operResult\":\"1\"}}");
        Mockito.doNothing().when(orderWrapper).confirmBorrow(30000L, new HashMap<>());
        Mockito.doNothing().when(recordService).save(new RecordDTO());
        boolean res = umbrellaRentService.borrow(new BorrowUmbrellaForm(5L, 1001L, 30000L));
        Assert.assertTrue(res);
    }


}
