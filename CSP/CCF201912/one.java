package CCF201912;

import java.util.Scanner;

public class one {
	/**
	 * 	ע�⣺
	 * 		ѭ������ʱ��Ӧ�ü�¼count��num��С��ϵ
	 * 		�ж�������
	 * 			������math%7==0
	 * 			��λ��math%10==7
	 * 			ʮλ��math/10%10==7  ��д����math/10�������ᵼ����172�����޷��ж�
	 * 			��λ��math/100==7
	 * @param args
	 */
	public static void main(String[] args) {
		int num;	//�ܹ����ָ���
		Scanner scanner=new Scanner(System.in);
		num=scanner.nextInt();
		int count=0;	//���ж����ָ���
		int math=1;		//����
		int[] persons=new int[4];	//�ĸ���
		while(count<num) {
			for(int i=0;i<persons.length;i++) {
				if(math%7==0||math%10==7||math/10%10==7||math/100==7) {
					//�ж��Ƿ����㡰7������
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
