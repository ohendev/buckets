package model;

public class Bucket {

    private int capacity;
    private int contains;
    private boolean full;
    private boolean empty;

    public Bucket(int capacity, int contains) {
        this.capacity = capacity;
        this.contains = contains;
        this.full = isFull();
        this.empty = isEmpty();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getContains() {
        return contains;
    }

    public void setContains(int contains) {
        this.contains = contains;
    }

    public boolean isFull() {
        return contains == capacity;
    }

    public boolean isEmpty() {
        return contains == 0;
    }


    public void fillBucket() {
        this.contains = capacity;
    }

    public void EmptyBucket() {
        this.contains = 0;
    }

    public void transferFromBucket(Bucket bucket) {
        int leftInOtherBucket;
        leftInOtherBucket = (this.contains + bucket.getContains()) - this.capacity;
        this.contains += bucket.getContains();
        if(this.contains > this.capacity) {
            this.contains = this.capacity;
            bucket.setContains(leftInOtherBucket);
        } else {
            bucket.setContains(0);
        }
    }
}
