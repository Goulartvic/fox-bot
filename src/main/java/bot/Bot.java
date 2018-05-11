package bot;

import configs.PhantomConfig;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;



public class Bot {

    private PhantomConfig phantomConfig = new PhantomConfig();

    public String getBitcoinPrice() {

        phantomConfig.initialize();
        WebDriver phantomDriver = phantomConfig.getPhantomDriver();
        phantomDriver.get("https://foxbit.com.br/");

        String html = phantomDriver.getPageSource();
        phantomDriver.close();

        Document document = Jsoup.parse(html);
        String bitcoinPrice = document.body()
                .select("body > div.header-container > div > div > div > div.cotacao.col-md-3.col-xs-12.pull-right > div > b")
                .text();

        return bitcoinPrice;
    }
}
