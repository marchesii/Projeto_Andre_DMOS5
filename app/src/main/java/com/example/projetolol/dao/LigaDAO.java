package com.example.projetolol.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.projetolol.model.Liga;

import java.util.List;

public class LigaDAO {

    private SQLiteDatabase mSqLiteDatabase;
    private SQLiteHelper mHelper;

    public LigaDAO(Context context) { mHelper = new SQLiteHelper(context); }

    public void add(List<Liga> ligas) throws NullPointerException {
        if (ligas == null) {
            throw new NullPointerException("Liga inválida");
        }

        for(Liga liga : ligas){

            ContentValues valores = new ContentValues();
            valores.put(SQLiteHelper.COLUMN_QUEUETYPE, liga.getQueueType());
            valores.put(SQLiteHelper.COLUMN_TIER, liga.getTier());
            valores.put(SQLiteHelper.COLUMN_RANK, liga.getRank());
            valores.put(SQLiteHelper.COLUMN_LIGA_SUMMONER_ID, liga.getSummonerId());
            valores.put(SQLiteHelper.COLUMN_LIGA_SUMMONER_NAME, liga.getSummonerName());
            valores.put(SQLiteHelper.COLUMN_LIGA_WINS, liga.getWins());
            valores.put(SQLiteHelper.COLUMN_LIGA_LOSSES, liga.getLosses());

            mSqLiteDatabase = mHelper.getWritableDatabase();
            mSqLiteDatabase.insert(SQLiteHelper.TABLE_NAME_LIGA, null, valores);
            mSqLiteDatabase.close();

        }




    }

    public Liga getLiga(String type, String summoner){
        Cursor mCursor;
        Liga mLiga = null;

        String sql= "SELECT *" + " FROM " + SQLiteHelper.TABLE_NAME_LIGA + " WHERE " + SQLiteHelper.COLUMN_QUEUETYPE + " = ?" + " AND " + SQLiteHelper.COLUMN_LIGA_SUMMONER_NAME + " = ?";

        String argumentos[] = new String[]{
                type,
                summoner
        };

        mSqLiteDatabase = mHelper.getReadableDatabase();

        mCursor = mSqLiteDatabase.rawQuery(sql, argumentos);

        while (mCursor.moveToNext()){
            mLiga = new Liga(
                    mCursor.getString(0),
                    mCursor.getString(1),
                    mCursor.getString(2),
                    mCursor.getString(3),
                    mCursor.getString(6),
                    Integer.parseInt(mCursor.getString(4)),
                    Integer.parseInt(mCursor.getString(5))

            );

        }

        mCursor.close();
        mSqLiteDatabase.close();
        return mLiga;
    }

}
