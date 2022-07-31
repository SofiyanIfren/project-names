package project.names.http;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import project.names.model.Name;
import project.names.model.Origin;

import java.util.ArrayList;
import java.util.List;

public class HttpName {

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();
    private final String BEHIND_THE_NAME_URL = "https://www.behindthename.com/";

    public String getHtmlNamesPage (String origin){
        String url = "https://www.behindthename.com/names/usage/" + origin;
        return this.restTemplate.getForObject(url, String.class);
    }

    public List<Name> getNames (String htmlNamesPage){ // TODO : add origin as parameter
        Document doc = Jsoup.parseBodyFragment(htmlNamesPage);
        List<Element> elements = doc.getElementsByClass("browsename");
        List<Name> namesList = new ArrayList<>();
        for (Element el : elements){
            Name name = new Name();
            name.setName(el.getElementsByClass("listname").get(0).text());
            name.setLink(BEHIND_THE_NAME_URL + el.getElementsByClass("listname").get(0).select("a").attr("href"));
            name.setGender(el.getElementsByClass("listgender").get(0).text());
            name.setDescription(el.getElementsByClass("listusage").get(0).text());
            namesList.add(name);
        }
        return namesList;
    }

}
