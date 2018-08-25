package com.company;

public class Point3D extends Point {

	private int z;

	public Point3D(int x, int y, int z){
		super(x,y);
		this.z = z;

	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(obj == this)
			return true;
		if(obj instanceof Point3D){
			Point3D other = (Point3D)obj;
			return super.equals(obj) && this.z == other.z;
		}
		return false;
	}

	@Override
	protected String commaSeparatedComponents() {
		return super.commaSeparatedComponents()+","+z;
	}
}
