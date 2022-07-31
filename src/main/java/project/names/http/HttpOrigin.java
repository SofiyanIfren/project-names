package project.names.http;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import project.names.model.Origin;

import java.util.ArrayList;
import java.util.List;

public class HttpOrigin {

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    public String getHtmlOriginsPage (){
        String url = "https://www.behindthename.com/names/list.php";
        return this.restTemplate.getForObject(url, String.class);
    }

    public List<Origin> getOrigins(String htmlOriginsPage){  // TODO : remplacer json par name object
        Document doc = Jsoup.parseBodyFragment(htmlOriginsPage);
        List<Element> elements = doc.getElementsByClass("usagelist");
        List<Origin> originsList = new ArrayList<>();
        for (Element usageListElement : elements){
            List<Element> divList = usageListElement.select("div");

            for (Element divElement : divList){
                Elements ethnicGroupList = divElement.select("ul > li > a");
                for (Element ethnicGroup : ethnicGroupList){
                    Element parentsTag = ethnicGroup.parent().parent().parent();
                    Elements originList = parentsTag.select("h3");
                    Origin origin = new Origin();
                    origin.setOriginGroup(originList.get(0).text());
                    origin.setEthnicGroup(ethnicGroup.text());
                    originsList.add(origin);
                }
            }
        }
        return originsList;
    }


}
