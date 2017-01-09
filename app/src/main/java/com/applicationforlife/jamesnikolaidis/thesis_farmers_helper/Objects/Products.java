package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects;

/**
 * Created by James Nikolaidis on 12/17/2016.
 */

public class Products  {
       public  String ActiveSubstance;
       public  String Manufacter , Name , Price ;
       public  String DrugFor , Problem_Solving;
//

        public Products(){

        }


    public String getActiveSubstance() {
        if(!ActiveSubstance.isEmpty() || DrugFor!=null){
        return ActiveSubstance;
        }else{return  null;}
    }

    public String getManufacter() {
        if(Manufacter!=null || !Manufacter.matches("") || !Manufacter.matches(" ")) {
            return Manufacter;
        }else{return null;}
    }

    public String getName() {
        if(Name!=null || !Name.matches("") || !Name.matches(" ")) {
            return Name;
        }else{return null;}
    }

    public String getPrice() {
        if(Price!=null || !Price.matches("") || !Price.matches(" ")) {
            return Price;
        }else{return null;}
    }

    public String getDrugFor() {
        if(!DrugFor.isEmpty() || DrugFor!=null){
        return DrugFor;
        }else{return DrugFor;}

    }


    public void setActiveSubstance(String activeSubstance) {
        ActiveSubstance = activeSubstance;
    }

    public void setManufacter(String manufacter) {
        Manufacter = manufacter;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public void setDrugFor(String drugFor) {
        DrugFor = drugFor;
    }

    public String getProblem_Solving() {
        return Problem_Solving;
    }

    public void setProblem_Solving(String problem_Solving) {
        Problem_Solving = problem_Solving;
    }
}
