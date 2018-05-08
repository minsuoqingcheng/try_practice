package question_every_day.service_loader.impl;

import question_every_day.service_loader.CountryService;

public class ChineseService implements CountryService {

    @Override
    public String getCountryName() {
        return "Chinese";
    }
}
