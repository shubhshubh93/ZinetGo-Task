public class Dominator {
	public int sol(int[] A) {
		int pos = 0;
		int count = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[pos] == A[i]) {
				count++;
			} else {
				count--;
				if (count == 0) {
					pos = i;
					count++;
				}
			}
		}

		int ret = 0;
		int cand = A[pos];
		int[] E = new int[A.length];
		int[] N = new int[A.length];
		int ec = 0;
		int nc = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] == cand) {
				ec++;
			} else {
				nc++;
			}
			E[i] = ec;
			N[i] = nc;
		}

		for (int i = 0; i < A.length; i++) {
			if (E[i] > N[i] && ((nc - N[i]) < (ec - E[i]))) {
				ret++;
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		Dominator Domi = new Dominator();
		int a[] = {3,4,3,2,3,-1,3,3};
		System.out.println(Domi.sol(a));
	}

}
