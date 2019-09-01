import java.util.ArrayList;

abstract class AbstractFile {
    abstract void ls();
}

class File extends AbstractFile{
    private String name;

    public File(String name){
        this.name = name;
    }

    public void ls(){
        System.out.println(CompositePattern.compositeBuilder + name);
    }
}

class Directory extends AbstractFile{
    private String name;
    private ArrayList includedFiles = new ArrayList();
    public Directory(String name){
        this.name = name;
    }
    public void add(Object object){
        includedFiles.add(object);
    }

    public void ls(){
        System.out.println(CompositePattern.compositeBuilder + name);
        CompositePattern.compositeBuilder.append("   ");

        for (Object object : includedFiles) {
            String name = object.getClass().getSimpleName();
            if(name.equals("Directory"))
                ((Directory)object).ls();
            else
                ((File)object).ls();
        }
        CompositePattern.compositeBuilder.setLength(CompositePattern.compositeBuilder.length() - 3);
    }
}

public class CompositePattern {

    public static StringBuilder compositeBuilder = new StringBuilder();

    public static void main(String[] args) {
        Directory music = new Directory("MUSIC");
        Directory scorpions = new Directory("SCORPIONS");
        Directory dio = new Directory("DIO");
        File track1 = new File("Don't wary, be happy.mp3");
        File track2 = new File("track2.m3u");
        File track3 = new File("Wind of change.mp3");
        File track4 = new File("Big city night.mp3");
        File track5 = new File("Rainbow in the dark.mp3");
        music.add(track1);
        music.add(scorpions);
        music.add(track2);
        scorpions.add(track3);
        scorpions.add(track4);
        scorpions.add(dio);
        dio.add(track5);
        music.ls();
    }
}
