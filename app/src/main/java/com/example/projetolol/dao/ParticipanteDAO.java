package com.example.projetolol.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.projetolol.model.Participante;

import java.util.ArrayList;
import java.util.List;

public class ParticipanteDAO {

    private SQLiteDatabase mSqLiteDatabase;
    private SQLiteHelper mHelper;

    public ParticipanteDAO(Context context) { mHelper = new SQLiteHelper(context); }

    public void add(Participante participante) throws NullPointerException {
        if (participante == null) {
            throw new NullPointerException("Participante inválido");
        }

        ContentValues valores = new ContentValues();
        valores.put(SQLiteHelper.COLUMN_PARTICIPANTE_ID, participante.getParticipantId());
        valores.put(SQLiteHelper.COLUMN_WIN, participante.getWin());
        valores.put(SQLiteHelper.COLUMN_PARTICIPANTE_PROFILEICON, participante.getProfileIcon());
        valores.put(SQLiteHelper.COLUMN_GOLD_EARNED, participante.getGoldEarned());
        valores.put(SQLiteHelper.COLUMN_DEATHS, participante.getDeaths());
        valores.put(SQLiteHelper.COLUMN_KILLS, participante.getKills());
        valores.put(SQLiteHelper.COLUMN_ASSISTIS, participante.getAssists());
        valores.put(SQLiteHelper.COLUMN_PARTICIPANTE_CAMPEAO_ID, participante.getChampionId());
        valores.put(SQLiteHelper.COLUMN_PARTICIPANTE_SUMMONERNAME, participante.getSummonerName());
        valores.put(SQLiteHelper.COLUMN_PARTIDA_ID, participante.getPartidaId());

        mSqLiteDatabase = mHelper.getWritableDatabase();
        mSqLiteDatabase.insert(SQLiteHelper.TABLE_NAME_PARTICIPANTE, null, valores);
        mSqLiteDatabase.close();
    }

    public List<Participante> getParticipantes(String partidaId){
        List<Participante> mParticipanteList;
        Cursor mCursor;
        Participante mParticipante = null;

        mParticipanteList = new ArrayList<>();

        String sql= "SELECT *" + " FROM " + SQLiteHelper.TABLE_NAME_PARTICIPANTE + " WHERE " + SQLiteHelper.COLUMN_PARTIDA_ID + " = ?";

        String argumentos[] = new String[]{
                partidaId
        };

        mSqLiteDatabase = mHelper.getReadableDatabase();

        mCursor = mSqLiteDatabase.rawQuery(sql, argumentos);

        while (mCursor.moveToNext()){
            mParticipante = new Participante(
                    Integer.parseInt(mCursor.getString(0)),
                    mCursor.getString(1),
                    mCursor.getString(2),
                    Integer.parseInt(mCursor.getString(3)),
                    Integer.parseInt(mCursor.getString(4)),
                    Integer.parseInt(mCursor.getString(5)),
                    Integer.parseInt(mCursor.getString(6)),
                    Integer.parseInt(mCursor.getString(7)),
                    Integer.parseInt(mCursor.getString(8)),
                    Integer.parseInt(mCursor.getString(9))
            );
            mParticipanteList.add(mParticipante);
        }

        mCursor.close();
        mSqLiteDatabase.close();
        return mParticipanteList;
    }

}
