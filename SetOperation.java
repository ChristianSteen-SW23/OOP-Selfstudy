public enum SetOperation {
    add, rem, mem;

    private int value;

    public void setValue(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
    
    @Override
    public String toString(){
        return this.name() + " " + this.value;
    }
}
