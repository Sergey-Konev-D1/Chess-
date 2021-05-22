public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    public boolean checkPos(int pos) {
        if (pos >= 0 && pos <= 7) return true;
        else return false;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (checkPos(toLine) == false) // проверяю в пределах ли мы доски для линии
            return false;
        if (checkPos(toColumn) == false) // проверяю в пределах ли мы доски для колонки
            return false;

        ChessPiece piece = chessBoard.board[toLine][toColumn]; // запрашиваю у доски кто стоит на данном месте

        if (piece != null && this.getColor().equals(piece.getColor()))
            return false;
        if (piece != null && !this.getColor().equals(piece.getColor()))
            return true;

        int deltaLine;
        int deltaColumn;

        deltaLine = Math.abs(toLine - line); // проверка по модулю (чтобы не проверять 4 условия)
        deltaColumn = Math.abs(toColumn - column); // проверка по модулю (чтобы не проверять 4 условия)

        if (deltaLine == 2 && deltaColumn == 1)
            return true;
        if (deltaLine == 1 && deltaColumn == 2)
            return true;

        return false;
    }


    @Override
    public String getSymbol() {
        return "H";
    }


}
