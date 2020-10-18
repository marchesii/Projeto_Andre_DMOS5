package com.example.projetolol.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.projetolol.model.Perfil;

public class PerfilDAO {

    private SQLiteDatabase mSqLiteDatabase;
    private SQLiteHelper mHelper;

    public PerfilDAO(Context context) { mHelper = new SQLiteHelper(context); }

    public void add(Perfil perfil) throws NullPointerException{
        if(perfil == null){
            throw new NullPointerException("Perfil inválido");
        }

        ContentValues valores = new ContentValues();
        valores.put(SQLiteHelper.COLUMN_PUUID, perfil.getPuuid());
        valores.put(SQLiteHelper.COLUMN_ENCRYPTED_SUMMONERID, perfil.getEncryptedSummonerId());
        valores.put(SQLiteHelper.COLUMN_ID, perfil.getAccountId());
        valores.put(SQLiteHelper.COLUMN_SUMMONER_NAME, perfil.getSummonerName());
        valores.put(SQLiteHelper.COLUMN_PROFILE_ICONID, perfil.getProfileIconId());
        valores.put(SQLiteHelper.COLUMN_LEVEL, perfil.getLevel());

        mSqLiteDatabase = mHelper.getWritableDatabase();
        mSqLiteDatabase.insert(SQLiteHelper.TABLE_NAME_PERFIL, null, valores);
        mSqLiteDatabase.close();

    }

    public Perfil getPerfil(String nome){
        Cursor mCursor;
        Perfil mPerfil = null;

        String sql= "SELECT *" + " FROM " + SQLiteHelper.TABLE_NAME_PERFIL + " WHERE " + SQLiteHelper.COLUMN_SUMMONER_NAME + " = ?";

        String argumentos[] = new String[]{
                nome
        };

        mSqLiteDatabase = mHelper.getReadableDatabase();

        mCursor = mSqLiteDatabase.rawQuery(sql, argumentos);

        while (mCursor.moveToNext()){
            mPerfil = new Perfil(
                    mCursor.getString(0),
                    mCursor.getString(1),
                    mCursor.getString(2),
                    Integer.parseInt(mCursor.getString(3)),
                    Integer.parseInt(mCursor.getString(4)),
                    mCursor.getString(5)
            );
        }

        mCursor.close();
        mSqLiteDatabase.close();
        return mPerfil;
    }
}
