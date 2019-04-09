package poojas.angels;

import java.util.ArrayList;
import java.util.Arrays;

public class CompanyList {

    private ArrayList<Company> companies;

    public CompanyList() {
        this.companies = new ArrayList<>();
    }

    /**
     *
     * @param companies
     */
    public CompanyList(Company[] companies) {
        this.companies = new ArrayList<>(Arrays.asList(companies));
    }

    public ArrayList<Company> getCompanies() {
        return this.companies;
    }

    /**
     *
     * @param companies
     */
    public void setCompanies(ArrayList<Company> companies) {
        this.companies = companies;
    }

    /**
     *
     * @param company
     */
    public void addCompany(Company company) {
        this.companies.add(company);
    }

    /**
     *
     * @param company
     */
    public void removeCompany(Company company) {
        this.companies.remove(company);
    }

    public ArrayList<Company> sortByName() {
        ArrayList<Company> newList = this.companies;
        //return newList.sort();
        throw new UnsupportedOperationException();
    }

    /**
     * A single line list of all Companies
     * @return String representation
     */
    @Override
    public String toString() {
        String companyList = "";

        for (Company company : this.companies) {
            companyList += company + " ";
        }

        return companyList.trim();
    }
}
