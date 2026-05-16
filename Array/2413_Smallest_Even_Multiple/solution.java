class solution {
    public int smallestEvenMultiple(int n) {
        // If n is already even,
        // it is divisible by both n and 2
        if (n % 2 == 0) {
            return n;
        }
        // If n is odd,
        // multiply by 2
        return n * 2;
    }
}