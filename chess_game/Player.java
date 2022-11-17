package chess_game;
import java.util.Scanner;
public class Player {
protected Color c;
protected Set s;
protected String name;

public Player(Color c,String n) {
	this.c=c;
	s=new Set(c);
	name=n;
}

public Color getC() {
	return c;
}

public Set getS() {
	return s;
}

public String getName() {
	return name;
}
public void promote(Piece p) {
	if(p.getColor()==c) {
		System.out.println("Enter your desire conversion q:queen, r:rook, b:bishop, k:knight");
		Scanner in=new Scanner(System.in);
		String user=in.next();
		if(user.equals("q"))
			p=new Queen(c);
		else if(user.equals("r"))
			p=new Rook(c);
		else if(user.equals("b")) 
			p=new Bishop(c);
		else if(user.equals("k")) 
			p=new Knight(c);
		
	}
}

public void move(Square s1,Square s2) {
	if(s1.getPiece().getColor().equals(c)) {
		if(s1.getPiece().validMove(s1, s2)) {
			if(!(s2.getPiece().getColor().equals(c))){
				s2.getPiece().deactive();
				s2.setPiece(s1.getPiece());
				s1.setPiece(null);
			}
			else {
				s2.setPiece(s1.getPiece());
				s1.setPiece(null);
				}
			if(s2.getPiece() instanceof Pawn) {
				if(s2.getPiece().getColor().equals(Color.WHITE) && s2.getVert()==8)
					promote(s2.getPiece());
				else if(s2.getPiece().getColor().equals(Color.BLACK) && s2.getVert()==1)
					promote(s2.getPiece());
			}
				
		}
	}
	
}

public boolean checkmate() {
	
}

public boolean stalemate() {
	
}
}
