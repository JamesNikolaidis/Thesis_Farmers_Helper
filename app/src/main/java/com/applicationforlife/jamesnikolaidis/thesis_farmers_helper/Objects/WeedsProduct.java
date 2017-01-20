package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects;

/**
 * Created by James Nikolaidis on 12/17/2016.
 */

public class WeedsProduct {
       public  String ActiveSubstance;
       public  String Manufacter , Name , Price ;
       public  String DrugFor , Problem_Solving,Description;
//

        public WeedsProduct(){

        }


        public WeedsProduct(String ...args){


           try {
                        if (args != null && args.length >= 6) {
                            this.ActiveSubstance = args[0];
                            this.Manufacter = args[1];
                            this.Name = args[2];
                            this.Price = args[3];
                            this.DrugFor = args[4];
                            this.Problem_Solving = args[5];
                            this.Description = args[6];
                                if(args.length>6){ System.out.printf("Farmers Helper Warning :You gave more information from wanted : %d ,  Wanted 6 you may loose data..", args.length);}


                        }
                        if (args.length < 6) {
                          System.out.printf("Farmers Helper ERROR :You gave less information : %d , Wanted 6", args.length);
                        }
           }catch(NullPointerException NullPointerException){
               //TODO Call again the Propoer and Restart the Method
             System.out.println("Farmers Helper ERROR :The Company must have Informations like Name etc.");
             }



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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
