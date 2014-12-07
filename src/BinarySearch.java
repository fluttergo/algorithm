public class BinarySearch {

	public static void main(String[] args) {
		int data[] = new int[1024 * 1024 * 10 * 4];
		for (int i = 0; i < data.length; i++) {
			data[i] = i * 3;
		}
		int target = data[data.length-1];// 49%3!=0
		binarySearchWhileJDK(data, 0, data.length, target);
	}

	/**
	 * 递归法
	 * 
	 * @param data
	 * @param start
	 * @param end
	 * @param target
	 */
	public static void binarySearch(int[] data, int start, int end, int target) {
		System.out.println("search start[" + start + "]end [" + end + "]");
		if (end - start == 1 && target != data[start] && target != data[end]) {
			System.out.println("target not found");
			return;
		}
		if (data[(start + end) / 2] < target) {
			binarySearch(data, (start + end) / 2, end, target);
		} else if (data[(start + end) / 2] > target) {
			binarySearch(data, start, (start + end) / 2, target);
		} else {
			System.out.println("target" + (start + end) / 2);
		}
	}

	/**
	 * 迭代法
	 * 
	 * @param data
	 * @param start
	 * @param end
	 * @param target
	 */
	public static void binarySearchWhile(int[] data, int start, int end,
			int target) {

		int starIndex = start;
		int endIndex = end - 1;
		int midleIndex = (start + endIndex) / 2;
		while (data[midleIndex] != target) {
			if (endIndex - starIndex == 1 && data[midleIndex] != target) {
				System.out.println("target not found");
				return;
			}
			if (data[starIndex] == target) {
				System.out.println("target is start"+starIndex);
				return;
			}
			if (data[endIndex] == target) {
				System.out.println("target is "+endIndex);
				return;
			}
			if (target > data[starIndex] && target < data[midleIndex]) {
				endIndex = midleIndex;
				midleIndex = (starIndex + endIndex) / 2;
			} else if (target > data[midleIndex] && target < data[endIndex]) {
				starIndex = midleIndex;
				midleIndex = (starIndex + endIndex) / 2;
			}
			System.out.println("search start[" + starIndex + "]end ["
					+ endIndex + "]");
		}
		System.out.println("target" + midleIndex);
	}
	/**
	 * 迭代法 JDK
	 * 
	 * @param data
	 * @param start
	 * @param end
	 * @param target
	 */
	public static void binarySearchWhileJDK(int[] data, int start, int end,
			int target) {

		int starIndex = start;
		int endIndex = end - 1;
		while (starIndex <=endIndex) {
			int midleIndex = (starIndex  + endIndex) >>> 1;
			System.out.println(midleIndex);
			System.out.println("search start[" + starIndex + "]end ["
					+ endIndex + "]");
			if (target < data[midleIndex]) {
				endIndex = midleIndex - 1;

			} else if (target > data[midleIndex]) {
				starIndex = midleIndex + 1;
			} else {
				System.out.println("target" + midleIndex);
				return;
			}

		}
	}
}
