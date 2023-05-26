package tech.alyxbb.AOC2022.day7;

public class File extends FileDir {
    private final int size;


    public File(String name, final int size) {
        super(name);
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }
}
