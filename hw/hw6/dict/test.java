class test{
	private static int prime(int input){
  	boolean[] arr=new boolean[input+1];
  	for (int i=0;i<arr.length;i++){
  		arr[i]=true;
  	}
  	for (int i=2;i<=Math.sqrt(2*input);i++){
  		for(int j=(input/i)*i;j<=2*input;j+=i){
  			if(j>=input&&j<=2*input){
  				arr[j-input]=false;
  				//System.out.print("Executed");
  			}
  		}
  	}
  	for(int k=0;k<arr.length;k++){
  		if(arr[k]==true){
  			System.out.print(k+input+" ");
  		}
  	}
  	System.out.print('\n');

  	return best(arr,input);
  }

  private static int best(boolean[] input,int offset){
  	int low=input.length/2;
  	int high=input.length/2;
  	for(int i=0;i<=input.length/2;i++){
  		if(input[low])
  			return offset+low;
  		else if(input[high])
  			return offset+high;
  		else{
  			low--;
  			high++;
  		}
  	}
  	return -1;
  }
	public static void main(String[] args){
		int i=75;
		System.out.println(prime(i));
	}
}