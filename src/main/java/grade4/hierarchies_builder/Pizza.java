package grade4.hierarchies_builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {

    public enum Topping {
        HAM, MUSHROOM, ONION, PEPPER, SAUSAGE
    }

    final Set<Topping> toppings;

    /**
     * <T extends Builder<T>> 的语义
     * 1、如果子类要自定义泛型，那么子类中声明的泛型必须要继承Builder并且这个泛型声明的泛型要继承自T
     *      例如TestBuilder
     * 2、如果子类不自定义泛型，则默认的泛型为它继承的父类
     *
     * @param <T>
     */
    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        protected abstract T self();    //抽象类处定义的语法要求子类必须实现这个类

        abstract Pizza build();

    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }


    class TestBuilder extends Pizza.Builder<TestBuilder> {

        @Override
        protected TestBuilder self() {
            return null;
        }

        @Override
        Pizza build() {
            return null;
        }
    }
}
