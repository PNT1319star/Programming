package Pokemons;
import ru.ifmo.se.pokemon.Type;
import moves.*;
public class Muk extends Grimer {
    public Muk(String name, int lvl){
        super(name,lvl);
        this.setStats(105,105,75,65,100,50);
        this.setType(Type.POISON);
        this.setMove(new Confide(), new MudSlap(), new Minimize(), new VenomDrench());
    }
}
