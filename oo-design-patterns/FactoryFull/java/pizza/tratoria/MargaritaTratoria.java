package pizza.tratoria;

import pizza.MargaritaPizza;
import pizza.Pizza;

public class MargaritaTratoria implements Tratoria {
    @Override
    public Pizza preparePizza() {
        return new MargaritaPizza();
    }
}
