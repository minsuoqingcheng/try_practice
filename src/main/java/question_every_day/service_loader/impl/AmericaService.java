package question_every_day.service_loader.impl;

import question_every_day.service_loader.CountryService;

public class AmericaService implements CountryService {

    @Override
    public String getCountryName() {
        return "America";
    }
}
