package com.example.projetolol.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.projetolol.model.Campeao;

public class CampeaoDAO {

    private SQLiteDatabase mSqLiteDatabase;
    private SQLiteHelper mHelper;

    public CampeaoDAO(Context context) { mHelper = new SQLiteHelper(context); }

    public void add(Campeao campeao) throws NullPointerException {
        if (campeao == null) {
            throw new NullPointerException("Campeao inválido");
        }

        ContentValues valores = new ContentValues();
        valores.put(SQLiteHelper.COLUMN_CAMPEAO_ID, campeao.getId());
        valores.put(SQLiteHelper.COLUMN_CAMPEAO_NOME, campeao.getNome());
        valores.put(SQLiteHelper.COLUMN_CAMPEAO_LEVEL, campeao.getChampion_level());
        valores.put(SQLiteHelper.COLUMN_GETCHAMPION_POINTS, campeao.getGetChampion_points());
        valores.put(SQLiteHelper.COLUMN_CAMPEAO_SUMMONERID, campeao.getSummonerId());


        mSqLiteDatabase = mHelper.getWritableDatabase();
        mSqLiteDatabase.insert(SQLiteHelper.TABLE_NAME_CAMPEAO, null, valores);
        mSqLiteDatabase.close();
    }
}
