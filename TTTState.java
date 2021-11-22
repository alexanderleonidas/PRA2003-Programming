public interface TTTState {
    public char getValue(final int row, final int col);
    public char currentPlayer();
    public void clickCell(final int row, final int col); 
}
