package connect_four;

import java.util.Arrays;

public class Grid {
private byte COLUMN=7;
private byte ROW=6;

public byte getCOLUMN() {
	return COLUMN;
}

public byte getROW() {
	return ROW;
}


private Square sqr[][]=new Square[COLUMN][ROW];
public Grid() {
	for(byte i=0;i<ROW;i++) {
		for(byte j=0;j<COLUMN;j++) {
			sqr[j][i]=new Square(j,i);
		}
	}
}

public Square getSquare(byte col,byte row) {
	try{
		return sqr[col][row];
	}
	catch(ArrayIndexOutOfBoundsException e) {
		return null;
	}
}


public void displayGrid() {
	for(byte i=ROW;i>0;i--) {
		System.out.print(" |  ");
		for(byte j=0;j<COLUMN;j++) {
			System.out.print(sqr[j][i-1]+"  |  ");
		}
		System.out.println();
	}               System.out.println();    
	System.out.println("----1-----2-----3-----4-----5-----6-----7----\n");
}
}

