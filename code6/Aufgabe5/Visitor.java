public interface Visitor{
    void visitFile(String s,File f);
    void visitDirectory(String s,Directory d);
    void visitedDirectory();
}