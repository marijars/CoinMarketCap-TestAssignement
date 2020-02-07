package test.coinmarketcap.data;

public class Cryptocurrency {
    private int id;
    private String name;
    private int marketCap;
    private int price;
    private int volume24h;

    public Cryptocurrency() {
        setId(0);
        setName("");
        setMarketCap(0);
        setPrice(0);
        setVolume24h(0);
    }

    public Cryptocurrency(int id, String name, int marketCap, int price, int volume24h) {
        this.id = id;
        this.name = name;
        this.marketCap = marketCap;
        this.price = price;
        this.volume24h = volume24h;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(int marketCap) {
        this.marketCap = marketCap;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getVolume24h() {
        return volume24h;
    }

    public void setVolume24h(int volume24h) {
        this.volume24h = volume24h;
    }
}
