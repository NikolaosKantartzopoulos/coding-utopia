package pizza.tratoria;

import pizza.FungiPizza;
import pizza.Pizza;

public class FungiTratoria implements Tratoria {
    @Override
    public Pizza preparePizza() {
        return new FungiPizza();
    }
}
