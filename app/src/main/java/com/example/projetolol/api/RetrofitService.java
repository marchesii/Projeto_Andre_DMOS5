package com.example.projetolol.api;

import com.example.projetolol.model.Campeao;
import com.example.projetolol.model.Liga;
import com.example.projetolol.model.Partida;
import com.example.projetolol.model.Perfil;
import com.example.projetolol.model.Servidor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {
    
    String key = "api_key=RGAPI-a04939bf-df44-43e2-a363-8d8e7d1b0b30";

    @GET("summoner/v4/summoners/by-name/{summonerName}?"+key)
    Call<Perfil> getPerfilDadosBasicos(@Path("summonerName") String summonerName);

    @GET("champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}?"+key)
    Call<List<Campeao>> getCampeaoMaestriaDados(@Path("encryptedSummonerId") String summonerId);

    @GET("status/v3/shard-data?"+key)
    Call<Servidor> getStatus(@Path("status") String status);

    @GET("match/v4/matchlists/by-account/{encryptedAccountId}?"+key)
    Call<List<Partida>> getPartidaDados(@Path("encryptedAccountId") String summonerId);


    @GET("match/v4/matchlists/by-account/{encryptedAccountId}?"+key + "/?beginIndex={beginIndex}")
    Call<List<Partida>> getPartidaDadosPorIndex(@Path("encryptedAccountId") String summonerId, @Path("beginIndex") int beginIndex);


    @GET("league/v4/entries/by-summoner/{encryptedSummonerId}?"+key)
    Call<List<Liga>> getLigaDados(@Path("encryptedSummonerId") String summonerId);


    @GET("lol/match/v4/matches/{matchId}?"+key)
    Call<List<Liga>> getPartida(@Path("matchId") String summonerId);

    //http://ddragon.leagueoflegends.com/cdn/10.21.1/img/profileicon/588.png
    @GET("http://ddragon.leagueoflegends.com/cdn/10.21.1/img/profileicon/{iconId}/.png")
    Call<String> getIconImage(@Path("iconId") String iconId);
}

