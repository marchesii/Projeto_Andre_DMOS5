package com.example.projetolol.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {

    //constantes do bd
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "contas.db";

    //Constantes da tabela Perfil
    public static final String TABLE_NAME_PERFIL = "perfil";
    public static final String COLUMN_PUUID = "puuid";
    public static final String COLUMN_ENCRYPTED_SUMMONERID = "encrypted_summonerid";
    public static final String COLUMN_SUMMONER_NAME = "summoner_name";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PROFILE_ICONID = "profile_iconid";
    public static final String COLUMN_LEVEL = "level";


    //Constantes da tabela Liga
    public static final String TABLE_NAME_LIGA = "liga";
    public static final String COLUMN_QUEUETYPE = "queuetype";
    public static final String COLUMN_TIER = "tier";
    public static final String COLUMN_RANK = "rank";
    public static final String COLUMN_LIGA_SUMMONER_ID = "summoner_id";
    public static final String COLUMN_LIGA_SUMMONER_NAME = "summoner_name";
    public static final String COLUMN_LIGA_WINS = "wins";
    public static final String COLUMN_LIGA_LOSSES = "losses";

    //Constantes da tabela Campeao
    public static final String TABLE_NAME_CAMPEAO = "campeao";
    public static final String COLUMN_CAMPEAO_ID = "id";
    public static final String COLUMN_CAMPEAO_NOME = "nome";
    public static final String COLUMN_CAMPEAO_LEVEL = "champion_level";
    public static final String COLUMN_GETCHAMPION_POINTS = "champion_points";
    public static final String COLUMN_CAMPEAO_SUMMONERID = "summoner_id";

    //Constantes da tabela Participante
    public static final String TABLE_NAME_PARTICIPANTE = "participante";
    public static final String COLUMN_PARTICIPANTE_ID = "id";
    public static final String COLUMN_WIN = "win";
    public static final String COLUMN_PARTICIPANTE_SUMMONERNAME = "summoner_name";
    public static final String COLUMN_PARTICIPANTE_PROFILEICON = "profile_icon";
    public static final String COLUMN_GOLD_EARNED = "gold_earned";
    public static final String COLUMN_DEATHS= "deaths";
    public static final String COLUMN_KILLS= "kills";
    public static final String COLUMN_ASSISTIS = "assistis";
    public static final String COLUMN_PARTICIPANTE_CAMPEAO_ID = "campeao_id";
    public static final String COLUMN_PARTICIPANTE_PARTIDA_ID = "partida_id";


    //Constantes da tabela Partida
    public static final String TABLE_NAME_PARTIDA = "partida";
    public static final String COLUMN_PARTIDA_ID= "id";
    public static final String COLUMN_PARTIDA_CAMPEAO = "champion";
    public static final String COLUMN_ROLE = "role";
    public static final String COLUMN_LANE = "lane";
    public static final String COLUMN_REALLANE = "real_lane";
    public static final String COLUMN_PARTICIPANTES= "participantes";
    public static final String COLUMN_GAME_DURATION = "game_duration" ;


    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.setVersion(1);
        String sql;


        sql = "CREATE TABLE " + TABLE_NAME_PERFIL + "(";
        sql += COLUMN_PUUID+ " TEXT NOT NULL, ";
        sql += COLUMN_SUMMONER_NAME + " TEXT NOT NULL, ";
        sql += COLUMN_ID + " TEXT NOT NULL, ";
        sql += COLUMN_PROFILE_ICONID + " TEXT NOT NULL, ";
        sql += COLUMN_LEVEL + " TEXT NOT NULL, ";
        sql += COLUMN_ENCRYPTED_SUMMONERID + " TEXT PRIMARY KEY);";
        sqLiteDatabase.execSQL(sql);

        sql = "CREATE TABLE " + TABLE_NAME_LIGA + "(";
        sql += COLUMN_QUEUETYPE+ " TEXT NOT NULL, ";
        sql += COLUMN_TIER + " TEXT NOT NULL, ";
        sql += COLUMN_RANK + " TEXT NOT NULL, ";
        sql += COLUMN_LIGA_SUMMONER_ID + " TEXT NOT NULL, ";
        sql += COLUMN_LIGA_WINS + " TEXT NOT NULL, ";
        sql += COLUMN_LIGA_LOSSES + " TEXT NOT NULL, ";
        sql += COLUMN_LIGA_SUMMONER_NAME + " TEXT NOT NULL, ";
        sql += "FOREIGN KEY(" + COLUMN_LIGA_SUMMONER_NAME + ") " + "REFERENCES " + TABLE_NAME_PERFIL + "(" + COLUMN_SUMMONER_NAME + "));";

        sqLiteDatabase.execSQL(sql);

        sql = "CREATE TABLE " + TABLE_NAME_CAMPEAO + "(";
        sql += COLUMN_CAMPEAO_ID+ " TEXT NOT NULL, ";
        sql += COLUMN_CAMPEAO_NOME + " TEXT NOT NULL, ";
        sql += COLUMN_CAMPEAO_LEVEL + " TEXT, ";
        sql += COLUMN_GETCHAMPION_POINTS + " TEXT, ";
        sql += COLUMN_CAMPEAO_SUMMONERID + " TEXT NOT NULL,";
        sql += "FOREIGN KEY(" + COLUMN_CAMPEAO_SUMMONERID + ") " + "REFERENCES " + TABLE_NAME_PERFIL + "(" + COLUMN_ID+ "));";

        sqLiteDatabase.execSQL(sql);

        sql = "CREATE TABLE " + TABLE_NAME_PARTIDA + "(";
        sql += COLUMN_PARTIDA_CAMPEAO + " TEXT NOT NULL, ";
        sql += COLUMN_ROLE + " TEXT NOT NULL, ";
        sql += COLUMN_LANE + " TEXT NOT NULL, ";
        sql += COLUMN_REALLANE + " TEXT, ";
        sql += COLUMN_GAME_DURATION + " TEXT, ";
        sql += COLUMN_PARTICIPANTES + " TEXT, ";
        sql += COLUMN_PARTIDA_ID  + " TEXT PRIMARY KEY );";

        sqLiteDatabase.execSQL(sql);

        sql = "CREATE TABLE " + TABLE_NAME_PARTICIPANTE+ "(";
        sql += COLUMN_PARTICIPANTE_ID+ " TEXT NOT NULL, ";
        sql += COLUMN_WIN + " TEXT NOT NULL, ";
        sql += COLUMN_PARTICIPANTE_PROFILEICON+ " TEXT NOT NULL, ";
        sql += COLUMN_GOLD_EARNED + " TEXT NOT NULL, ";
        sql += COLUMN_DEATHS + " TEXT NOT NULL, ";
        sql += COLUMN_KILLS + " TEXT NOT NULL, ";
        sql += COLUMN_ASSISTIS + " TEXT NOT NULL, ";
        sql += COLUMN_PARTICIPANTE_CAMPEAO_ID + " TEXT NOT NULL, ";
        sql += COLUMN_PARTICIPANTE_SUMMONERNAME + " TEXT NOT NULL, ";
        sql += COLUMN_PARTICIPANTE_PARTIDA_ID + " TEXT NOT NULL, ";
        sql += "FOREIGN KEY(" + COLUMN_PARTICIPANTE_SUMMONERNAME + ") REFERENCES " + TABLE_NAME_PERFIL + "(" + COLUMN_SUMMONER_NAME + "),";
        sql += "FOREIGN KEY(" + COLUMN_PARTICIPANTE_PARTIDA_ID + ") " + "REFERENCES " + TABLE_NAME_PARTIDA + "(" + COLUMN_PARTIDA_ID+ "));";

        sqLiteDatabase.execSQL(sql);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
