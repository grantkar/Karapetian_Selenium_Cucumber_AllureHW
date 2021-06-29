package steps.enams;

public enum Steps {
    По_умолчанию("101"),
    Дешевле("1"),
    Дороже("2"),
    По_дате("104");

    private String value;

    Steps(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
