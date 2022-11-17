package chess_game;

abstract public class Piece {
protected Color c;
protected boolean active=true;

public Piece (Color c) {
	this.c=c;
}

abstract public boolean validMove(Square s1, Square s2);

public void deactive() {
	active=false;
}

public Color getColor(){
	return c;
}

}
