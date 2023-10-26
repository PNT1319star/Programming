package Pokemons;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import moves.*;
public class Grimer  extends  Pokemon{
    public Grimer(String name, int lvl){
        super(name,lvl);
        this.setStats(80,80,50,40,50,25);
        this.setType(Type.POISON);
        this.setMove(new Confide(), new MudSlap(), new Minimize());
    }
}
