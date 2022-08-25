package com.lang.affichage;

public class Score {

    // variables

    private final int NBRE_TOTAL_PIECES = 10;
    private int nbrePieces;

    // constructor

    public Score(){
        this.nbrePieces = 0;
    }

    // getters

    public int getNbrePieces(){
        return nbrePieces;
    }

    public int getNBRE_TOTAL_PIECES(){
        return NBRE_TOTAL_PIECES;
    }

    // setters

    public void setNbrePieces(int nbrePieces){
        this.nbrePieces = nbrePieces;
    }
}
