package CCF202006;

import java.util.Scanner;

public class two {
	/**
	 * 	��������
	 * 		��ʼ60����Ϊ��Ž��������Ϊint�������㣬ʹ��long�󣬷���Ϊ100
	 * 	�ռ�ռ�ã�
	 * 		��ʼʱ��ʹ����������������ֵ
	 * 		�Ľ���ֻ��ŵ�һ�����飬�ڶ�������ͨ�������ֲ�������ż��ɣ���������
	 * 	ע�⣺
	 * 		��ʹ��˫ָ����бȽ�ʱ��Ӧ��ϸ�۲�Ƚϵ��Ƿ�Ϊ���������ֵ����Ϊ���ǽ��Ƚϵ��±궼д����i�����µ�һ���޷������ȷ���
	 * 		���ʱ���һ��Ҫ������Ŀ�����Լ��������۲���Ϣһ��Ҫɾȥ
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
		//ʹ��˫ָ��
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
