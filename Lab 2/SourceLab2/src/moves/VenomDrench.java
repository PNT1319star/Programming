package moves;
import ru.ifmo.se.pokemon.*;
public class VenomDrench extends StatusMove{
    public VenomDrench(){
        super(Type.NORMAL,0,100);
    }
    @Override
    protected void applyOppEffects(Pokemon p){
        Status p_stat = p.getCondition();
        if(p_stat.equals(Status.POISON)){
            p.setMod(Stat.ATTACK,-1);
            p.setMod(Stat.SPECIAL_ATTACK,-1);
            p.setMod(Stat.SPEED,-1);
        }
    }
    @Override
    protected String describe(){
        return "Use Venom Drench";
    }
}
