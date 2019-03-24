package model;

public class Bucket {

    private int capacity;
    private int content;

    public Bucket(int capacity, int contains) {
        this.capacity = capacity;
        this.content = contains;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public void fillBucket() {
        this.content = capacity;
    }

    public void EmptyBucket() {
        this.content = 0;
    }

    public void transferFromBucket(Bucket pouringBucket) {
        int whatsLeftInPouringBucket = (this.content + pouringBucket.getContent()) - this.capacity;
        this.content += pouringBucket.getContent();
        if(this.content > this.capacity) {
            this.content = this.capacity;
            pouringBucket.setContent(whatsLeftInPouringBucket);
        } else {
            pouringBucket.setContent(0);
        }
    }
}
