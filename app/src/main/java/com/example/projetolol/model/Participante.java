package com.example.projetolol.model;

public class Participante {

    private int participantId;
    private String win;
    private String summonerName;
    private int profileIcon;
    private int goldEarned;
    private int deaths;
    private int kills;
    private int assists;
    private int championId;
    private int partidaId;

    public Participante(int participantId, String win, String summonerName, int profileIcon, int goldEarned, int deaths, int kills, int assists, int championId, int partidaId) {
        this.participantId = participantId;
        this.win = win;
        this.summonerName = summonerName;
        this.profileIcon = profileIcon;
        this.goldEarned = goldEarned;
        this.deaths = deaths;
        this.kills = kills;
        this.assists = assists;
        this.championId = championId;
        this.partidaId = partidaId;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public int getProfileIcon() {
        return profileIcon;
    }

    public void setProfileIcon(int profileIcon) {
        this.profileIcon = profileIcon;
    }

    public int getGoldEarned() {
        return goldEarned;
    }

    public void setGoldEarned(int goldEarned) {
        this.goldEarned = goldEarned;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getChampionId() {
        return championId;
    }

    public void setChampionId(int championId) {
        this.championId = championId;
    }

    public int getPartidaId() {
        return partidaId;
    }

    public void setPartidaId(int partidaId) {
        this.partidaId = partidaId;
    }



}
