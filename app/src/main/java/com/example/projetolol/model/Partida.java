package com.example.projetolol.model;

import java.util.List;

public class Partida {

    private int champion;
    private String role;
    private String lane;
    private String realLane;
    private int gameId;
    private int gameDuration;
    private List<Participante> participants;

    public Partida(int champion, String role, String lane, String realLane, int gameId) {
        this.champion = champion;
        this.role = role;
        this.lane = lane;
        this.realLane = realLane;
        this.gameId = gameId;
    }

    public int getChampion() {
        return champion;
    }

    public void setChampion(int champion) {
        this.champion = champion;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public String getRealLane() {
        return realLane;
    }

    public void setRealLane(String realLane) {
        this.realLane = realLane;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getGameDuration() {
        return gameDuration;
    }

    public void setGameDuration(int gameDuration) {
        this.gameDuration = gameDuration;
    }

    public List<Participante> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participante> participants) {
        this.participants = participants;
    }



    public void descobreLane(){
        if( lane == "MID_LANE" && role == "SOLO")
            this.realLane = "MIDDLE";
        else if( lane == "TOP_LANE" && role == "SOLO")
            this.realLane = "TOP";
        else if(lane == "JUNGLE" &&  role == "NONE")
            this.realLane = "JUNGLE";
        else if(lane == "BOT_LANE" && role == "DUO_CARRY")
            this.realLane = "BOTTOM";
        else if(lane == "BOT_LANE" &&  role == "DUO_SUPPORT")
            this.realLane = "UTILITY";
        else this.realLane = "NONE";
    }
}
