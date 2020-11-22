package CCF202006;

import java.util.Scanner;

public class two {
	/**
	 * 	评测结果：
	 * 		开始60分因为存放结果的类型为int，不满足，使用long后，分数为100
	 * 	空间占用：
	 * 		开始时，使用两个数组存放向量值
	 * 		改进：只存放第一个数组，第二个向量通过两个局部变量存放即可，无需数组
	 * 	注意：
	 * 		在使用双指针进行比较时，应仔细观察比较的是否为两个数组的值，因为我是将比较的下标都写成了i，导致第一次无法输出正确结果
	 * 		输出时结果一定要符合题目，将自己的其它观察信息一定要删去
	 * @param args
	 */
	public static void main(String[] args) {
		int n,a,b;
		Scanner scanner=new Scanner(System.in);
		n=scanner.nextInt();
		a=scanner.nextInt();
		b=scanner.nextInt();
		int[][] numOfA=new int[a][2];
		//int[][] numOfB=new int[b][2];
		
		for(int i=0;i<a;i++) {
			numOfA[i][0]=scanner.nextInt();
			numOfA[i][1]=scanner.nextInt();
		}
		
		int temp1,temp2;
		/*for(int i=0;i<b;i++) {
			numOfB[i][0]=scanner.nextInt();
			numOfB[i][1]=scanner.nextInt();
		}
		*/
		long result=0;
		int m=0;
		for(int i=0;i<b;i++) {
			temp1=scanner.nextInt();
			temp2=scanner.nextInt();
			while(m<a) {
				if(temp1==numOfA[m][0]) {
					result=result+temp2*numOfA[m][1];
					m++;
					break;
				}
				else if(temp1>numOfA[m][0]){
					m++;
				}
				else {
					break;
				}
			}
		}
		
		System.out.println(result);
		//使用双指针
		/*
		int i=0,j=0;
		while(i<a&&j<b) {
			if(numOfA[i][0]==numOfB[j][0]) {
				result=result+numOfA[i][1]*numOfB[j][1];
				i++;
				j++;
			}
			else if(numOfA[i][0]>numOfB[j][0]){
				j++;
			}
			else {
				i++;
			}
		}
		*/
	}
}
