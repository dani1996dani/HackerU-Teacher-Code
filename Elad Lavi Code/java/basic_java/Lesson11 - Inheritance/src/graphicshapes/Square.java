package graphicshapes;

public class Square extends Rectangle {

	public Square(int x, int y, int side){
		super(x,y,side,side);
	}


	@Override
	public void setWidth(int width) {
		setSide(width);
	}

	@Override
	public void setHeight(int height) {
		setSide(height);
	}

	public void setSide(int side){
		super.setWidth(side);
		super.setHeight(side);
	}

	public int getSide(){
		return getHeight();
	}

}
