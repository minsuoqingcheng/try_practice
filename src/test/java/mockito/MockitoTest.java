package mockito;

import org.mockito.Mockito;
import order.ErrorCodeException;

import java.util.List;

public class MockitoTest {

    public void test() {
        List list = Mockito.mock(List.class);
        Mockito.when(list.size()).thenThrow(new ErrorCodeException(100));
    }

}
