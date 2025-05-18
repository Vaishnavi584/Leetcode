class Pair {
    int val;
    int idx;

    public Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}

class StockSpanner {
    Stack<Pair> st;
    int idx = -1;

    public StockSpanner() {
        idx = -1;
        st = new Stack<>();
    }

    public int next(int price) {
        idx = idx + 1;

        while (!st.isEmpty() && st.peek().val <= price) {
            st.pop();
        }
        int ans = idx - (st.isEmpty() ? -1 : st.peek().idx);
        st.push(new Pair(price, idx));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */