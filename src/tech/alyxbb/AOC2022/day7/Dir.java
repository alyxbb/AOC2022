package tech.alyxbb.AOC2022.day7;

import java.util.ArrayList;

public class Dir extends FileDir implements Comparable<Dir> {
    private final Dir parent;


    private final ArrayList<Dir> childDir = new ArrayList<>();
    private final ArrayList<File> childFile = new ArrayList<>();


    public ArrayList<Dir> getChildDir() {
        return this.childDir;
    }

    public Dir(String name, Dir parent) {
        super(name);
        this.parent = parent;
    }

    public void addDir(Dir dir) {
        childDir.add(dir);
    }

    public void addFile(File file) {
        childFile.add(file);
    }

    public int getSize() {
        int tot = 0;
        for (File file : childFile) {
            tot += file.getSize();
        }
        for (Dir dir : childDir) {
            tot += dir.getSize();
        }
        return tot;
    }

    public int getSizeTotIfSmall() {
        int tot = 0;
        int mySize = getSize();
        if (mySize <= 100000) {
            tot += mySize;
        }
        for (Dir dir : childDir) {
            tot += dir.getSizeTotIfSmall();
        }
        return tot;

    }

    public Dir getParent() {
        return parent;
    }

    public ArrayList<Dir> getAllDirs() {
        ArrayList<Dir> dirs = new ArrayList<>();
        dirs.add(this);
        for (Dir child : childDir) {
            dirs.addAll(child.getAllDirs());
        }
        return dirs;
    }

    public int compareTo(Dir dir) {
        return this.getSize() - dir.getSize();
    }
}
