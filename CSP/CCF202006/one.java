package CCF202006;

import java.util.Scanner;

public class one {
	/**
	 * 	˼·��
	 * 		ͨ�������жϽ������0��С��0��������������־Ϊbig��small��Ȼ���ж�ÿ����ı�־�Ƿ����big��small
	 * 	ע�⣺
	 * 		���������ĿҪ�󣬴�Сд
	 * 		Stringתint
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n,m;
		n=scanner.nextInt();
		m=scanner.nextInt();
		int[][] points=new int[n][3];
		for(int i=0;i<n;i++) {
			points[i][0]=scanner.nextInt();
			points[i][1]=scanner.nextInt();
			String string=scanner.next();
			points[i][2]=(int)string.charAt(0);
	
		}
		int[][] lines=new int[m][3];
		for(int i=0;i<m;i++) {
			lines[i][0]=scanner.nextInt();
			lines[i][1]=scanner.nextInt();
			lines[i][2]=scanner.nextInt();	
		}
		
		
		int j;
		for(int i=0;i<m;i++) {
			int big=0,small=0;
			for(j=0;j<n;j++) {
				int temp=lines[i][0]+lines[i][1]*points[j][0]+lines[i][2]*points[j][1];
				if(temp>0) {
					if(big==0)
						big=points[j][2];
					else {
						if(points[j][2]!=big) {
							System.out.println("No");
							break;
						}
					}
				}
				else if(temp<0){
					if(small==0)
						small=points[j][2];
					else {
						if(points[j][2]!=small) {
							System.out.println("No");
							break;
						}
					}
				}	
			}
			if(j==n)
				System.out.println("Yes");
		}
		
	}
	
}

