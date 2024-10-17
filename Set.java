import java.util.TreeSet;

public class Set{
    private TreeSet<Integer> treeSet = new TreeSet<Integer>();
    
    public void runOperation(SetOperation op){
        switch (op.name()) {
            case "add":
                treeSet.add(op.getValue());
                break;
            case "rem":
                treeSet.remove(op.getValue());
                break;
            case "mem":
                treeSet.contains(op.getValue());
                break;
            default:
                System.out.println("did not work");
                break;
        }
    }

    @Override
    public String toString(){
        return treeSet.toString();
    }


    
}
