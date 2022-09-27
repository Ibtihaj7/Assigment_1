package edu.najah.cap.java;

public class OperationsInTheSystem {
    private int add;
    private int remove;
    private int retrieve;

    public OperationsInTheSystem(int add, int remove, int retrieve) {
        this.add = add;
        this.remove = remove;
        this.retrieve = retrieve;
    }

    public OperationsInTheSystem() { add = remove = retrieve =0; }
    public void setAdd(final int add) { this.add = add; }
    public void setRemove(final int remove) { this.remove = remove; }
    public void setRetrieve(final int retrieve) { this.retrieve = retrieve; }
    public int getAdd() { return add; }
    public int getRemove() { return remove; }
    public int getRetrieve() { return retrieve; }
}
