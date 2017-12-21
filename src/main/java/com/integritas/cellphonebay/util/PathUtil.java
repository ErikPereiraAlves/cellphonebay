package com.integritas.cellphonebay.util;


public class PathUtil {

    public static final String LINEBREAK = "\r\n";

    public static final String BASE_URI = "/cellphonebay";


    public static final String ORDER = "/order";

    public static final String PRODUCT = "/product";

    public static final String USER = "/user";


    public static final String ALL = "/all";

    public static final String SINGLE = "/single";

    public static final String SAVE = "/save";

    public static final String UPDATE = "/update";

    public static final String DELETE = "/delete";

    public enum ServicesAvailable {
        ALL,
        SINGLE,
        UPDATE,
        DELETE,
        SAVE
    }


}
