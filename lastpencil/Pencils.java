package lastpencil;

public class Pencils {

    private int numPencils;

    public Pencils(int numPencils) {
        if (numPencils < 1) {
            throw new IllegalArgumentException("The number of pencils should be positive");
        }
        this.numPencils = numPencils;
    }

    public String drawPencils() {

        return "|".repeat(Math.max(0, numPencils));
    }

    public void takePencils(int numPencils) {
        this.numPencils -= numPencils;
    }

    public int getNumPencils() {
        return numPencils;
    }
}
