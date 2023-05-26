package tech.alyxbb.AOC2022.day7;

public abstract class FileDir {
    private final String name;

    public FileDir(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getSize();
}
