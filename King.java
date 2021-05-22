public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    public boolean checkPos(int pos) {
        if (pos >= 0 && pos <= 7)
            return true;
        else return false;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (checkPos(toLine) == false)
            return false;
        if (checkPos(toColumn) == false)
            return false;

        ChessPiece piece = chessBoard.board[toLine][toColumn];

        if (piece != null && this.getColor().equals(getColor()))
            return false;
        if (piece != null && !this.getColor().equals(piece.getColor()))
            return true;

        int deltaLine;
        int deltaColumn;

        deltaLine = Math.abs(toLine - line); // проверка по модулю
        deltaColumn = Math.abs(toColumn - column); // проверка по модулю

        if (deltaColumn == 0 && deltaLine == 1)
            return true;
        if (deltaColumn == 1 && deltaLine == 0)
            return true;
        if (deltaColumn == 1 && deltaLine == 1)
            return true;

        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {

        if (checkPos(line) == false)
            return false;
        if (checkPos(column) == false)
            return false;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                ChessPiece piece = chessBoard.board[i][j];

                if (piece == null)
                    continue;
               // if (piece != null) если есть фигура
              if (!piece.getColor().equals(this.getColor()) &&
              piece.canMoveToPosition(chessBoard, i, j, line, column))
                  return true;
            }
        }
        return false;
    }
}










