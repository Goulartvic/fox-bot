import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;



public class Bot {

    private PhantomConfig phantomConfig = new PhantomConfig();

    public void visitFoxBit() {

        phantomConfig.initialize();
        WebDriver phantomDriver = phantomConfig.getPhantomDriver();
        phantomDriver.get("https://foxbit.com.br/");

        String html = phantomDriver.getPageSource();

        Document document = Jsoup.parse(html);
        String bitcoinPrice = document.body()
                .select("body > div.header-container > div > div > div > div.cotacao.col-md-3.col-xs-12.pull-right > div > b")
                .text();

        System.out.println(bitcoinPrice);
    }

    public static void main(String[] args) {
        Bot bot = new Bot();
        bot.visitFoxBit();
    }
}
