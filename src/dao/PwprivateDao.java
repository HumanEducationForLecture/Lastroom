package dao;


import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class PwprivateDao {
	 int p,q,n,pi,e,d;
	 BigInteger q1,q2,n1,p1,e1,d1,pi1;
	//랜덤함수로  소수구하기 및 반복
	int returns(){
		   Random random=new Random();
		   int q=0;
	       boolean c=true;
	       boolean a = true;
//	       for(int j=0; j<2; j++){
		       while(c) {
			       int num=(int)(Math.random()*50)+10;
			       for(int i=2; i<num; i++){
			    	   if(num%i==0){
				   	   a=false;
			 		   break;
			    	   }
			       }
			       if (a) {
			           c=false;
			         	q=num;
			       }else{
			    	   a=true;
			    	   continue;
			       }   
				}
//		       c=true;
//	       }
		return q;
	}
	//값은값이면 다시출력 및 낮은숫자 앞으로
	String result(int random,int random1){
		boolean a=true;
		int q,k;
		while(a){
			if(random!=random1){
				a=false;
			}else{
				random1=returns();
				continue;
			}
		}
		if(random<random1){
			 q=random;
			 k=random1;
		}else{
			 k=random;
			 q=random1;
		}
		return q+" "+k;
	}
	int privatekey(int e,int pi){
		int d=0;
		for(int i=0; i<pi; i++){
			if(i!=0){
				if((i*e)%pi==1){
					d=i;
				}
			}
		}
		return d;
	}
	BigInteger[] privat(BigInteger pri[]){
		System.out.println("암호화 작업중 입니다");
		for(int i=0; i<pri.length; i++){
			pri[i]=pri[i].modPow(e1, n1);
			System.out.print(pri[i]+"    ");
		}
		System.out.println("");
		return pri;
	}
	
	BigInteger[] publi(BigInteger publ[]){
		for(int i=0; i<publ.length; i++){
			publ[i]=publ[i].modPow(d1, n1);
		}
		print(publ);
		return null;
	}
	//공개키 (e,n의값) 개인키 (d,n의값);
	void key(){
		//각각들어온값을 스페이스바 기준으로 나눠줌
		String a=result(returns(),returns());
		int w=a.indexOf(" ");
		//소수q
		int q=Integer.parseInt(a.substring(0,w));
		q1=new BigInteger(Integer.toString(q));
		//소수p
		int p=Integer.parseInt(a.substring(w+1));
		p1=new BigInteger(Integer.toString(p));
		//소수p*q의값 n
		int n=q*p;
		n1=new BigInteger(Integer.toString(q*p));
		//오일러파이값 pi (q-1)*(p-1)
		int pi=(q-1)*(p-1);
		pi1=new BigInteger(Integer.toString((q-1)*(p-1)));
		//서로수를 구하기위해 한번더 소수구하는 매서드를 사용및 저장e는 공개키
		int e=returns();
		e1=new BigInteger(Integer.toString(e));
		//d는 개인키 남에게도용 금지 매서드를 사용하여 임이의수*e%pi의값이 1이나오는값을 찾는 메서드 
		int d=privatekey(e,pi);
		d1=new BigInteger(Integer.toString(privatekey(e,pi)));
	}
	private String[] print(BigInteger print[]){
		System.out.println("복호화 작업및 원래 문자로 변경");
		String [] text=new String[print.length];
		for(int i=0; i<print.length; i++){
			text[i]=Character.toString((char)print[i].intValue());
			System.out.print(text[i]+"    ");
		}
		return text;
	}
	BigInteger[] input(String input){
		BigInteger[] pwinput=new BigInteger[input.length()];
		String y;
		Integer y1;
		for(int i=0; i<pwinput.length; i++){
			y1=(int)input.charAt(i);
			y=y1.toString(y1);
			pwinput[i]=new BigInteger(y);
		}
		return pwinput;
	}
}
