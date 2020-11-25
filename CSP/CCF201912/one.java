package CCF201912;

import java.util.Scanner;

public class one {
	/**
	 * 	注意：
	 * 		循环数组时，应该记录count与num大小关系
	 * 		判断条件：
	 * 			倍数：math%7==0
	 * 			个位：math%10==7
	 * 			十位：math/10%10==7  我写成了math/10，这样会导致如172的数无法判断
	 * 			百位：math/100==7
	 * @param args
	 */
	public static void main(String[] args) {
		int num;	//总共数字个数
		Scanner scanner=new Scanner(System.in);
		num=scanner.nextInt();
		int count=0;	//已判断数字个数
		int math=1;		//报数
		int[] persons=new int[4];	//四个人
		while(count<num) {
			for(int i=0;i<persons.length;i++) {
				if(math%7==0||math%10==7||math/10%10==7||math/100==7) {
					//判断是否满足“7”条件
					persons[i]++;
				}
				else {
					count++;
				}
				math++;
				if(count>=num)
					break;
			}
			
		}
		for(int i=0;i<persons.length;i++) {
			System.out.println(persons[i]);
		}
	}
}
