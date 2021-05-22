public class Pawn extends ChessPiece {

    public Pawn (String color) {
        super(color);
    }

    public boolean checkPos(int pos) {
        if (pos >= 0 && pos <= 7) return true;
        else return false;
    }

    public boolean moveBefore() {
        return false;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (checkPos(toLine) == false)
            return false;
        if (checkPos(toColumn) == false)
            return false;

        ChessPiece piece = chessBoard.board[toLine][toColumn];// запросил у доски кто стоит на данном месте

        if (piece != null && this.getColor().equals(piece.getColor()))
            return false;
        if (piece != null && !this.getColor().equals(piece.getColor()))
            return true;

        if (column != toColumn ) // алга!!!!
            return false;

        if (this.equals("white")) {
            if (toLine == line + 1 )
                    return true;
            if (line == 1 && toLine == 3)
                return true;
        }

        if (this.equals("black")) {
            if (toLine == line - 1 )
                return true;
            if (line == 6 && toLine == 4)
                return true;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }

}



