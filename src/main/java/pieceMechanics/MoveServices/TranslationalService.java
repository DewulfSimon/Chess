package pieceMechanics.MoveServices;


import boardMechanics.Field;

public class TranslationalService extends MoveServices {
    static TranslationalService translationalService = null;

    public static TranslationalService getTranslationalService(){
        if(translationalService == null) translationalService = new TranslationalService();
        return translationalService;
    }

    /**
     * provides Translational movement to Rooks and Queens
     *
     */







    @Override
    boolean move(Field start, Field target) {
        return false;
    }
}
