public abstract class Node {
    private long lastModified;

    public Node() {
        this.lastModified = System.currentTimeMillis();
    }

    public long getLastModified() {
        return lastModified;
    }

    public void touch() {
        this.lastModified = System.currentTimeMillis();
    }
}