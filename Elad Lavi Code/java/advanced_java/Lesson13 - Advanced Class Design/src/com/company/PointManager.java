package com.company;

public class PointManager {
	public static Point getQPoint(Point point, int a){



		/*
		class QPoint extends Point{
			int a;
			public QPoint(int x, int y, int a){
				super(x,y);
				this.a = a;
			}

			public int Quarter(){
				if(getX()>=0){
					if(getY()>=0)
						return 1;
					else
						return 4;
				}else{
					if(getY() >= 0)
						return 2;
					else
						return 3;
				}
			}

			@Override
			public String toString() {
				return super.toString() + Quarter();
			}
		}

		QPoint qPoint = new QPoint(point.getX(), point.getY(), a);
		qPoint.Quarter();
		*/
		return new Point(point.getX(), point.getY()){


			public int Quarter(){
				if(getX()>=0){
					if(getY()>=0)
						return 1;
					else
						return 4;
				}else{
					if(getY() >= 0)
						return 2;
					else
						return 3;
				}
			}

			@Override
			public String toString() {
				return super.toString() + Quarter()+ " ";
			}
		};
	}
}
