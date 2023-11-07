package com.BurgueraCallesArnau.s05t02n01.utils;

public class Constants {
    //ENDPOINTS
    public static final String playerControllerRequestMapping = "/players";
    public static final String createPlayer = "/create";
    public static final String updatePlayerName = "/update/{id}";

    //SWAGGER
    public static final String swaggerTagName = "Dice Game";
    public static final String swaggerTagDescription = "Operations pertaining to a Dice Game and its player Management";
    public static final String createPlayerSummary = "Player creation";
    public static final String createPlayerDescription = "This API allows you to create a new players.";
    public static final String createPlayerParamDescr = "Player object";
    public static final String updatePlayerSummary = "Player update";
    public static final String updatePlayerDescr = "This API allows you to update existing players.";
    public static final String updatePlayerParamDescr = "Player id and New Player name";

}
