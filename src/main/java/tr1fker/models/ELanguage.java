package tr1fker.models;

public enum ELanguage {
    no("not defined"), ru("ru"), en("en");

    private String language;

    private ELanguage(String language) {
        this.language = language;
    }

    public static ELanguage getLanguage(int choice) {
        return ELanguage.values()[choice];
    }

    @Override
    public String toString(){
        return this.language;
    }
}
