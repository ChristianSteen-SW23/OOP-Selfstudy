import java.util.LinkedList;
import java.util.StringTokenizer;

public class Block {
    public Block(int num) {
        this.setBlockNum(num);
    }

    private int blockNum;
    private LinkedList<String> instructionList = new LinkedList<String>();
    private LinkedList<SetOperation> translatedList = new LinkedList<SetOperation>();
    private Set set = new Set();

    public int getBlockNum() {
        return this.blockNum;
    }

    public void setBlockNum(int num) {
        this.blockNum = num;
    }

    public void addElement(String e) {
        this.instructionList.add(e);
    }

    public int listSize() {
        return this.instructionList.size();
    }

    public String listElementAtPostion(int index) {
        return this.instructionList.get(index);
    }

    public String getAndRemoveFirstElm() {
        return this.instructionList.removeFirst();
    }

    @Override
    public String toString() {
        String reString = "Block num: " + this.blockNum + "\n";

        int i = 0;
        while (this.instructionList.size() > 0) {
            reString += "Elm " + ++i + ": " + this.instructionList.remove() + "\n";

        }
        return reString;
    }

    public void translate() {
        String currentElm;
        while (this.instructionList.size() > 0) {
            currentElm = this.instructionList.remove();

            // Check om stringen ineholder ( eller throhw exepetion
            StringTokenizer st = new StringTokenizer(currentElm, "()");
            String operation = st.nextToken();
            String value = st.nextToken();
            try {
                // If the operation is valued
                SetOperation currentEnumElm = SetOperation.valueOf(operation);
                currentEnumElm.setValue(Integer.parseInt(value));
                translatedList.add(currentEnumElm);
                System.out.println(currentEnumElm.toString());
                set.runOperation(currentEnumElm);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("did not make enum");
            }
        }
    }
    public String getSetString(){
        return set.toString();
    } 
}
