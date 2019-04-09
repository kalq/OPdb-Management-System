package poojas.angels;

public enum ESRB {
    EARLY_CHILDHOOD("Preschool"),
    EVERYONE("Everyone"),
    EVERYONE_10PLUS("10+"),
    TEEN("13+"),
    MATURE("17+"),
    ADULTS_ONLY("18+");

    private String ageRange;

    private ESRB(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getAgeRange() {
        return ageRange;
    }
}
