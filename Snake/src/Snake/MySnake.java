package Snake;

public class MySnake {
	//蛇是由多个方块构成的,每个方块都有自己的横纵坐标
	int x=0,y=0;
	static int sum=0;
	
	//这里表示蛇头的方向,0,1,2,3代表上，右，下，左
	int direction=1;
	
	MySnake(int x,int y){
		this.x=x;
		this.y=y;
		sum++;
	}
}