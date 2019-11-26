import java.util.Arrays;

class deep_shallow_copy_ex {
	public static void main(String[] args) {
		int[] data = {0,1,2,3,4};
		int[] scopy = null;
		int[] dcopy = null;

		scopy = shallowCopy(data);
		dcopy = deepCopy(data);

		System.out.println("Orig: "+Arrays.toString(data));
		System.out.println("Scopy:"+Arrays.toString(scopy));
		System.out.println("Dcopy:"+Arrays.toString(dcopy));
		System.out.println();
		data[0] = 5;

		System.out.println("=================Data[0] Modified================");

		System.out.println("Orig: "+Arrays.toString(data));
		System.out.println("Scopy:"+Arrays.toString(scopy));
		System.out.println("Dcopy:"+Arrays.toString(dcopy));
		System.out.println(); 
	}

	public static int[] shallowCopy(int[] arr) {
		return arr;
	}

	public static int[] deepCopy(int[] arr) {
		if ( arr == null ) return null;
		int[] res = new int[arr.length];

		System.arraycopy(arr, 0, res, 0, arr.length);
		return res;
	}
}
