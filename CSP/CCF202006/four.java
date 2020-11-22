package CCF202006;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class four {
	/**
	 * 	评测结果：32分  运行超时
	 * 	网上解答：
	 * 		需进行动态规划，故学习动态规划再做
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

