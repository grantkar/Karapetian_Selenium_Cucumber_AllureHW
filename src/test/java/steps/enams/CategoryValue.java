package steps.enams;

public enum CategoryValue {
    Автомобили("9"),
    Квартиры("24"),
    Оргтехника ("99");

    private String value;

    CategoryValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
