package poojas.angels;

/**
 * @enum ESRB enum holds all of the possible options that the user can select
 * for the ESRB ComboBox in OPdb's forms.
 * @author SinaM
 */
public enum ESRB {
    CHILDHOOD("Preschool"),
    EVERYONE("Everyone"),
    TEN_PLUS("10+"),
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
