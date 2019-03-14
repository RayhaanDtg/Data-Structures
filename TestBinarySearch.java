package recursion;

public class TestBinarySearch {



	public static int binarySearch(int anArray[], int first, int last, int value){

		int index;
		if(first>last){
			index = -1;
		}
		else{
			int mid = (first + last)/2;
			if(value == anArray[mid]){
				index = mid;
			}
			else if(value < anArray[mid]) {
				index =	binarySearch(anArray,first,mid-1,value);
			}
			else
				index = binarySearch(anArray,mid+1,last, value);
		}
		return index;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A = {1, 5, 9, 12, 15, 21, 29, 31};
		System.out.println(binarySearch(A,0,7,9));
	}

}
