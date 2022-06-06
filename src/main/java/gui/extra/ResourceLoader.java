package main.java.gui.extra;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import javafx.scene.image.Image;
import main.java.pieces.Alliance;
import main.java.pieces.Piece;
import java.io.*;
import java.net.URL;

/**
 * Load all the resources into memory
 */
public class ResourceLoader {

    private static ResourceLoader resourceLoader = null;

    //Pieces
    public final Image BB, BK, BN, BP, BQ, BR, WB, WK, WN, WP, WQ, WR;

    //GUI images
    public final Image ConnoisseurChess, hintButton, undoButton, gameStats;

    //Rule text
    public final String horde, lightBrigade, tutor;

    //Sounds - not implemented

    private ResourceLoader() {
        BB = new Image("main/resources/images/" + "BB" + ".png");
        BK = new Image("main/resources/images/" + "BK" + ".png");
        BN = new Image("main/resources/images/" + "BN" + ".png");
        BP = new Image("main/resources/images/" + "BP" + ".png");
        BQ = new Image("main/resources/images/" + "BQ" + ".png");
        BR = new Image("main/resources/images/" + "BR" + ".png");

        WB = new Image("main/resources/images/" + "WB" + ".png");
        WK = new Image("main/resources/images/" + "WK" + ".png");
        WN = new Image("main/resources/images/" + "WN" + ".png");
        WP = new Image("main/resources/images/" + "WP" + ".png");
        WQ = new Image("main/resources/images/" + "WQ" + ".png");
        WR = new Image("main/resources/images/" + "WR" + ".png");

        hintButton = new Image("main/resources/images/GUI/HintButton.png");
        undoButton = new Image("main/resources/images/GUI/UndoButton.png");
        gameStats = new Image("main/resources/images/GUI/GameStats.png");
        ConnoisseurChess = new Image("main/resources/images/GUI/" + "ConnoisseurChess" + ".png");

        horde = readFile("main/resources/rules/horde.txt");
        lightBrigade = readFile("main/resources/rules/lightbrigade.txt");
        tutor = readFile("main/resources/rules/tutor.txt");
    }

    public static ResourceLoader getInstance() {
        if (resourceLoader == null) {
            resourceLoader = new ResourceLoader();
        }
        return resourceLoader;
    }

    /**
     * Find an image to represent a piece
     *
     * @param p piece to find image for
     * @return image representation of piece
     */
    public Image getPieceImage(Piece p) {
        Alliance pieceAlliance = p.getPieceAlliance();
        boolean isWhite = pieceAlliance == Alliance.WHITE;
        switch (p.getPieceType()) {
            case BISHOP:
                return isWhite ? WB : BB;
            case KING:
                return isWhite ? WK : BK;
            case KNIGHT:
                return isWhite ? WN : BN;
            case PAWN:
                return isWhite ? WP : BP;
            case QUEEN:
                return isWhite ? WQ : BQ;
            case ROOK:
                return isWhite ? WR : BR;
            default:
                return null;
        }
    }

    /**
     * Reads a text file from a given location
     *
     * @param location of txt file
     * @return text contents of the file
     */
    private String readFile(String location) {
        URL url = Resources.getResource(location);
        String text = "";
        try {
            text = Resources.toString(url, Charsets.UTF_8);
        } catch (IOException e) {
            System.out.println("AN ERROR OCCURRED WHEN READING RULE FILES");
            e.printStackTrace();
        }
        return text;
    }
}