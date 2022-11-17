package connect_four;

public abstract class Player {
protected String name;
protected Set S;
protected Grid G;

Player (String n,Set s,Grid g){
	this.name=n;
	this.S=s;
	this.G=g;
}

public Set getSet() {
	return S;
}
public String getName() {
	return name;
}

public void dropAt(byte j) throws Exception {
	if(j==-1)
		return;
	if(j<0||j>=G.getCOLUMN()) 
		throw new Exception("Out of bound column");
	if(G.getSquare(j, (byte) (G.getROW()-1)).isOccupied())
		throw new Exception("The column is full");
	Token T;
	if(S.getNbToken()>0)
		{
		T=S.getToken();
		}
	
	else
		throw new Exception("You have insuffisant Token");
	byte i=0;
	while(G.getSquare(j, i).isOccupied()) {
		i++;
	}
	G.getSquare(j, i).setToken(T);
	
}
public boolean checkWin() {
	int count=0;
	for(byte i=0;i<G.getROW();i++) {
		for(byte j=0;j<G.getCOLUMN();j++) {
			if(G.getSquare(j, i).getToken()!=null && G.getSquare(j, i).getToken().getColor()==S.getColor())
				count++;
			else
				count=0;
			if(count==4) {
				//horiz
				return true;
			}
				
		}
		count=0;
	}
	for(byte i=0;i<G.getCOLUMN();i++) {
		for(byte j=0;j<G.getROW();j++) {
			if(G.getSquare(i, j).getToken()!=null && G.getSquare(i, j).getToken().getColor()==S.getColor())
				count++;
			else
				count=0;
			if(count==4) {
				//vert
				return true;
			}
				
		}
		count=0;
	}
	byte j=2;
	byte i=0;
	while(j>=0) {
		byte temp=j;
		while(j<G.getROW()) {
			if(G.getSquare(i, j).getToken()!=null && G.getSquare(i, j).getToken().getColor()==S.getColor())
				count++;
			else
				count=0;
			if(count==4) {
				//top left triangle
				return true;
			}
				
			i++;
			j++;
		}
		count=0;
		i=0;
		j=(byte) (temp-1);
	}
	j=0;
	i=1;
	while(i<4) {
		byte temp=i;
		while(i<G.getCOLUMN()) {
			if(G.getSquare(i, j).getToken()!=null && G.getSquare(i, j).getToken().getColor()==S.getColor())
				count++;
			else
				count=0;
			if(count==4) {
				//bottum right triangle
				return true;
			}
				
			i++;
			j++;
		}
		count=0;
		i=(byte) (temp+1);
		j=0;
	
	}
	
	j=2;
	i=(byte) (G.getCOLUMN()-1);
	while(j>=0) {
		byte temp=j;
		while(j<G.getROW()) {
			if(G.getSquare(i, j).getToken()!=null && G.getSquare(i, j).getToken().getColor()==S.getColor())
				count++;
			else
				count=0;
			if(count==4)
				{
				//top rigth triangle
				return true;
				}
			i--;
			j++;
		}
		count=0;
		i=(byte) (G.getCOLUMN()-1);
		j=(byte) (temp-1);
	}
	
	j=0;
	i=(byte) (G.getCOLUMN()-2);
	while(i>2) {
		byte temp=i;
		while(i>=0) {
			if(G.getSquare(i, j).getToken()!=null && G.getSquare(i, j).getToken().getColor()==S.getColor())
				{
				//Buttom left
				count++;
				
				}
			else
				count=0;
			if(count==4)
				{
				//bottum left triangle
				return true;
				}
			i--;
			j++;
		}
		count=0;
		i=(byte) (temp-1);
		j=0;
	
	}
	return false;
	
}
}
