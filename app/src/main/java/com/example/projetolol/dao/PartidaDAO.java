package com.example.projetolol.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.projetolol.model.Partida;

import java.util.ArrayList;
import java.util.List;

public class PartidaDAO {

    private SQLiteDatabase mSqLiteDatabase;
    private SQLiteHelper mHelper;

    public PartidaDAO(Context context) { mHelper = new SQLiteHelper(context); }

    public void add(Partida partida) throws NullPointerException {
        if (partida == null) {
            throw new NullPointerException("Partida inválida");
        }

        ContentValues valores = new ContentValues();
        valores.put(SQLiteHelper.COLUMN_PARTIDA_CAMPEAO, partida.getChampion());
        valores.put(SQLiteHelper.COLUMN_ROLE, partida.getRole());
        valores.put(SQLiteHelper.COLUMN_LANE, partida.getLane());
        valores.put(SQLiteHelper.COLUMN_REALLANE, partida.getRealLane());
        valores.put(SQLiteHelper.COLUMN_GAME_DURATION, partida.getGameDuration());
        valores.put(SQLiteHelper.COLUMN_PARTICIPANTES, partida.getParticipants().toString());
        valores.put(SQLiteHelper.COLUMN_PARTIDA_ID, partida.getGameId());

        mSqLiteDatabase = mHelper.getWritableDatabase();
        mSqLiteDatabase.insert(SQLiteHelper.TABLE_NAME_PARTIDA, null, valores);
        mSqLiteDatabase.close();
    }

    public List<Partida> allByChamp(String id, String champ){
        List<Partida> mPartidaList;
        Partida mPartida;
        Cursor mCursor;

        mPartidaList = new ArrayList<>();

        String sql= "SELECT * FROM " + SQLiteHelper.TABLE_NAME_PARTIDA+ " WHERE " + SQLiteHelper.COLUMN_ID + " = ?" + " AND " + SQLiteHelper.COLUMN_PARTIDA_CAMPEAO + " = ?";

        String argumentos[] = new String[]{
                id,
                champ
        };



        mSqLiteDatabase = mHelper.getReadableDatabase();

        mCursor = mSqLiteDatabase.rawQuery(sql, argumentos);

        while (mCursor.moveToNext()){
            mPartida = new Partida(
                    Integer.parseInt(mCursor.getString(0)),
                    mCursor.getString(1),
                    mCursor.getString(2),
                    mCursor.getString(3),
                    Integer.parseInt(mCursor.getString(4))
            );
            mPartidaList.add(mPartida);
        }


        mCursor.close();
        mSqLiteDatabase.close();
        return mPartidaList;
    }


    public List<Partida> allBySumonner(String id){
        List<Partida> mPartidaList;
        Partida mPartida;
        Cursor mCursor;

        mPartidaList = new ArrayList<>();

        String sql= "SELECT * FROM " + SQLiteHelper.TABLE_NAME_PARTIDA+ " WHERE " + SQLiteHelper.COLUMN_ID + " = ?";

        String argumentos[] = new String[]{
                id
        };



        mSqLiteDatabase = mHelper.getReadableDatabase();

        mCursor = mSqLiteDatabase.rawQuery(sql, argumentos);

        while (mCursor.moveToNext()){
            mPartida = new Partida(
                    Integer.parseInt(mCursor.getString(0)),
                    mCursor.getString(1),
                    mCursor.getString(2),
                    mCursor.getString(3),
                    Integer.parseInt(mCursor.getString(4))
            );
            mPartidaList.add(mPartida);
        }


        mCursor.close();
        mSqLiteDatabase.close();
        return mPartidaList;
    }
}
