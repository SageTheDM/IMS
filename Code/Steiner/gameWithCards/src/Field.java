public class Field {
    boolean isFieldOccupied;

    public Field() {
        this.isFieldOccupied = false;
    }

    public Field(boolean isFieldOccupied) {
        this.isFieldOccupied = isFieldOccupied;
    }

    public boolean isFieldOccupied() {
        return isFieldOccupied;
    }

    public void setFieldOccupied(boolean isFieldOccupied) {
        this.isFieldOccupied = isFieldOccupied;
    }
}
