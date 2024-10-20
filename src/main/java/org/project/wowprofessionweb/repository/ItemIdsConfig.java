package org.project.wowprofessionweb.repository;

import java.util.HashMap;
import java.util.Map;

public class ItemIdsConfig {

    public static final Map<String, Integer> ITEM_IDS = new HashMap<>();

    static {
        ITEM_IDS.put("mycobloom", 210797);
        ITEM_IDS.put("blessingBlossom", 210805);
        ITEM_IDS.put("luredrop", 210800);
        ITEM_IDS.put("arathorsSpear", 210808);
        ITEM_IDS.put("nullLotus", 213197);
    }

    public static Map<String, Integer> getItemIds() {
        return ITEM_IDS;
    }
}