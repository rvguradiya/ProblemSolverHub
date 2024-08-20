class Record:
    def __init__(self,N) -> None:
        self.log = []
        self.capacity = N

    def record(self,order_id):
        if len(self.log) < self.capacity:
            self.log.append(order_id)
        else:
            self.log.pop(0)
            self.log.append(order_id)
    
    def get_last(self,index):
        return self.log[-index]
    
r = Record(5)
r.record(102)
r.record(103)
r.record(104)
r.record(105)
r.record(106)
r.record(107)

print(r.get_last(3))