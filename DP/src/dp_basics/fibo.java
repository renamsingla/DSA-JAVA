package dp_basics;

public class fibo {
	
	public static int fiboo(int n, int[]arr) {
		
		if(n==1 || n==0) {
			return n;
		}
		if(arr[n]!=0) {
			return arr[n];
		}
		int fibo1= fiboo(n-1,arr);
		int fibo2= fiboo(n-2,arr);
		return arr[n]= fibo1+fibo2;
	}
	
	public static int fiboBU(int n, int[]arr) {
		arr[0]=0;
		arr[1]=1;
		for(int i=2;i<arr.length;i++) {
			arr[n]=arr[n-1]+arr[n-2];
		}
		return arr[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n= 6;
		int []arr= new int[n+1];
		int ans= fiboo(n,arr);
		int ans2= fiboBU(n,arr);
		System.out.println(ans);
		System.out.println(ans2);
	}

}
