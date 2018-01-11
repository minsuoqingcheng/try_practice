package grade4.service_loader;

import java.util.ServiceLoader;

public class ServiceLoaderTest {

    public static void main(String[] args) {

        ServiceLoader<CountryService> loader = ServiceLoader.load(CountryService.class);
        for (CountryService service : loader) {
            System.out.println(service.getCountryName());
        }

    }

}
