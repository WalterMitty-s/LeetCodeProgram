package CCF202006;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class four {
	/**
	 * 	��������32��  ���г�ʱ
	 * 	���Ͻ��
	 * 		����ж�̬�滮����ѧϰ��̬�滮����
	 * @param args
	 */
	public static void main(String[] args) {
		int n;
		String string;
		Scanner scanner=new Scanner(System.in);
		n=scanner.nextInt();
		string=scanner.next();
		String init="1";
		String change="";
		for(int i=0;i<n;i++) {
			change="";
			for(int j=0;j<init.length();j++) {
				
				if(init.charAt(j)=='2') {
					change=change+"4";
				}
				else if(init.charAt(j)=='4'){
					change=change+"16";
				}
				else if(init.charAt(j)=='1'){
					change=change+"2";
				}
				else if(init.charAt(j)=='6'){
					change=change+"64";
				}
			}
			init=change;
		}
		//System.out.println(init);
		long count = 0;
		while(true){
			int index = init.indexOf(string);
			if(index != -1){
				init= init.substring(index+string.length(), init.length());
				count++;
				if(count>998244353)
					count=count-998244353;
			}else{
				break;
			}
		}
		System.out.println(count);
		
	}
}

