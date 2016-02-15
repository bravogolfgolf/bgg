package pkg.monopoly;

public class Player {
    private Token token;
    private int numberOfTurns;

    public Player(Token token) {
        this.token = token;
        this.numberOfTurns = 0;
    }

    public String getTokenDescription() {
        return token.getDescription();
    }

    public int getTokenLocation() {
        return token.getLocation();
    }

    public void setTokenLocation(int location) {
        this.token.setLocation(location);
    }

    public int roll() {
        int numberRolled = Game.die.rollTwoDie();
        determineHowToMoveTokenForwardBy(numberRolled);
        return numberRolled;
    }

    private void determineHowToMoveTokenForwardBy(int numberRolled) {
        if (tokenIsCausedToCircledBoardBy(numberRolled))
            moveTokenForwardByWrappingWith(numberRolled);
        else moveTokenForwardBy(numberRolled);
    }

    private boolean tokenIsCausedToCircledBoardBy(int numberRolled) {
        return this.token.getLocation() + numberRolled > Board.LAST_LOCATION_ON_BOARD;
    }

    private void moveTokenForwardByWrappingWith(int numberRolled) {
        this.token.setLocation(this.token.getLocation() + numberRolled - Board.SIZE_ON_BOARD);
    }

    private void moveTokenForwardBy(int numberRolled) {
        this.token.setLocation(this.token.getLocation() + numberRolled);
    }

    public void incrementTurn() {
        numberOfTurns++;
    }

    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return token != null ? token.equals(player.token) : player.token == null;

    }

    @Override
    public int hashCode() {
        return token != null ? token.hashCode() : 0;
    }
}