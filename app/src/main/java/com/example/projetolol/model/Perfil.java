package com.example.projetolol.model;

import java.util.List;

public class Perfil {

    private String puuid;
    private String id;
    private String name;
    private String accountId;
    private int profileIconId;
    private int summonerLevel;
    private List<Partida> partidasList;

    public Perfil(String puuid, String summonerName, String accountId, int profileIconId, int level, String encryptedSummonerId) {
        this.puuid = puuid;
        this.name = summonerName;
        this.accountId = accountId;
        this.profileIconId = profileIconId;
        this.summonerLevel = level;
        this.id = encryptedSummonerId;
    }





    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public String getEncryptedSummonerId() {
        return id;
    }

    public void setEncryptedSummonerId(String encryptedSummonerId) {
        this.id = encryptedSummonerId;
    }

    public String getSummonerName() {
        return name;
    }

    public void setSummonerName(String summonerName) {
        this.name = summonerName;
    }


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }


    public int getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(int profileIconId) {
        this.profileIconId = profileIconId;
    }

    public int getLevel() {
        return summonerLevel;
    }

    public void setLevel(int level) {
        this.summonerLevel = level;
    }

    public String getPuuid(){
        return puuid;
    }
}
