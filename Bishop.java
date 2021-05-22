public class Bishop extends ChessPiece{

    public Bishop(String color) {
        super(color);
    }

    public boolean checkPos (int pos){
        if (pos >= 0 && pos <= 7)
            return true;
        else return false;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if(checkPos(toLine) == false ) // проверяю в пределах ли мы доски для линии
            return false;
        if(checkPos(toColumn) == false) // проверяю в пределах ли мы доски для колонки
            return false;

        ChessPiece piece = chessBoard.board[toLine][toColumn];

        if (piece != null && this.getColor().equals(piece.getColor()))
            return false;

        if (piece != null && !this.getColor().equals(piece.getColor()))
            return true;

        int deltaLine;
        int deltaColumn;

        deltaLine = Math.abs(toLine - line);
        deltaColumn = Math.abs(toColumn - column);

        if(deltaLine == deltaColumn ) // если при перемещении фигуры разница по модулю по х и у равны следовательно она ходит по диагонали
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

            int X; // текущее значение фигуры по Х
            int Y; // текущее значение фигуры по Y

            Y = line + deltaY*i;
            X = column + deltaX*i;

            ChessPiece piece = chessBoard.board[X][Y];
                if (piece != null) //если есть фигура
                    return false;
            }

        return true;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
