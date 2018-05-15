package bot;

import configs.ChromeConfig;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;



public class Bot {

    private ChromeConfig chromeConfig = new ChromeConfig();

    public String getBitcoinPrice() {

        chromeConfig.initialize();
        WebDriver chromeDriver = chromeConfig.getChromeDriver();
        chromeDriver.get("https://foxbit.com.br/");

        String html = chromeDriver.getPageSource();
        chromeDriver.close();

        Document document = Jsoup.parse(html);
        String bitcoinPrice = document.body()
                .select("body > div.header-container > div > div > div > div.cotacao.col-md-3.col-xs-12.pull-right > div > b")
                .text();

        return bitcoinPrice;
    }
}
