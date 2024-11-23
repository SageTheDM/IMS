public class Points {
    // #region Fields
    private int fiveMinuteBreak;
    private int longerBreak;
    private int bonusPoints;

    // #region Constructor
    public Points() {
        this.fiveMinuteBreak = 0; // Default initialization
        this.longerBreak = 0; // Default initialization
        this.bonusPoints = 0; // Default initialization
    }

    public Points(int fiveMinuteBreak, int longerBreak, int bonusPoints) {
        this.fiveMinuteBreak = fiveMinuteBreak >= 0 ? fiveMinuteBreak : 0; // Validate
        this.longerBreak = longerBreak >= 0 ? longerBreak : 0; // Validate
        this.bonusPoints = bonusPoints >= 0 ? bonusPoints : 0; // Validate
    }

    // Copy constructor to duplicate an existing Points object
    public Points(Points points) {
        this.fiveMinuteBreak = points.fiveMinuteBreak;
        this.longerBreak = points.longerBreak;
        this.bonusPoints = points.bonusPoints;
    }

    // #region Getters and Setters
    public int getFiveMinuteBreak() {
        return fiveMinuteBreak;
    }

    public void setFiveMinuteBreak(int fiveMinuteBreak) {
        this.fiveMinuteBreak = Math.max(fiveMinuteBreak, 0); // Ensure no negative points
    }

    public int getLongerBreak() {
        return longerBreak;
    }

    public void setLongerBreak(int longerBreak) {
        this.longerBreak = Math.max(longerBreak, 0); // Ensure no negative points
    }

    public int getBonusPoints() {
        return bonusPoints;
    }

    public void setBonusPoints(int bonusPoints) {
        this.bonusPoints = Math.max(bonusPoints, 0); // Ensure no negative points
    }

    // #region Points Adjustment Methods
    public void addFiveMinuteBreakPoints(int points) {
        if (points > 0) {
            this.fiveMinuteBreak += points;
        }
    }

    public void addLongerBreakPoints(int points) {
        if (points > 0) {
            this.longerBreak += points;
        }
    }

    public void addBonusPoints(int points) {
        if (points > 0) {
            this.bonusPoints += points;
        }
    }

    // #region Total Points Calculation
    public int getTotalPoints() {
        return fiveMinuteBreak + longerBreak + bonusPoints;
    }

    // #region String Representation (Optional for debugging or output)
    @Override
    public String toString() {
        return String.format("Five Minute Break: %d, Longer Break: %d, Bonus Points: %d, Total: %d",
                fiveMinuteBreak, longerBreak, bonusPoints, getTotalPoints());
    }
}
