package com.example.vtucompanion;

import java.util.HashMap;
import java.util.Map;

public class Credentials {
    HashMap<String,String> Mapper = new HashMap<String, String>();

    public void addCred(String Username,String Password){
        Mapper.put(Username, Password);
    }

    public boolean checkUsername(String Username){
        return Mapper.containsKey(Username);
    }
    public boolean VerifyCred(String Username,String Password){
        if(Mapper.containsKey(Username)){
            if(Password.equals(Mapper.get(Username))){
                return true;
            }
        }
        return false;
    }
    public void loadCred(Map<String,?> Shredprefs){
        for(Map.Entry<String,?> entries: Shredprefs.entrySet() ){
            if(!entries.getKey().equals("rememberMe")){
                Mapper.put(entries.getKey(),entries.getValue().toString());

            }
        }
    }

}






//    private String CVCName;
//    private String CVCPass;
//    Credentials(){}
//    Credentials(String VCName,String VCPass){
//        this.CVCName = VCName;
//        this.CVCPass = VCPass;
//    }
//
//    public String getVCName() {
//        return CVCName;
//    }
//
//    public void setVCName(String VCName) {
//        this.CVCName = VCName;
//    }
//
//    public String getVCPass() {
//        return CVCPass;
//    }
//
//    public void setVCPass(String VCPass) {
//        this.CVCPass = VCPass;
//    }