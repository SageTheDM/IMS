// Points class for managing point categories
public class Points {
    // #region Fields
    private int fiveMinuteBreak;
    private int longerBreak;
    private int bonusPoints;

    // #region Getters Setters
    public int getFiveMinuteBreak() {
        return fiveMinuteBreak;
    }

    public void setFiveMinuteBreak(int fiveMinuteBreak) {
        this.fiveMinuteBreak = fiveMinuteBreak;
    }

    public int getLongerBreak() {
        return longerBreak;
    }

    public void setLongerBreak(int longerBreak) {
        this.longerBreak = longerBreak;
    }

    public int getBonusPoints() {
        return bonusPoints;
    }

    public void setBonusPoints(int bonusPoints) {
        this.bonusPoints = bonusPoints;
    }

    // #region Calculation
    // Method to calculate total points
    public int getTotalPoints() {
        return fiveMinuteBreak + longerBreak + bonusPoints;
    }

}
