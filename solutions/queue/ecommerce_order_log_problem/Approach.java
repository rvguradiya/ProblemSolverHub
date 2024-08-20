class Approach {
    int[] log;
    int capacity;
    int front;
    int rare;

    Approach(int capacity) {
        this.capacity = capacity;
        this.log = new int[this.capacity];
        this.front = 0;
        this.rare = -1;
    }

    public void record(int order_id) {
        if (this.log.length < this.capacity) {
            this.log[rare] = order_id;
            this.rare++;
        } else {
            this.rare = (this.rare + 1) % this.capacity;
            this.front = (this.front + 1) % this.capacity;
            this.log[this.rare] = order_id;
        }
    }

    public int get_last(int index) {
        return this.log[(this.front + index - 1) % this.capacity];
    }

    public static void main(String[] args) {
        Approach r = new Approach(5);
        r.record(102);
        r.record(103);
        r.record(104);
        r.record(105);
        r.record(106);
        r.record(107);

        System.out.println(r.get_last(3));
    }
}
