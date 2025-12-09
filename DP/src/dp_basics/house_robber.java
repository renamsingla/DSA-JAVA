package dp_basics;

public class house_robber {
	
	//this is basic recursion, give tle because overlapping needs to be optimized
	public static int rob(int[]arr, int i) {
//		we will maintain the index for robbing and to know the house to skip and take
		
		//base case
		if(i>arr.length-1) {
			return 0;
		}
		
		//robbed the index i
		int rob1= arr[i]+ rob(arr,i+2);
		
		//did not robbed the index i, hence can robe from adjacent rob out of a choice
		int rob2= rob(arr,i+1);
		
		//final ans for the choice will be the max of the choices we had
		int ans= Math.max(rob1, rob2);
		return ans;
		
	}
	
	//top-down dp
	public static int robTD(int[]arr, int i, int[]dp) {
		
		if(i>arr.length-1) {
			return 0;
		}
		
		if(dp[i]!=-1) {
			return dp[i];
		}
		
		int rob1= arr[i]+robTD(arr,i+2,dp);
		int rob2= robTD(arr,i+1,dp);
		return dp[i]= Math.max(rob1, rob2);
		
		
	}
	
	//top-dwn from last
	public static int robTDL(int[]arr, int i, int[]dp) {
		
		if(i<0) {
			return 0;
		}
		
		if(dp[i]!=-1) {
			return dp[i];
		}
		
		int rob1= arr[i]+ robTDL(arr,i-2,dp);
		int rob2= robTDL(arr,i-1,dp);
		return dp[i]= Math.max(rob1, rob2);
	}
	
	//bottom-up 
	public static int robBU(int[]arr, int i, int[]dp) {
		
		//fill the base case
		dp[0]=arr[0];
		dp[1]= Math.max(arr[0], arr[1]);
		
		for(int j=2;j<=dp.length-1;j++) {
			
			int dp1= dp[j-1];
			int dp2= arr[j]+ dp[j-2];
			dp[j]= Math.max(dp1, dp2);
		}
		return dp[dp.length-1];
		
	}
	
	//bottom up from last
	public static int robBUL(int[]arr, int i, int[]dp) {
		dp[i]=arr[i];
		dp[i-1]=Math.max(arr[i], arr[i-1]);
		
		for(int j=i-2;j>=0;j--) {
			int rob1= dp[j+1];
			int rob2= arr[j]+dp[j+2];
			dp[j]= Math.max(rob1, rob2);
		}
		return dp[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr= {7,5,3,13,1};
		int ans=rob(arr,0);
		System.out.println(ans);
		
		int[]dp= new int[arr.length];
		
		for(int i=0;i<dp.length;i++) {
			dp[i]=-1;
		}
//		int ans2=robTD(arr,0,dp);
//		System.out.println(ans2);
		
//		int ans3=robTDL(arr,arr.length-1,dp);
//		System.out.println(ans3);
		
//		int ans4=robBU(arr,0,dp);
//		System.out.println(ans4);
		
		int ans5=robBUL(arr,arr.length-1,dp);
		System.out.println(ans5);

	}

}
