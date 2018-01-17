package grade4.hierarchies_builder;

import java.util.Objects;

public class NyPizza extends Pizza {

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    public enum Size {
        SMALL, MEDIUM, LARGE
    }

    private final Size size;


    public static class Builder extends Pizza.Builder<Builder> {

        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }
    }


}
