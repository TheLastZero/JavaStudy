package lesson02;
/**
 * 取出圆周率PI(自定义精确到小数点后几位)的以下数学运算类属性值：
 * 四舍五入值round，进位值ceil，退位值floor，绝对值abs，开平方根的值sqrt
 * @author 小钢炮-ST-PRO
 *
 */
public class lesson04 {
	public static void main(String[] args) {
		System.out.println(Math.PI);
		System.out.println(Math.ceil(9.35));//进位值ceil
		System.out.println(Math.floor(9.46));//退位值
		System.out.println(Math.abs(-964));//绝对值
		System.out.println(Math.sqrt(225));//开平方根的值
	}
}
