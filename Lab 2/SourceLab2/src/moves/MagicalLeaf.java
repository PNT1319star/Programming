package moves;
import ru.ifmo.se.pokemon.*;
public class MagicalLeaf extends SpecialMove{
    public MagicalLeaf(){
        super(Type.GRASS,60,0);
    }
    @Override
    protected String describe(){
        return "Use Magical Leaf";
    }
}
