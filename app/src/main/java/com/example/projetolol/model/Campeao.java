package com.example.projetolol.model;

public class Campeao {
    private int id;
    private String nome;
    private int champion_level;
    private int getChampion_points;
    private String summonerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getChampion_level() {
        return champion_level;
    }

    public void setChampion_level(int champion_level) {
        this.champion_level = champion_level;
    }

    public int getGetChampion_points() {
        return getChampion_points;
    }

    public void setGetChampion_points(int getChampion_points) {
        this.getChampion_points = getChampion_points;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }
}
