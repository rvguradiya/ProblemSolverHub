class Record {
  constructor(N) {
    this.capacity = N;
    this.log = [];
    this.front = 0;
    this.rare = 0;
  }

  record(order_id) {
    if (this.log.length < this.capacity) {
      this.log.push(order_id);
      this.rare++;
    } else {
      this.rare = (this.rare + 1) % this.capacity;
      this.front = (this.front + 1) % this.capacity;
      this.log[this.rare] = order_id;
    }
  }

  get_last(index) {
    return this.log[(this.front + index - 1) % this.capacity];
  }
}

r = new Record(5);
r.record(102);
r.record(103);
r.record(104);
r.record(105);
r.record(106);
r.record(107);

console.log(r.get_last(3));
