public class Directory extends Node {
    private Entry[] entries;
    private int idx;
    private int maxEntries = 100;


    public Directory() {
        entries = new Entry[maxEntries];
        idx = 0;
    }

    public static Directory createEmpty() {
        return new Directory();
    }

    public Entry[] getEntries() {
        return entries;
    }

    public boolean containsEntry(String toSearch) {
        return getEntry(toSearch) != null ? true : false;
    }

    public Entry getEntry(String toSeach) {
        for (Entry entry : entries) {
            if (entry.getName().equals(toSeach))
                return entry;
        }
        return null;
    }

    public Entry createDirectory(String name) {
        if (idx == maxEntries - 1) {
            System.out.println("Der Ordner ist voll!");
            return null;
        }

        Directory dir = Directory.createEmpty();
        Entry entry = new Entry(name,dir);
        entries[idx] = entry;
        idx++;
        this.touch();
        return entry;
    }

    public Entry createFile(String name, String content){
        if (idx == maxEntries - 1) {
            System.out.println("Der Ordner ist voll!");
            return null;
        }

        File file = new File(content);
        Entry entry = new Entry(name,file);
        entries[idx] = entry;
        idx++;
        this.touch();
        return entry;
    }

    public Entry createHardlink(String name, Entry entry){
        if (idx == maxEntries - 1) {
            System.out.println("Der Ordner ist voll!");
            return null;
        }

        Entry e =  entry.createHardlink(name);
        entries[idx] = e;
        idx++;
        this.touch();
        return entry;
    }

    public void accept(String name, Visitor visitor){
        visitor.visitDirectory(name,this);
        for(int i = 0; i < idx; i++){
            Entry e = entries[i];
            File f = e.getAsFile();
            Directory d = e.getAsDirectory();
            if(f != null) {
                visitor.visitFile(name + "/" + e.getName(), f);
            }
            else if(d != null){
                d.accept(name + "/" + e.getName(),visitor);
            }
        }
        visitor.visitedDirectory();
    }
}