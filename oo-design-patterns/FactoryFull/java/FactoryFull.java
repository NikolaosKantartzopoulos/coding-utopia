import pizza.Pizza;
import pizza.tratoria.FungiTratoria;
import pizza.tratoria.MargaritaTratoria;

public class FactoryFull {
    public static void main(String[] args) {
        MargaritaTratoria margaritaTratoria = new MargaritaTratoria();
        Pizza margaritaPizza = margaritaTratoria.preparePizza();
        margaritaPizza.eat();

        FungiTratoria fungiTratoria = new FungiTratoria();
        Pizza fungiPizza = fungiTratoria.preparePizza();
        fungiPizza.eat();
    }
}
