package lesson03;
/**
 * 教练和运动员案例
       乒乓球运动员和篮球运动员。
       乒乓球教练和篮球教练。
       为了出国交流，跟乒乓球相关的人员都需要学习英语。
       请用所学知识：
       分析，这个案例中有哪些抽象类，哪些接口，哪些具体类。
 * @author Administrator
 *
 */
public class Text {
	public static void main(String[] args) {
		pingpongCoach pc=new pingpongCoach();
		
		BasketballCoach bc=new BasketballCoach();
		
		pingpongAthlete pa=new pingpongAthlete();
		
		BasketballAthlete ba=new BasketballAthlete();
	}
}
