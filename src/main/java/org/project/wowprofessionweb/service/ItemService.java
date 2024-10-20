package org.project.wowprofessionweb.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.project.wowprofessionweb.repository.ItemIdsConfig;
import org.project.wowprofessionweb.repository.ItemRepository;
import org.project.wowprofessionweb.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public void addAndSaveItems() {
        Map<String, Integer> itemIds = ItemIdsConfig.getItemIds();

        for (Map.Entry<String, Integer> entry : itemIds.entrySet()) {
            int itemId = entry.getValue();

            try {
                String url = "https://www.wowhead.com/ru/item=" + itemId;
                Document doc = Jsoup.connect(url).get();

                String itemName = doc.select("h1.heading-size-1").text();
                String itemLevel = getItemLevel(doc);
                String description = getDescription(doc);
                String maxInStack = getMaxInStack(doc);
                String sellingPrice = getSellingPrice(doc);
                String typeCurrency = getTypeCurrency(doc);
                String imageUrl = fetchImageUrl(doc);

                Repository item = new Repository();
                item.setName(itemName);
                item.setItemLvl(itemLevel);
                item.setDescription(description);
                item.setMaxInStack(maxInStack);
                item.setSellingPrice(sellingPrice);
                item.setIdItem(itemId);
                item.setUrlImage(imageUrl);
                item.setTypeCurrency(typeCurrency);

                itemRepository.save(item);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Методы для извлечения данных
    private String getItemLevel(Document doc) {
        Element levelElement = doc.select("span.whtt-extra.whtt-ilvl").first();
        return levelElement != null ? levelElement.ownText().split(":")[1].trim() : "Не найдено";
    }

    private String getDescription(Document doc) {
        return doc.select("span.q").get(1).ownText();
    }

    private String getMaxInStack(Document doc) {
        Element maxStackElement = doc.select("div.whtt-extra.whtt-maxstack").first();
        return maxStackElement != null ? maxStackElement.ownText().split(":")[1].trim() : "Не найдено";
    }

    private String getSellingPrice(Document doc) {
        Element sellPriceElement = doc.select("div.whtt-sellprice span").first();
        return sellPriceElement != null ? sellPriceElement.text() : "Не найдено";
    }

    private String getTypeCurrency(Document doc) {
        Element sellPriceElement = doc.select("div.whtt-sellprice span").first();
        String currencyType = "";
        if (sellPriceElement != null) {
            if (sellPriceElement.hasClass("moneysilver")) {
                currencyType = "серебра";
            } else if (sellPriceElement.hasClass("moneygold")) {
                currencyType = "золота";
            } else if (sellPriceElement.hasClass("moneybronze")) {
                currencyType = "бронзы";
            }
        }
        return currencyType;
    }

    private String fetchImageUrl(Document doc) {
        String url = "https://wow.zamimg.com/";
        String imageUrl = doc.select("meta[property=og:image]").attr("content");
        if (imageUrl.isEmpty()) {
            imageUrl = doc.select("meta[property=twitter:image]").attr("content");
        }
        if (imageUrl.startsWith("https://wow.zamimg.com/")) {
            imageUrl = imageUrl.replace("https://wow.zamimg.com/", "");
        }
        imageUrl = url + imageUrl;
        return imageUrl;
    }
}