package com.larbibouamranemohamed.diffusante;

public class diffusantemodel {


    String date,equiped,chaine,equipee,iconed,iconee,heure,competition,chaine2;

    //
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date= date;
    }

    //
    //
    public String getChaine2() {
        return chaine2;
    }

    public void setChaine2(String chaine2) {
        this.chaine2= chaine2;
    }

    //
    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition= competition;
    }
    //
    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure= heure;
    }
    //
    public String getIconed() {
        return iconed;
    }

    public void setIconed(String iconed) {
        this.iconed= iconed;
    }

    //
    public String getChaine() {
        return chaine;
    }

    public void setChaine(String chaine) {
        this.chaine= chaine;
    }
    //

    public String getEquiped() {
        return equiped;
    }

    public void setEquiped(String equiped) {
        this.equiped= equiped;
    }
    //
    public String getIconee() {
        return iconee;
    }

    public void setIconee(String iconee) {
        this.iconee= iconee;
    }
    //
    public String getEquipee() {
        return equipee;
    }

    public void setEquipee(String equipee) {
        this.equipee= equipee;
    }




    public diffusantemodel(String chaine2 , String competition,String date , String iconed, String equiped,String iconee,String equipee,String chaine,String heure) {
        this.date = date;
        this.competition=competition;
        this.chaine = chaine;
        this.chaine2 = chaine2;
        this.iconed = iconed;
        this.equiped = equiped;
        this.iconee = iconee;
        this.equipee = equipee;
        this.heure = heure;

    }

    diffusantemodel(){ }




}

