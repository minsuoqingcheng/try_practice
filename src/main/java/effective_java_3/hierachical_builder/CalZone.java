package effective_java_3.hierachical_builder;

public class CalZone extends Pizza {

    private final boolean sauceInside;


    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false;

        public Builder sauceInside() {
            this.sauceInside = true;
            return this;
        }


        @Override
        protected CalZone build() {
            return new CalZone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }


    private CalZone(Builder builder) {
        super(builder);
        this.sauceInside = builder.sauceInside;
    }

    @Override
    public String toString() {
        return "CalZone{" +
                "sauceInside=" + sauceInside +
                ", toppings=" + toppings +
                '}';
    }
}
