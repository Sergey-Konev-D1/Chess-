public class Queen extends ChessPiece {

    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    public boolean checkPos (int pos){
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

        ChessPiece piece = chessBoard.board[toColumn][toLine];

        if (piece != null && this.getColor().equals(getColor()))
            return false;
        if (piece != null && !this.getColor().equals(piece.getColor()))
            return true;

        int deltaLine;
        int deltaColumn;

        deltaLine = Math.abs(toLine - line); // проверка по модулю (чтобы не проверять 4 условия)
        deltaColumn = Math.abs(toColumn - column);

        if (deltaLine == 0 && deltaColumn != 0)
            return true;
        if (deltaLine != 0 && deltaColumn == 0)
            return true;
        if (deltaLine == deltaColumn)
            return true;

        return false;
    }

    public boolean isFreeFieldForMovement(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) { // проверяю что на пути следования фигуры никого нет

        int deltaLine;
        int deltaColumn;
        int deltaX=0;
        int deltaY=0;

        deltaLine = toLine - line;
        deltaColumn = toColumn - column;

        int N = Math.max(Math.abs(deltaLine),Math.abs(deltaColumn)); // определяю максимальное количество клеток перемещения фигы в ходе

        if (deltaLine > 0){
            deltaY = +1;
        }
        if (deltaLine < 0) {
            deltaY = -1;
        }
        if (deltaColumn > 0){
            deltaX = +1;
        }
        if (deltaColumn < 0) {
            deltaX = -1;
        }

        for (int i = 1 ; i < N ; i++) {

            int X; // текущее значение фигуры по Х при перемещении
            int Y; // текущее значение фигуры по Y при перемещении

            Y = line + deltaY*i; // текущая координата, в зависимости от номера цикла
            X = column + deltaX*i;

            ChessPiece piece = chessBoard.board[X][Y]; // у доски узнаю есть ли фигуры на доске с данными координатами
            if (piece != null) //если есть фигура
                return false;
        }

        return true;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
