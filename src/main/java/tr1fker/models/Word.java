package tr1fker.models;

public class Word {
    private long id;
    private String name;

    public Word(long id, String name){
        this.id = id;
        this.name = name;
    }


    public String getName(){
        return this.name;
    }
}
