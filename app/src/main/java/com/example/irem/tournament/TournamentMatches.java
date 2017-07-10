package com.example.irem.tournament;

/**
 * Created by cemdeniz on 10.07.2017.
 */

public class TournamentMatches {


    private String First;

    public String getSec() {
        return Sec;
    }

    public void getSec(String s) {

        this.Sec = s;
    }

    private String Sec;

    public TournamentMatches(String f){

        this.First=f;
    }

    public TournamentMatches() {
    }

    public String getFirst(){

        return First;
    }


}
