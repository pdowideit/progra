public class Printer implements Visitor{
    public Printer(){}

    public void visitFile(String name, File file){
        System.out.println(file.getLastModified() + " " + name);
        System.out.println("> " + file.readContent());
    }

    public void visitDirectory(String name, Directory dir){
        System.out.println(dir.getLastModified() + " " + name + "/");
    }

    public void visitedDirectory(){}

}