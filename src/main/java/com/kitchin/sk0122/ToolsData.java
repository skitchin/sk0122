package com.kitchin.sk0122;

import java.util.HashMap;
import java.util.Map;

public class ToolsData {

    /**
     * A map of tools available for rental. Each element in the array is an object array containing:
     *
     *   Tool code (String)
     *   Tool type (String)
     *   Brand (String)
     *   Daily charge (double)
     *   Weekday charge (boolean)
     *   Weekend charge (boolean)
     *   Holiday charge (boolean)
     *
     */
    private static final Map<String, Object> tools = new HashMap<>();

    static {
        tools.put("CHNS", new Tools("CHNS", "Chainsaw", "Stihl", 1.49, true, false, true));
        tools.put("LADW", new Tools("LADW", "Ladder", "Werner", 1.99, true, true, false));
        tools.put("JAKD", new Tools("JAKD", "Jackhammer", "DeWalt", 2.99, true, false, false));
        tools.put("JAKR", new Tools("JAKR", "Jackhammer", "Ridgid", 2.99, true, false, false));
    }

    /**
     * Retrieves the map of tools available for rental.
     *
     * @return a map where the key is the tool code and the value is an object representing the tool details.
     */
    public static Map<String, Object> getTools() {
        return tools;
    }
}
