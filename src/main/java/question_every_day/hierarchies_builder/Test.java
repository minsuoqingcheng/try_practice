package question_every_day.hierarchies_builder;

public class Test {

    public static void main(String[] args) {

        NyPizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                                        .addTopping(Pizza.Topping.ONION)
                                        .build();

    }

}
