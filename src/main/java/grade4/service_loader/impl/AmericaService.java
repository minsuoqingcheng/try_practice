package grade4.service_loader.impl;

import grade4.service_loader.CountryService;

public class AmericaService implements CountryService {

    @Override
    public String getCountryName() {
        return "America";
    }
}
