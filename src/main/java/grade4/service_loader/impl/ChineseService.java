package grade4.service_loader.impl;

import grade4.service_loader.CountryService;

public class ChineseService implements CountryService {

    @Override
    public String getCountryName() {
        return "Chinese";
    }
}
