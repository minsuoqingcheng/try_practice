package effective_java_3.hierachical_builder;

public class Test {

    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL).addTopping(Pizza.Topping.SAUSSAGE).build();
        CalZone calZone = new CalZone.Builder().sauceInside().addTopping(Pizza.Topping.HAM).build();
        System.out.println(pizza);
        System.out.println(calZone);
    }

}
