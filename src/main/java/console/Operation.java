package console;

public enum Operation {
    CONVERT_FROM_FILE, CREATE_JSON_FOR_NEW_MEASURE, ADD_MEASURE, SHOW_ALL_MEASURE, EXIT;


    public static Operation getAllowableOperationByOrdinal(Integer i)
    {

        switch (i)
        {
            case 1: return CONVERT_FROM_FILE;

            case 2: return CREATE_JSON_FOR_NEW_MEASURE;

            case 3: return ADD_MEASURE;

            case 4: return SHOW_ALL_MEASURE;

            case 5: return EXIT;



            default: throw new IllegalArgumentException();
        }

    }
}
