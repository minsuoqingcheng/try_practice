package number_format;

import java.text.NumberFormat;

public class NumberFormatFactory {

    public NumberFormat oneDecimal() {
        return this.decimal(1);
    }

    public NumberFormat twoDecimal() {
        return this.decimal(2);
    }

    private NumberFormat decimal(int aNumberOfDecimal) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMinimumFractionDigits(aNumberOfDecimal);
        numberFormat.setMaximumFractionDigits(aNumberOfDecimal);
        return numberFormat;
    }

}
