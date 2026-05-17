public class SmallestEvenMultiple {
    public int smallestEvenMultiple(int n) {
        // If `n` is already even, it is automatically a multiple of 2.
        if (n % 2 == 0) {
            return n;
        }

        // If `n` is odd, the smallest multiple that is also even is `2 * n`.
        return n * 2;
    }
}