package interview_questions;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String str1 = "ABCDEFG";
		String str2 = "ACDG";
		System.out.println("Longest Common Subsequence: "+longestCommonSubsequence(str1.toCharArray(), str2.toCharArray()));
		System.out.println("Longest Common Substring: "+longestCommonSubstring(str1.toCharArray(), str2.toCharArray()));
	}
	
	// Order doesn't matter as long as characters match between two char array
	public static int longestCommonSubsequence(char str1[], char str2[]){
		int max=0;
		int[][] temp = new int[str1.length+1][str2.length+1];
		for(int i=1; i<temp.length; i++){
			for(int j=1; j<temp[i].length; j++){
				if(str1[i-1] == str2[j-1]){
					temp[i][j] = temp[i-1][j-1] + 1;
				} else{
					temp[i][j] = Math.max(temp[i-1][j], temp[i][j-1]);
				} 
				if(temp[i][j] > max){
					max = temp[i][j];
				}
			}
		}
		return max;
	}
	
	// Order matters between two strings being matched.
	 public static int longestCommonSubstring(char str1[], char str2[]){
	        int T[][] = new int[str1.length+1][str2.length+1];
	        
	        int max = 0;
	        for(int i=1; i <= str1.length; i++){
	            for(int j=1; j <= str2.length; j++){
	                if(str1[i-1] == str2[j-1]){
	                    T[i][j] = T[i-1][j-1] +1;
	                    if(max < T[i][j]){
	                        max = T[i][j];
	                    }
	                }
	            }
	        }
	        return max;
	    }
}
