package test;

public class BaseBallGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] arr= {"5","2","C","D","+"};

		System.out.println(calPoints(arr));
	}

	private static int calPoints(String[] arr) {
		// TODO Auto-generated method stub
		int output=0;
		int last=Integer.parseInt(arr[0]);
		for (int i = 0; i < arr.length; i++) {

			if(arr[i]=="C" && i!=0) {

				output-=last;

				last=output;
			}
			else if(arr[i]=="D" && i!=0) {

				output+=output+last;
				last=output;
			}else if(arr[i]=="+" & i!=0) {

				output+=last;

				last=output;
			}else {
				output=output+Integer.parseInt(arr[i]);
				last=Integer.parseInt(arr[i]);
			}
		}

		return output;
	}
}
