public class Entry {
    private String name;
    private Node node;

    public Entry(String name, Node node) {
        this.node = node;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public File getAsFile() {
        if (node instanceof File)
            return (File) node;
        return null;
    }

    public Directory getAsDirectory() {
        if (node instanceof Directory)
            return (Directory) node;
        return null;
    }

    public Entry createHardlink(String newName) {
        return new Entry(newName, node);
    }
}