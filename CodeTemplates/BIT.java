class BIT {

	static void updateTree(int bit[], int val, int index) {
		while(index < bit.length) {
			bit[index] += val;
			index = getNext(index);
		}
	}

	static int getSum(int bit[], int index) {
		index = index + 1;
		int sum = 0;
		while(index > 0) {
			sum += bit[index];
			index = getParent(index);
		}
		return sum;
	}

	static int getParent(int index) {
		return index - (index & -index);
	}

	static int getNext(int index) {
		return index + (index & -index);
	}

	public static void main(String args[]) {
		int input[] = {1, 2, 3, 4, 5, 6, 7};
		int bit[] = new int[input.length + 1];
		for(int i = 1; i <= input.length; i++)
			updateTree(bit, input[i - 1], i);

		System.out.println(getSum(bit, 0));
		System.out.println(getSum(bit, bit.length - 2));
		updateTree(bit, 2, 3);	// adds
		System.out.println(getSum(bit, 0));
		System.out.println(getSum(bit, bit.length - 2));
	}
}
