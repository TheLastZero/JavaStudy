package paper;

public class lesson8 {
	public static void main(String[] args) {
		int[] score={98,97,67,89,89,86};
		int i;
		int j;
		int temp;
		for(j=6;j<=score.length;j++){
		for(i=1;i<score.length-1;i++){
			if(score[i]<score[i-1]){
				temp=score[i];
				score[i]=score[i-1];
				score[i-1]=temp;
			}	
		}
		}
		for(int k=0;k<score.length-1;k++){
			System.out.println(score[k]);
		}
	}
}
